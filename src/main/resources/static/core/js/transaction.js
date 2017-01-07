$.widget("ui.autocomplete", $.ui.autocomplete, {
    _renderMenu: function(ul, items) {
        var that = this;
        ul.attr("class", "nav nav-pills nav-stacked  bs-autocomplete-menu");
        $.each(items, function(index, item) {
            that._renderItemData(ul, item);
        });
    },
    _resizeMenu: function() {
        var ul = this.menu.element;
        ul.outerWidth(Math.min(
            ul.width("").outerWidth() + 1,
            this.element.outerWidth()
        ));
    }
});

$('#search-product').autocomplete({
    source: function (request, response) {
        $.post("http://localhost:8090/product/search", request, response)
    },
    minLength: 2,
    select: function( event, ui ) {
        $('#search-product').val("");
        $('#render-transaksi').append(tableRow(ui.item.productId, ui.item.productName, ui.item.productPrice));
        updateGrossAmount();
    }
}).autocomplete("instance")._renderItem = function (ul, item) {
    return $("<li>")
        .append("<div>"+item.productName+"</div>")
        .appendTo(ul);
};

var tableRow = function (productId, productName, productPrice) {
    if($("#"+productId).length == 0)
    {
        return "<tr id="+productId+">" +
            "<td id='product-id'>"+productId+"</td>" +
            "<td id='product-name'>"+productName+"</td>" +
            "<td><input type='number' min='1' max='99' class='form-control' id='quantity' data-price='"+productPrice+"' value='1' onkeyup='updateQuantity(this)' onchange='updateQuantity(this)'/></td>" +
            "<td id='render-price'>"+productPrice+"</td>" +
            "<td><button class='btn btn-danger' onclick='cancelItem(this)'><i class='fa fa-trash'></i></button></td>" +
            "</tr>"
    }
    else
    {
        var oldQuantity     = $("#"+productId).find("#quantity").val();
        var newQuantity     = 1 + parseInt(oldQuantity);
        var basePrice       = $("#"+productId).find("#quantity").data("price");
        var subTotal        = basePrice * newQuantity;
        $("#"+productId).find("#render-price").text(subTotal);
        $("#"+productId).find("#quantity").val(newQuantity);
        updateGrossAmount();

    }
};

function updateQuantity(position) {
    var basePrice       = 0;
    var itemQuantity    = 0;
    var subTotal        = 0;
    if(parseInt($(position).val()) <= 0)
    {
        basePrice    = $(position).data('price');
        itemQuantity = $(position).val("1");
        subTotal     = basePrice * itemQuantity;
        $(position).closest("tr").find("#render-price").text(subTotal);
    }
    else
    {
        basePrice       = $(position).data('price');
        itemQuantity    = $(position).val();
        subTotal        = basePrice * itemQuantity;
        $(position).closest("tr").find("#render-price").text(subTotal);
    }
    updateGrossAmount();
}

function updateGrossAmount()
{
    var grossAmount = 0;
    $("#render-transaksi > tr").each(function () {
        grossAmount += parseInt($(this).find("#render-price").text());
    });
    $("#gross-amount").val(grossAmount);
}

function cancelItem(position) {
    $(position).closest('tr').remove();
    updateGrossAmount();
}

function submitTransaction(event) {
    event.preventDefault();
    var serialize = {
        sales_name: $('#sales-name').val(),
        transaction_date: $('#transaction-date').val(),
        gross_amount: $('#gross-amount').val(),
        item_data: []
    };
    $("#render-transaksi > tr").each(function () {
        serialize.item_data.push({
            "product_id": $(this).find("#product-id").text(),
            "product_name": $(this).find("#product-name").text(),
            "product_quantity": $(this).find("#quantity").val(),
            "product_subtotal": $(this).find("#render-price").text()
        });
    });

    console.log(serialize);

    $.post("/transaction/submit", serialize);
}
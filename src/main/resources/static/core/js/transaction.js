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
        "salesName": $('#sales-name').val(),
        "transactionDate": $('#transaction-date').val(),
        "grossAmount": $('#gross-amount').val(),
        "totalItem": $("#render-transaksi tr").length,
        "itemData": []
    };
    $("#render-transaksi > tr").each(function () {
        serialize.itemData.push({
            "productId": $(this).find("#product-id").text(),
            "productName": $(this).find("#product-name").text(),
            "productQuantity": parseInt($(this).find("#quantity").val()),
            "productSubtotal": $(this).find("#render-price").text()
        });
    });
    console.log(serialize);
    $.ajax({
        url: "/transaction/submit",
        method: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(serialize),
        success: function (data) {
            if (data == "Success")
            {
                window.location.href = "http://localhost:8090/transaction";
            }
        }
    });
}
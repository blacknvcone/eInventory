# eInventory - 1.0.0-beta
E-Inventory Web Apps Using Spring 

Customization :
Port Server -> 8090 (Custom sendiri sendiri , default 8080)

#Always write a changes feature in here 
Log Development :
- Product Controller and DAO (Save, getAll)
- AdminLTE as Main CSS Framework
- Edit control ,dao,model and add service package , start using mysql .  …
  Be Carefully before run , see at application properties for user & pass mysql

  Data Control:
  Product -> Create (done), Read (done), Delete(?) , Edit(done)
  Transaction -> model data (done) waiting for sample json -> CRUD(?)
  User -> Only Create user (will be added soon)

  Urgent :
  Form Login !!
  
- Jquery UI Autocomplete in Transaction
- Serialize format
  {
    gross_amount: 12345,
    name_sales: "SPRING HORE",
    transaction_date: "yyyy-mm-dd",
    item: [{
      product_id: "x",
      product_name: "xxxx",
      product_quantity: "x",
      product_subtotal: "xxx"
    }]
  }
-





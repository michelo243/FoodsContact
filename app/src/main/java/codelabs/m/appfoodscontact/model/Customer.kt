package codelabs.m.appfoodscontact.model

class Customer {

    var id:Int=0
    var customer_name:String=""
    var customer_address:String=""
    var customer_phone:String=""
    var customer_email:String=""


    constructor(customer_name: String, customer_address: String, customer_phone: String, customer_email: String) {
        this.customer_name = customer_name
        this.customer_address = customer_address
        this.customer_phone = customer_phone
        this.customer_email = customer_email
    }

    constructor()


}
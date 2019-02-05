package codelabs.m.appfoodscontact.model

class User {

    var id:Int=0
    var name:String=""
    var email:String=""
    var password:String=""
    var address:String=""
    var userphone:String=""

    constructor(name:String, email:String, password:String){
        this.name=name
        this.email=email
        this.password=password
    }


    //null constructor
    constructor()

    constructor(name: String, email: String, password: String, address: String, userphone: String) {
        this.name = name
        this.email = email
        this.password = password
        this.address = address
        this.userphone = userphone
    }

}
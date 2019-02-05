package codelabs.m.appfoodscontact.model

class Traiteur {

    var id:Int=0
    var t_name:String=""
    var t_address:String=""
    var t_phone:String=""
    var t_email:String=""
    var t_specialite:String=""
    var t_latitude:Double=0.0
    var t_longitude:Double=0.0

    var image: ByteArray? = null


    //null constructor
    constructor()

    constructor(t_namer: String, t_address: String, t_phone: String, t_email: String, t_specialite: String, t_latitude: Double, t_longitude: Double)
    {
        this.t_name = t_namer
        this.t_address = t_address
        this.t_phone = t_phone
        this.t_email = t_email
        this.t_specialite = t_specialite
        this.t_latitude = t_latitude
        this.t_longitude = t_longitude
    }

    constructor(t_namer: String, t_address: String, t_phone: String, t_email: String, t_specialite: String)
    {
        this.t_name = t_namer
        this.t_address = t_address
        this.t_phone = t_phone
        this.t_email = t_email
        this.t_specialite = t_specialite
    }

}
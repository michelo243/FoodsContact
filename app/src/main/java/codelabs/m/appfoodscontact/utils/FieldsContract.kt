package codelabs.m.appfoodscontact.utils


/*
-- Michelo
cette classe permet de referencer une fois pour toute les variables pour la BD sqlite
 */
class FieldsContract {

    companion object {

        //For SharedPreferences
        var KEY_EMAIL = "email"
        var KEY_PASSWORD = "password"


        val FoodContactDB:String="FoodContactApp.db"

        //Customer table and fields
        val TableCustomer:String="Customer"
        val cust_id:String="id"
        val cust_name:String="customer_name"
        val cust_address:String="customer_address"
        val cust_phone:String="customer_phone"
        val cust_email:String="customer_email"
        //SQL de creation de la table Customer
        val Create_Table_Customer:String="CREATE TABLE " + TableCustomer + " ( " +
                cust_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                cust_name + " VARCHAR (100), " +
                cust_address + " VARCHAR (100), " +
                cust_phone + " VARCHAR (15), " +
                cust_email + " VARCHAR ) "
        //SQL du drop de la table Customer
        val DropTable_Customer:String="DROP TABLE IF EXISTS " + TableCustomer

        //User table and fields
        val TableUser:String="User"
        val User_id:String="id"
        val User_name:String="name"
        val User_email:String="email"
        val User_password:String="password"
        val User_address:String="address"
        val User_phone:String="userphone"
        //SQL de creation de la table User
        val CreateTable_User:String="CREATE TABLE " + TableUser + " ( " +
                User_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                User_name + " VARCHAR (50), " +
                User_email + " VARCHAR (100), " +
                User_password + " VARCHAR," +
                User_address + " VARCHAR (100), " +
                User_phone + " VARCHAR (15)) "
        //SQL du drop de la table user
        val DropTable_User:String="DROP TABLE IF EXISTS " + TableUser

        //Traiteur table and fields
        val TableTraiteur:String="Traiteur"
        val Traiteur_id:String="id"
        val Traiteur_name:String="t_name"
        val Traiteur_address:String="t_address"
        val Traiteur_phone:String="t_phone"
        val Traiteur_email:String="t_email"
        val Traiteur_spec:String="t_specialite"
        val Traiteur_lat:String="t_latitude"
        val Traiteur_long:String="t_longitude"

        //SQL de creation de la table traiteur
        val CreateTable_Traiteur:String="CREATE TABLE " + TableTraiteur + " ( " +
                Traiteur_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Traiteur_name + " VARCHAR, " +
                Traiteur_address + " VARCHAR (100), " +
                Traiteur_phone + " VARCHAR (15), " +
                Traiteur_email + " VARCHAR (100), " +
                Traiteur_spec + " VARCHAR, " +
                Traiteur_lat + " DOUBLE, " +
                Traiteur_long + " DOUBLE ) "
        //SQL du drop de la table Traiteur
        val DropTable_Traiteur:String="DROP TABLE IF EXISTS " + TableTraiteur

    }


}
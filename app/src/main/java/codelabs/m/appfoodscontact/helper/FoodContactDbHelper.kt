package codelabs.m.appfoodscontact.helper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import codelabs.m.appfoodscontact.model.Customer
import codelabs.m.appfoodscontact.model.Traiteur
import codelabs.m.appfoodscontact.model.User
import codelabs.m.appfoodscontact.utils.FieldsContract
import java.sql.SQLException
import java.util.ArrayList

class FoodContactDbHelper:SQLiteOpenHelper {

    internal lateinit var mCtx: Context

    constructor(context: Context) : super(context, FieldsContract.FoodContactDB, null, 1) {
        this.mCtx = context
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(FieldsContract.Create_Table_Customer)
        db!!.execSQL(FieldsContract.CreateTable_User)
        db!!.execSQL(FieldsContract.CreateTable_Traiteur)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        try {
            db!!.execSQL(FieldsContract.DropTable_Customer)
            db!!.execSQL(FieldsContract.DropTable_Traiteur)
            db!!.execSQL(FieldsContract.DropTable_User)
            onCreate(db)
        }catch (e: SQLException){
            //........
        }
    }

    /*
    Table User
    ******************************************************************************************************************************************************
     */

    fun insererUsers(personne: User){
        val db=this.writableDatabase
        val cv= ContentValues()
        cv.put(FieldsContract.User_name,personne.name)
        cv.put(FieldsContract.User_email,personne.email)
        cv.put(FieldsContract.User_password,personne.password)
        cv.put(FieldsContract.User_address,personne.address)
        cv.put(FieldsContract.User_phone,personne.userphone)

        db.insert(FieldsContract.TableUser,null,cv)
        db.close()
    }

    fun userCheck(Email:String, Password:String): Boolean{
        val db=this.writableDatabase
        val qry="select * from ${FieldsContract.TableUser} where email = '" + Email.toString() + "'" + " and password =  '" + Password.toString() + "'"

        val cursor=db.rawQuery(qry,null)
        if(cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }

    //Retrieve all Users from the database
    fun get_AllUserData(ctx:Context): ArrayList<User> {
        val qry="select ${FieldsContract.User_id},${FieldsContract.User_email}, ${FieldsContract.User_name} from ${FieldsContract.TableUser}"
        val db=this.readableDatabase
        val cursor=db.rawQuery(qry,null)
        val humains= ArrayList<User>()
        if(cursor.count==0)
            Toast.makeText(ctx,"no record founds", Toast.LENGTH_LONG).show() else
        {
            while(cursor.moveToNext()){
                val hm=User()
                hm.id=cursor.getInt(cursor.getColumnIndex(FieldsContract.User_id))
                hm.email=cursor.getString(cursor.getColumnIndex(FieldsContract.User_email))
                hm.name=cursor.getString(cursor.getColumnIndex(FieldsContract.User_name))
                hm.address=cursor.getString(cursor.getColumnIndex(FieldsContract.User_address))
                hm.userphone=cursor.getString(cursor.getColumnIndex(FieldsContract.User_phone))
                humains.add(hm)
            }
            Toast.makeText(ctx,"${cursor.count.toString()} records found", Toast.LENGTH_LONG).show()
        }
        cursor.close()
        db.close()
        return humains
    }


    /*
    Table Customer
    ******************************************************************************************************************************************************
     */

    fun insertCustomer(customer: Customer){
        val db=this.writableDatabase
        val cv= ContentValues()
        cv.put(FieldsContract.cust_name,customer.customer_name)
        cv.put(FieldsContract.cust_email,customer.customer_email)
        cv.put(FieldsContract.cust_phone,customer.customer_phone)
        cv.put(FieldsContract.cust_address,customer.customer_address)

        db.insert(FieldsContract.TableCustomer,null,cv)
        db.close()
    }

    fun customerCheck(name:String): Customer{
        val db=this.writableDatabase
        val cm=Customer()
        val qry="select * from ${FieldsContract.TableCustomer} where customer_name = '" + name.toString() + "'"

        val cursor=db.rawQuery(qry,null)
        if(cursor.count>=0){
            cm.id=cursor.getInt(cursor.getColumnIndex(FieldsContract.cust_id))
            cm.customer_name=cursor.getString(cursor.getColumnIndex(FieldsContract.cust_name))
            cm.customer_email=cursor.getString(cursor.getColumnIndex(FieldsContract.cust_address))
            cm.customer_address=cursor.getString(cursor.getColumnIndex(FieldsContract.cust_address))
            cm.customer_phone=cursor.getString(cursor.getColumnIndex(FieldsContract.cust_phone))

            return cm
        }
        cursor.close()
        return cm
    }


    fun get_AllCustomers(ctx:Context): ArrayList<Customer> {
        val qry="select * from ${FieldsContract.TableUser}"
        val db=this.readableDatabase
        val cursor=db.rawQuery(qry,null)
        val customers= ArrayList<Customer>()
        if(cursor.count==0)
            Toast.makeText(ctx,"no record founds", Toast.LENGTH_LONG).show() else
        {
            while(cursor.moveToNext()){
                val cm=Customer()
                cm.id=cursor.getInt(cursor.getColumnIndex(FieldsContract.cust_id))
                cm.customer_name=cursor.getString(cursor.getColumnIndex(FieldsContract.cust_name))
                cm.customer_email=cursor.getString(cursor.getColumnIndex(FieldsContract.cust_address))
                cm.customer_address=cursor.getString(cursor.getColumnIndex(FieldsContract.cust_address))
                cm.customer_phone=cursor.getString(cursor.getColumnIndex(FieldsContract.cust_phone))
                customers.add(cm)
            }
            Toast.makeText(ctx,"${cursor.count.toString()} records found", Toast.LENGTH_LONG).show()
        }
        cursor.close()
        db.close()
        return customers
    }


    /*
    Table Traiteur
    ******************************************************************************************************************************************************
     */


    fun insertTraiteur(traiteur: Traiteur){
        val db=this.writableDatabase
        val cv= ContentValues()
        cv.put(FieldsContract.Traiteur_name,traiteur.t_name)
        cv.put(FieldsContract.Traiteur_address,traiteur.t_address)
        cv.put(FieldsContract.Traiteur_email,traiteur.t_email)
        cv.put(FieldsContract.Traiteur_phone,traiteur.t_phone)
        cv.put(FieldsContract.Traiteur_spec,traiteur.t_specialite)
        cv.put(FieldsContract.Traiteur_lat,traiteur.t_latitude)
        cv.put(FieldsContract.Traiteur_long,traiteur.t_longitude)

        db.insert(FieldsContract.TableTraiteur,null,cv)
        db.close()
    }

    fun traiteurCheck(name:String): Traiteur{
        val db=this.writableDatabase
        val tm=Traiteur()
        val qry="select * from ${FieldsContract.TableTraiteur} where t_name = '" + name.toString() + "'"

        val cursor=db.rawQuery(qry,null)
        if(cursor.count>=0){
            tm.id=cursor.getInt(cursor.getColumnIndex(FieldsContract.Traiteur_id))
            tm.t_name=cursor.getString(cursor.getColumnIndex(FieldsContract.Traiteur_name))
            tm.t_address=cursor.getString(cursor.getColumnIndex(FieldsContract.Traiteur_address))
            tm.t_email=cursor.getString(cursor.getColumnIndex(FieldsContract.Traiteur_email))
            tm.t_phone=cursor.getString(cursor.getColumnIndex(FieldsContract.Traiteur_phone))
            tm.t_specialite=cursor.getString(cursor.getColumnIndex(FieldsContract.Traiteur_spec))
            tm.t_latitude=cursor.getString(cursor.getColumnIndex(FieldsContract.Traiteur_lat)).toDouble()
            tm.t_longitude=cursor.getString(cursor.getColumnIndex(FieldsContract.Traiteur_long)).toDouble()

            return tm
        }
        cursor.close()
        return tm
    }


    fun get_AllTraiteurss(ctx:Context): ArrayList<Traiteur> {
        val qry="select * from ${FieldsContract.TableTraiteur}"
        val db=this.readableDatabase
        val cursor=db.rawQuery(qry,null)
        val traiteurs= ArrayList<Traiteur>()
        if(cursor.count==0)
            Toast.makeText(ctx,"no record founds", Toast.LENGTH_LONG).show() else
        {
            while(cursor.moveToNext()){
                val tm=Traiteur()
                tm.id=cursor.getInt(cursor.getColumnIndex(FieldsContract.Traiteur_id))
                tm.t_name=cursor.getString(cursor.getColumnIndex(FieldsContract.Traiteur_name))
                tm.t_address=cursor.getString(cursor.getColumnIndex(FieldsContract.Traiteur_address))
                tm.t_email=cursor.getString(cursor.getColumnIndex(FieldsContract.Traiteur_email))
                tm.t_phone=cursor.getString(cursor.getColumnIndex(FieldsContract.Traiteur_phone))
                tm.t_specialite=cursor.getString(cursor.getColumnIndex(FieldsContract.Traiteur_spec))
                tm.t_latitude=cursor.getString(cursor.getColumnIndex(FieldsContract.Traiteur_lat)).toDouble()
                tm.t_longitude=cursor.getString(cursor.getColumnIndex(FieldsContract.Traiteur_long)).toDouble()
                traiteurs.add(tm)
            }
            Toast.makeText(ctx,"${cursor.count.toString()} records found", Toast.LENGTH_LONG).show()
        }
        cursor.close()
        db.close()
        return traiteurs
    }

}
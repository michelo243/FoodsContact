package codelabs.m.appfoodscontact.ui_sqlite

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Button
import android.widget.Toast
import codelabs.m.appfoodscontact.HomeActivity
import codelabs.m.appfoodscontact.MainActivity
import codelabs.m.appfoodscontact.R
import codelabs.m.appfoodscontact.helper.FoodContactDbHelper
import codelabs.m.appfoodscontact.model.User
import kotlinx.android.synthetic.main.activity_sign_up.*

class RegisterSqliteActivity : AppCompatActivity() {

    lateinit var dbHelper: FoodContactDbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        dbHelper= FoodContactDbHelper(this)

        val button=findViewById<View>(R.id.btn_signUp) as Button

        //OnClickListener
        button.setOnClickListener { view ->

            if(!txtregemail.text.isEmpty() && !txtregpassword.text.isEmpty()){

                    //si oui, alors insert dans la base de donnees SQLite
                    var one_user=User(txtregusername.text.toString(),txtregemail.text.toString(),
                        txtregpassword.text.toString(),txtregaddress.text.toString(),txtregphone.text.toString())
                    //insertion dans la base des donnees sqlite
                    dbHelper.insererUsers(one_user)
                    //
                    Toast.makeText(this,"ok",Toast.LENGTH_LONG).show()

                    //ouvre une autre activity
                    startActivity(Intent(this,LoginSqliteActivity::class.java))
                    //vide les champs des donnees
                    viderEditText()
            } else {
                Toast.makeText(this,"Valeurs vides. Merci de completer svp !",Toast.LENGTH_LONG).show()
            }

        }




    }



    fun viderEditText(){
        txtregusername.text.clear()
        txtregemail.text.clear()
        txtregpassword.text.clear()
        txtregaddress.text.clear()
        txtregphone.text.clear()


    }



}

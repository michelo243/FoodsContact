package codelabs.m.appfoodscontact.ui_sqlite

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import codelabs.m.appfoodscontact.HomeActivity
import codelabs.m.appfoodscontact.MainActivity
import codelabs.m.appfoodscontact.R
import codelabs.m.appfoodscontact.helper.FoodContactDbHelper
import kotlinx.android.synthetic.main.activity_login.*

class LoginSqliteActivity : AppCompatActivity() {

    lateinit var dbHelper: FoodContactDbHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        dbHelper= FoodContactDbHelper(this)

        val lblSignUp=findViewById<View>(R.id.noAccount) as TextView
        val btnCon=findViewById<View>(R.id.button_signin) as Button

        lblSignUp.setOnClickListener { view ->
                startActivity(Intent(this,RegisterSqliteActivity::class.java))
        }

        btnCon.setOnClickListener { view->
            if (dbHelper.userCheck(edtUserEmail.text.toString(),edtPassword.text.toString())){
                //ouvrir l'intent vers le MainActivity
                val i=Intent(this,HomeActivity::class.java)
                i.putExtra("useremail",edtUserEmail.text.toString()) //on ajoute un bundle ici
                startActivity(i)
            }
        }

    }


}

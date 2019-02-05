package codelabs.m.appfoodscontact.ui_firebase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import codelabs.m.appfoodscontact.HomeActivity
import codelabs.m.appfoodscontact.MainActivity
import codelabs.m.appfoodscontact.R
import codelabs.m.appfoodscontact.helper.FoodContactDbHelper
import codelabs.m.appfoodscontact.ui_sqlite.RegisterSqliteActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginFbzActivity : AppCompatActivity() {

    companion object {
        val mAuth=FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val lblSignUp=findViewById<View>(R.id.noAccount) as TextView
        val btnCon=findViewById<View>(R.id.button_signin) as Button

        lblSignUp.setOnClickListener { view ->
                startActivity(Intent(this, RegisterFbzActivity::class.java))
        }

        btnCon.setOnClickListener { view->
                getLoginToFirebase()
        }

    }

    private fun getLoginToFirebase(){
        val emailTXT=findViewById<View>(R.id.edtUserEmail) as EditText
        val passwordTXT=findViewById<View>(R.id.edtPassword) as EditText

        val email=emailTXT.text.toString()
        val password=passwordTXT.text.toString()

        if(!email.isEmpty() && !password.isEmpty()){
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this,{task->
                if(task.isSuccessful){
                    startActivity(Intent(this,HomeActivityFbz::class.java))
                }else{
                    Toast.makeText(this,"connexion a la bd reussi",Toast.LENGTH_SHORT).show()
                }
            })
        }
        else
        {
            Toast.makeText(this,"Valeurs de connexion nulles",Toast.LENGTH_SHORT).show()
        }
    }


}

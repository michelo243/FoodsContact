package codelabs.m.appfoodscontact.ui_firebase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import codelabs.m.appfoodscontact.HomeActivity
import codelabs.m.appfoodscontact.MainActivity
import codelabs.m.appfoodscontact.R
import codelabs.m.appfoodscontact.helper.FoodContactDbHelper
import codelabs.m.appfoodscontact.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*

class RegisterFbzActivity : AppCompatActivity() {

    companion object {
        val mAuth=FirebaseAuth.getInstance()
        lateinit var dbFbz:DatabaseReference
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        dbFbz=FirebaseDatabase.getInstance().getReference("User")

        val button=findViewById<View>(R.id.btn_signUp) as Button

        //OnClickListener
        button.setOnClickListener { view ->

            val emailTXT=findViewById<View>(R.id.txtregemail) as EditText
            val passwordTXT=findViewById<View>(R.id.txtregpassword) as EditText
            val usernameTXT=findViewById<View>(R.id.txtregusername) as EditText
            val addressTXT=findViewById<View>(R.id.txtregaddress) as EditText
            val phoneTXT=findViewById<View>(R.id.txtregphone) as EditText

            val email=emailTXT.text.toString()
            val password=passwordTXT.text.toString()
            val username=usernameTXT.text.toString()
            val address=addressTXT.text.toString()
            val phone=phoneTXT.text.toString()


            if(!email.isEmpty() && !password.isEmpty() && !username.isEmpty()){

                val addOnCompleteListener = mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, { task ->
                        if (task.isSuccessful) {
                            val user = mAuth.currentUser
                            val uid = user!!.uid

                            dbFbz.child(uid).child("username").setValue(username)
                            dbFbz.child(uid).child("address").setValue(address)
                            dbFbz.child(uid).child("phone").setValue(phone)

                            Toast.makeText(this, "eurreur de connection sign up", Toast.LENGTH_LONG).show()

                            viderEditText()

                            //ouvre une autre activity
                            startActivity(Intent(this, LoginFbzActivity::class.java))


                        } else {
                            Toast.makeText(this, "eurreur de connection sign up", Toast.LENGTH_LONG).show()
                        }
                    })

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

package codelabs.m.appfoodscontact

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import codelabs.m.appfoodscontact.ui_firebase.LoginFbzActivity
import codelabs.m.appfoodscontact.ui_sqlite.LoginSqliteActivity
import kotlinx.android.synthetic.main.default_fragment.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.default_fragment)

        lyt_sqlite.setOnClickListener { view ->
            startActivity(Intent(this,LoginSqliteActivity::class.java))
        }

        lyt_firebase.setOnClickListener { view ->
            startActivity(Intent(this,LoginFbzActivity::class.java))
        }


    }
}

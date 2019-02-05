package codelabs.m.appfoodscontact.ui_firebase

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import codelabs.m.appfoodscontact.R
import codelabs.m.appfoodscontact.fragment.AddSqliteTraiteurFragment
import codelabs.m.appfoodscontact.fragment.DefaultFragment
import codelabs.m.appfoodscontact.fragment.ListSqliteTraiteurFragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*

class HomeActivityFbz : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        val tx = supportFragmentManager.beginTransaction()
        tx.replace(R.id.framefragmenthome, DefaultFragment())
        tx.commit()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_traiteur -> {
                // Handle the camera action
                val frag=ListSqliteTraiteurFragment()
                replaceFragment(frag,"Liste des traiteurs")
            }
            R.id.nav_food -> {

            }
            R.id.nav_customer -> {

            }
            R.id.nav_maps -> {

            }
            R.id.nav_paiement -> {

            }
            R.id.nav_about -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


    private fun replaceFragment(frgm:Fragment, name:String){
        val fm=supportFragmentManager.beginTransaction()
        fm.replace(R.id.framefragmenthome,frgm,name)
        fm.addToBackStack(null)
        fm.commit()
    }
}

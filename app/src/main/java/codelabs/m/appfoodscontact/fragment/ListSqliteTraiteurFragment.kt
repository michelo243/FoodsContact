package codelabs.m.appfoodscontact.fragment

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import codelabs.m.appfoodscontact.R
import codelabs.m.appfoodscontact.adapter.TraiteurListAdapter
import codelabs.m.appfoodscontact.helper.FoodContactDbHelper
import codelabs.m.appfoodscontact.utils.Communicator
import kotlinx.android.synthetic.main.traiteur_list_layout.*

class ListSqliteTraiteurFragment:Fragment() {

    companion object {
        lateinit var sqlidb:FoodContactDbHelper
        lateinit var mCtx:Context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v=LayoutInflater.from(container?.context).inflate(R.layout.traiteur_list_layout,container, false)

        mCtx=container!!.context

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sqlidb = FoodContactDbHelper(mCtx)

        fab_add_t.setOnClickListener { view ->
            /*Snackbar.make(view, "Ouverture de la feuille d'ajout traiteur", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()*/

            val myfragment = AddSqliteTraiteurFragment.newInstance()
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.framefragmenthome, myfragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()


        }

        //affiche la lliste dans le recyclerview
        viewAllTraiteur()
    }

    private fun viewAllTraiteur(){
        val traiteurlist= sqlidb.get_AllTraiteurss(mCtx)
        val adapter= TraiteurListAdapter(mCtx,traiteurlist)
        val rv: RecyclerView =view?.findViewById<View>(R.id.rcv_traiteur) as RecyclerView
        rv.layoutManager= LinearLayoutManager(context, LinearLayout.VERTICAL,false) as RecyclerView.LayoutManager

        rv.adapter=adapter
    }

    private fun swapFragment() {
        val myfragment = AddSqliteTraiteurFragment()
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.framefragmenthome, myfragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }



}
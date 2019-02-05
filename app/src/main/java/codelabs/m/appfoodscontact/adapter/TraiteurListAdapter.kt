package codelabs.m.appfoodscontact.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import codelabs.m.appfoodscontact.R
import codelabs.m.appfoodscontact.model.Traiteur
import kotlinx.android.synthetic.main.traiteur_item_row.view.*

class TraiteurListAdapter(ctx:Context, val traiteurs:ArrayList<Traiteur>) :RecyclerView.Adapter<TraiteurListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v=LayoutInflater.from(p0.context).inflate(R.layout.traiteur_item_row,p0,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return traiteurs.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val traiteur:Traiteur=traiteurs[p1]
        p0.txtaddress.text=traiteur.t_address.toString()
        p0.txtname.text=traiteur.t_name.toString()
        p0.txtphone.text=traiteur.t_phone.toString()
        p0.txtspecs.text=traiteur.t_specialite.toString()

        p0.itemView.setOnClickListener{

            val adresse= traiteur.t_address.toString()
            Toast.makeText(ctx," your place is $adresse",Toast.LENGTH_LONG).show()
        }
    }

    val ctx=ctx


    //creation de la classe Viewholder pour cet adapter du traiteur
    class ViewHolder(items: View): RecyclerView.ViewHolder(items){
            val txtname=items.txtItemName
            val txtaddress=items.txtItemAddress
            val txtphone=items.txtItemPhone
            val txtspecs=items.txtItemSpecs

    }

}
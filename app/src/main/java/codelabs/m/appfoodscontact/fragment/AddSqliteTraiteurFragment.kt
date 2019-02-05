package codelabs.m.appfoodscontact.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import codelabs.m.appfoodscontact.R
import codelabs.m.appfoodscontact.helper.FoodContactDbHelper
import codelabs.m.appfoodscontact.model.Traiteur
import codelabs.m.appfoodscontact.utils.Communicator
import kotlinx.android.synthetic.main.activity_add_traiteur.*
import kotlinx.android.synthetic.main.traiteur_item_row.*

class AddSqliteTraiteurFragment :Fragment() {

    companion object {

        lateinit var comm:Communicator
        lateinit var sqlidb:FoodContactDbHelper
        lateinit var mCtx: Context

        @JvmStatic
        fun newInstance()=AddSqliteTraiteurFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view= LayoutInflater.from(container?.context).inflate(R.layout.activity_add_traiteur,container,false)

        mCtx=container!!.context

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sqlidb= FoodContactDbHelper(mCtx)

        var btSave=view.findViewById<View>(R.id.btnSaveTraiteur) as Button

        btSave.setOnClickListener { view ->
            //invocation de la methode pour enregistrer dans la base des donnees
            SaveTraiteur()
        }


    }

    fun SaveTraiteur(){

        if(!txTraiteurLatitude.text.isEmpty() && !txTraiteurLongitude.text.isEmpty()){
            var traiteur= Traiteur(txTraiteurNom.text.toString(),txTraiteurAddress.text.toString(),txTraiteurPhone.text.toString(),
                txTraiteurEmail.text.toString(),txTraiteurSpec.text.toString(),txTraiteurLatitude.text.toString().toDouble(), txTraiteurLongitude.text.toString().toDouble())
            //Insertion du traiteur dans la base de donnees proprement dit
            sqlidb.insertTraiteur(traiteur)
            //passe la valeur
            comm.respond1(txTraiteurNom.text.toString())

            viderTexts()

        }else if (txTraiteurLatitude.text.isEmpty() && txTraiteurLongitude.text.isEmpty()){
            var traiteur= Traiteur(txTraiteurNom.text.toString(),txTraiteurAddress.text.toString(),txTraiteurPhone.text.toString(),
                txTraiteurEmail.text.toString(),txTraiteurSpec.text.toString())
            //Insertion du traiteur sans les parametres de la localisation
            sqlidb.insertTraiteur(traiteur)

            //Passing data


            viderTexts()

        }else{
            //en cas d'erreur
            Toast.makeText(context,"Erreur d'enregistrement dans la BD", Toast.LENGTH_LONG).show()

        }

    }

    fun viderTexts(){

        txTraiteurNom.text.clear()
        txTraiteurAddress.text.clear()
        txTraiteurPhone.text.clear()
        txTraiteurEmail.text.clear()
        txTraiteurSpec.text.clear()
        txTraiteurLatitude.text.clear()
        txTraiteurLongitude.text.clear()

    }

    fun chargeText(data:String){


    }


}
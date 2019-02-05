package codelabs.m.appfoodscontact

import android.app.Application

class AppFoodsContactApplication : Application() {

    companion object {
        lateinit var mInstance:AppFoodsContactApplication
    }

    //cree une instance de l'application
    override fun onCreate() {
        super.onCreate()
        mInstance=this


    }

}
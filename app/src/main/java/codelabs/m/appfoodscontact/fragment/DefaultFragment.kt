package codelabs.m.appfoodscontact.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codelabs.m.appfoodscontact.R

class DefaultFragment: Fragment() {

    companion object {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val myview=LayoutInflater.from(container!!.context).inflate(R.layout.default_fragment_1,container,false)

        return myview
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}
package codelabs.m.appfoodscontact.utils

import android.app.Activity
import android.content.Context
import android.preference.PreferenceManager
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager

class PreferencesUtils {


    private val monContext: Context? = null

    constructor()


    fun saveEmail(email: String, context: Context): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val prefsEditor = prefs.edit()
        prefsEditor.putString(FieldsContract.KEY_EMAIL, email)
        prefsEditor.apply()
        return true
    }

    fun savePassword(password: String, context: Context): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val prefsEditor = prefs.edit()
        prefsEditor.putString(FieldsContract.KEY_PASSWORD, password)
        prefsEditor.apply()
        return true
    }

    fun getEmail(context: Context): String? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getString(FieldsContract.KEY_EMAIL, null)
    }

    fun getPassword(context: Context): String? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getString(FieldsContract.KEY_PASSWORD, null)
    }


    fun hideKeyboardFrom(view: View) {
        val imm = monContext!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }


}
package ir.tapsell.sample.home

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import ir.tapsell.mediation.Tapsell

class HomeViewModel : ViewModel() {

    companion object {
        private const val TAG = "HomeViewModel"
    }

    fun setUserConsent(activity: Activity, consent: Boolean) {
        Tapsell.setInitializationListener {
            Toast.makeText(activity,"onInitializationComplete", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "onInitializationComplete")
            Tapsell.setUserConsent(activity, consent)
        }
    }
}

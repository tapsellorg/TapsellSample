package ir.tapsell.sample.home

import android.app.Activity
import android.util.Log
import androidx.lifecycle.ViewModel
import ir.tapsell.mediation.Tapsell

class HomeViewModel : ViewModel() {

    companion object {
        private const val TAG = "HomeViewModel"
    }

    fun setUserConsent(activity: Activity, consent: Boolean) {
        Tapsell.setInitializationListener {
            Log.d(TAG, "onInitializationComplete")
            Tapsell.setUserConsent(activity, consent)
        }
    }
}

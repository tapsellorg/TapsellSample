package ir.tapsell.sample.home

import android.util.Log
import androidx.lifecycle.ViewModel
import ir.tapsell.mediation.Tapsell

class HomeViewModel : ViewModel() {

    companion object {
        private const val TAG = "InitializationListener"
    }

    init {
        Tapsell.setInitializationListener {
            Log.d(TAG, "InitializationListener")
        }
    }
}

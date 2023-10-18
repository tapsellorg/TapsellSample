package ir.tapsell.sample.preroll

import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import ir.tapsell.mediation.Tapsell
import ir.tapsell.mediation.ad.AdStateListener
import ir.tapsell.mediation.ad.request.RequestResultListener
import ir.tapsell.sample.BaseViewModel

class PreRollViewModel : BaseViewModel() {

    companion object {
        private const val TAG = "PreRollViewModel"
    }

    var responseId: String? = null
        private set

    fun requestAd(
        zoneId: String, container: ViewGroup,
        companionContainer: ViewGroup?,
        videoPlayer: FrameLayout,
        videoPath: String?,
    ) {
        Tapsell.requestPreRollAd(
            zoneId,
            container,
            companionContainer,
            videoPlayer,
            videoPath,
            object : RequestResultListener {
                override fun onFailure() {
                    log(TAG, "onFailure", Log.ERROR)
                }

                override fun onSuccess(adId: String) {
                    responseId = adId
                    log(TAG, "onSuccess: $adId")
                }
            })
    }

    fun showAd() {
        if (responseId.isNullOrEmpty()) {
            log(TAG, "adId is empty", Log.ERROR)
            return
        }
        Tapsell.showPreRollAd(
            responseId,
            object : AdStateListener.PreRoll {
                override fun onAdClicked() {
                    log(TAG, "onAdClicked")
                }

                override fun onVastAvailable(vastUrl: String?) {
                    log(TAG, "onVastAvailable: $vastUrl")
                }

                override fun onAdFailed(message: String) {
                    log(TAG, "onAdFailed: $message", Log.ERROR)
                }

                override fun onAdImpression() {
                    log(TAG, "onAdImpression")
                }
            })
    }

    fun destroyAd() {
        if (responseId.isNullOrEmpty()) {
            log(TAG, "adId is empty", Log.ERROR)
            return
        }

        Tapsell.destroyPreRollAd(responseId)
    }
}

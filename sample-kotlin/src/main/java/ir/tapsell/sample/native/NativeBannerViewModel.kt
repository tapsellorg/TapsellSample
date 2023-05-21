package ir.tapsell.sample.native

import android.util.Log
import androidx.fragment.app.FragmentActivity
import ir.tapsell.mediation.Tapsell
import ir.tapsell.mediation.ad.AdStateListener
import ir.tapsell.mediation.ad.request.RequestResultListener
import ir.tapsell.mediation.ad.views.ntv.NativeAdViewContainer
import ir.tapsell.sample.BaseViewModel

class NativeBannerViewModel : BaseViewModel() {

    companion object {
        private const val TAG = "NativeBannerViewModel"
    }

    var responseId: String? = null
        private set


    fun requestAd(zoneId: String) {
        Tapsell.requestNativeAd(zoneId, object : RequestResultListener {
            override fun onFailure() {
                log(TAG, "onFailure", Log.ERROR)

            }

            override fun onSuccess(adId: String) {
                responseId = adId
                log(TAG, "onSuccess: $adId", Log.DEBUG)
            }

        })
    }

    fun showAd(activity: FragmentActivity, nativeAdViewContainer: NativeAdViewContainer) {
        if (responseId.isNullOrEmpty()) {
            log(TAG, "adId is empty", Log.ERROR)
            return
        }
        Tapsell.showNativeAd(
            responseId,
            nativeAdViewContainer,
            activity,
            object : AdStateListener.Native {
                override fun onAdClicked() {
                    log(TAG, "onAdClicked", Log.DEBUG)
                }

                override fun onAdFailed(message: String) {
                    log(TAG, "onAdFailed: $message", Log.ERROR)
                }

                override fun onAdImpression() {
                    log(TAG, "onAdImpression", Log.DEBUG)
                }
            })
    }
}
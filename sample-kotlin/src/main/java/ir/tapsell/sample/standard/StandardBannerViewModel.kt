package ir.tapsell.sample.standard

import android.util.Log
import androidx.fragment.app.FragmentActivity
import ir.tapsell.mediation.Tapsell
import ir.tapsell.mediation.ad.AdStateListener
import ir.tapsell.mediation.ad.request.BannerSize
import ir.tapsell.mediation.ad.request.RequestResultListener
import ir.tapsell.mediation.ad.views.banner.BannerContainer
import ir.tapsell.sample.BaseViewModel

class StandardBannerViewModel : BaseViewModel() {

    companion object {
        private const val TAG = "StandardBannerViewModel"
    }

    var responseId: String? = null
        private set

    fun requestAd(zoneId: String, bannerSize: BannerSize) {
        Tapsell.requestBannerAd(zoneId, bannerSize, object : RequestResultListener {
            override fun onFailure() {
                log(TAG, "onFailure", Log.ERROR)
            }

            override fun onSuccess(adId: String) {
                responseId = adId
                log(TAG, "onSuccess: $adId")
            }
        })
    }

    fun showAd(activity: FragmentActivity, container: BannerContainer) {
        if (responseId.isNullOrEmpty()) {
            log(TAG, "adId is empty", Log.ERROR)
            return
        }
        Tapsell.showBannerAd(responseId, container, activity, object : AdStateListener.Banner {
            override fun onAdClicked() {
                log(TAG, "onAdClicked")
            }

            override fun onAdFailed(message: String) {
                log(TAG, "onAdFailed: $message", Log.ERROR)
            }

            override fun onAdImpression() {
                log(TAG, "onAdImpression")
            }
        })
    }
}

package ir.tapsell.sample.ui.screens.native_banner

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import ir.tapsell.mediation.Tapsell
import ir.tapsell.mediation.ad.AdStateListener
import ir.tapsell.mediation.ad.request.RequestResultListener
import ir.tapsell.mediation.ad.views.ntv.NativeAdViewContainer
import ir.tapsell.sample.base.BaseViewModel
import ir.tapsell.sample.ui.screens.standard.StandardBannerViewModel
import ir.tapsell.sample.utils.Constants


class NativeBannerViewModel : BaseViewModel() {

    private var responseId: String? = null
    var isShowButtonEnabled by mutableStateOf(false)
        private set
    var isDestroyButtonEnabled by mutableStateOf(false)
        private set
    private var adContainer by mutableStateOf<NativeAdViewContainer?>(null)

    companion object {
        private const val TAG = "NativeBannerViewModel"
    }

    fun requestAd() {
        Tapsell.requestNativeAd(Constants.TAPSELL_NATIVE_BANNER, object : RequestResultListener {
            override fun onFailure() {
                log(TAG, "onFailure", Log.ERROR)
            }

            override fun onSuccess(adId: String) {
                responseId = adId
                isShowButtonEnabled = true
                log(TAG, "onSuccess: $adId")
            }
        })
    }

    fun showAd(activity: Activity) {
        if (responseId.isNullOrEmpty()) {
            log(TAG, "adId is empty", Log.ERROR)
            return
        }
        if (adContainer == null) {
            log(TAG, "adContainer is null", Log.ERROR)
            return
        }
        adContainer?.let { container ->
            Tapsell.showNativeAd(
                responseId,
                container,
                activity,
                object : AdStateListener.Native {
                    override fun onAdClicked() {
                        log(TAG, "onAdClicked")
                    }

                    override fun onAdFailed(message: String) {
                        log(TAG, "onAdFailed: $message", Log.ERROR)
                    }

                    override fun onAdImpression() {
                        isDestroyButtonEnabled = true
                        log(TAG, "onAdImpression")
                    }
                })
            isShowButtonEnabled = false
        } ?: log(TAG, "adContainer is null", Log.ERROR)
    }

    fun destroyAd() {
        Tapsell.destroyNativeAd(responseId)
        isDestroyButtonEnabled = false
        log(TAG, "destroyAd")
    }

    fun updateAdHolder(adHolder: NativeAdViewContainer?) {
        this.adContainer = adHolder
    }
}
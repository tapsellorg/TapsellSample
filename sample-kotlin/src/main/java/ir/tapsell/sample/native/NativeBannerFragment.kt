package ir.tapsell.sample.native

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import ir.tapsell.mediation.Tapsell
import ir.tapsell.mediation.ad.views.ntv.NativeAdViewContainer
import ir.tapsell.sample.R
import ir.tapsell.sample.databinding.FragmentNativeBannerBinding
import ir.tapsell.sample.utils.addChip
import ir.tapsell.shared.MULTIPLE_NATIVE_REQUESTS_COUNT
import ir.tapsell.shared.TapsellKeys
import ir.tapsell.shared.TapsellKeys.TapsellMediationKeys
import ir.tapsell.shared.TapsellNativeAdNetworks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NativeBannerFragment : Fragment() {

    private var _binding: FragmentNativeBannerBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<NativeBannerViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNativeBannerBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TapsellNativeAdNetworks.map { adNetwork ->
            binding.chipAdNetworks.addChip(requireContext(), adNetwork.name) {
                binding.inputZone.setText(adNetwork.native)
                updateZoneInput(adNetwork)
                binding.tvSwitchNativeVideo.setOnClickListener {
                    binding.switchNativeType.isChecked = binding.switchNativeType.isChecked.not()
                    updateZoneInput(adNetwork)
                }
            }
        }

        binding.inputZone.setText(TapsellMediationKeys.native)
        binding.btnRequest.setOnClickListener {
            requestAd()
        }
        binding.btnRequestMultiple.setOnClickListener {
            requestAd(MULTIPLE_NATIVE_REQUESTS_COUNT)
        }
        binding.btnShow.setOnClickListener {
            showAd()
        }

        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.logMessage.collect {
                binding.tvLog.text = it
            }
        }
    }

    /**
     * handle native video and native banner
     */
    private fun updateZoneInput(adNetwork: TapsellKeys) {
        if (binding.switchNativeType.isChecked) {
            // Native video is only available for `TapsellMediationKeys` and `LegacyKeys`
            when (adNetwork) {
                is TapsellMediationKeys -> binding.inputZone.setText(adNetwork.nativeVideo)
                is TapsellKeys.LegacyKeys -> binding.inputZone.setText(adNetwork.nativeVideo)
                else -> binding.inputZone.setText(adNetwork.native)
            }
        }
    }

    private fun requestAd(count: Int = 1) {
        viewModel.requestAd(binding.inputZone.text.toString(), count)
    }

    private fun showAd() = NativeAdViewContainer(requireContext()).let {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.banner_container, it, true)
        binding.nativeBannerContainer.addView(view)
        viewModel.showAd(requireActivity(), it)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        viewModel.responseIds.forEach(Tapsell::destroyNativeAd)
    }
}

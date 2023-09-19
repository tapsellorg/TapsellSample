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
import ir.tapsell.sample.databinding.FragmentNativeBannerBinding
import ir.tapsell.utils.Constants
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

        binding.btnRequest.setOnClickListener {
            requestAd()
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

    private fun requestAd() {
        viewModel.requestAd(Constants.TAPSELL_NATIVE_BANNER, requireActivity())
    }

    private fun showAd() = NativeAdViewContainer(requireContext()).let {
        binding.nativeBannerContainer.addView(it)
        viewModel.showAd(requireActivity(), it)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        Tapsell.destroyNativeAd(viewModel.responseId)
    }
}

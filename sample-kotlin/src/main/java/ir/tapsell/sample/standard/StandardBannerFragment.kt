package ir.tapsell.sample.standard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import ir.tapsell.mediation.Tapsell
import ir.tapsell.mediation.ad.request.BannerSize
import ir.tapsell.mediation.ad.views.banner.BannerContainer
import ir.tapsell.sample.databinding.FragmentStandardBannerBinding
import ir.tapsell.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StandardBannerFragment : Fragment() {

    private var _binding: FragmentStandardBannerBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<StandardBannerViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStandardBannerBinding.inflate(inflater, container, false)
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
        viewModel.requestAd(
            Constants.TAPSELL_STANDARD_BANNER,
            BannerSize.BANNER_320_50,
            requireActivity()
        )
    }

    private fun showAd() = BannerContainer(requireContext()).let {
        binding.bannerContainerView.addView(it)
        viewModel.showAd(requireActivity(), it)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        Tapsell.destroyBannerAd(viewModel.responseId)
    }
}

package ir.tapsell.sample.appopen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import ir.tapsell.sample.databinding.FragmentInterstitialBinding
import ir.tapsell.shared.AdmobKeys
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppOpenFragment : Fragment() {

    private var _binding: FragmentInterstitialBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<AppOpenViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInterstitialBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.inputZone.setText(AdmobKeys.APP_OPEN)
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
        viewModel.requestAd(binding.inputZone.text.toString())
    }

    private fun showAd() {
        viewModel.showAd(requireActivity())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

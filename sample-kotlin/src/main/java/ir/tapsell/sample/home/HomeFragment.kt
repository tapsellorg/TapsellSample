package ir.tapsell.sample.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import ir.tapsell.sample.R
import ir.tapsell.sample.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val viewModel by activityViewModels<HomeViewModel>()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        binding.btnRewardedVideo.setOnClickListener {
            navController.navigate(R.id.action_fragment_home_to_fragment_rewarded_video)
        }

        binding.btnInterstitial.setOnClickListener {
            navController.navigate(R.id.action_fragment_home_to_fragment_interstitial)
        }

        binding.btnStandardBanner.setOnClickListener {
            navController.navigate(R.id.action_fragment_home_to_fragment_standard_banner)
        }

        binding.btnNativeBanner.setOnClickListener {
            navController.navigate(R.id.action_fragment_home_to_fragment_native_banner)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

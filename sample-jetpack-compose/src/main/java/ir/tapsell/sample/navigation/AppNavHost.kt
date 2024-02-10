package ir.tapsell.sample.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.tapsell.sample.ui.screens.home.HomeScreen
import ir.tapsell.sample.ui.screens.interstitial.InterstitialScreen
import ir.tapsell.sample.ui.screens.native_banner.NativeBannerScreen
import ir.tapsell.sample.ui.screens.preroll.PreRollScreen
import ir.tapsell.sample.ui.screens.rewarded.RewardedVideoScreen
import ir.tapsell.sample.ui.screens.standard.StandardBannerScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Routes.Home
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Routes.Home) {
            HomeScreen(navController = navController)
        }

        composable(Routes.REWARDED_VIDEO) {
            RewardedVideoScreen()
        }

        composable(Routes.INTERSTITIAL) {
            InterstitialScreen()
        }

        composable(Routes.NATIVE_BANNER) {
            NativeBannerScreen()
        }

        composable(Routes.STANDARD_BANNER) {
            StandardBannerScreen()
        }

        composable(Routes.PRE_ROLL) {
            PreRollScreen()
        }
    }
}

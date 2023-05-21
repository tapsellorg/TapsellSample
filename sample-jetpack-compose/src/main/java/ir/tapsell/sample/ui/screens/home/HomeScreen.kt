package ir.tapsell.sample.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ir.tapsell.sample.R
import ir.tapsell.sample.navigation.Routes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.app_name))
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(Routes.REWARDED_VIDEO)
                }
            ) {
                Text(text = stringResource(R.string.rewarded_video))
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(Routes.INTERSTITIAL)
                }
            ) {
                Text(text = stringResource(R.string.interstitial))
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(Routes.STANDARD_BANNER)
                }
            ) {
                Text(text = stringResource(R.string.standard_banner))
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(Routes.NATIVE_BANNER)
                }
            ) {
                Text(text = stringResource(R.string.native_banner))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
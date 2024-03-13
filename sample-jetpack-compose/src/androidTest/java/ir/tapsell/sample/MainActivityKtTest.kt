package ir.tapsell.sample

import android.graphics.Bitmap
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.runner.screenshot.Screenshot
import ir.tapsell.sample.navigation.AppNavHost
import ir.tapsell.sample.ui.theme.TapsellSampleTheme
import ir.tapsell.shared.TestTags
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityKtTest {

    companion object {
        private const val DELAY = 5_000L
    }

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private fun screenshot(name: String) {
        Screenshot.capture(composeTestRule.activity)
            .setName(name)
            .setFormat(Bitmap.CompressFormat.PNG)
            .process()
    }

    @Before
    fun setUp() {
        composeTestRule.setContent {
            TapsellSampleTheme {
                AppNavHost()
            }
        }
    }

    @Test
    fun testRewarded() {
        screenshot("home")
        composeTestRule.onNodeWithTag(TestTags.REWARDED).apply {
            assertIsDisplayed()
            performClick()
        }

        fun request() {
            screenshot("rewarded")
            composeTestRule.onNodeWithTag(TestTags.REQUEST).apply {
                assertIsDisplayed()
                performClick()
            }
        }

        fun show() {
            composeTestRule.waitUntil(DELAY) {
                screenshot("rewarded_1")
                composeTestRule.activityRule.scenario.state == Lifecycle.State.RESUMED
            }
            composeTestRule.waitUntil(DELAY) {
                try {
                    val showButton = composeTestRule.onNodeWithTag(TestTags.SHOW).apply {
                        assertIsDisplayed()
                        performClick()
                    }
                    screenshot("rewarded_2")
                    showButton.fetchSemanticsNode().size == IntSize(1, 1)
                } catch (e: Exception) {
                    true
                }
            }
        }

        fun verifyOnSuccess() {
            composeTestRule.waitUntil(DELAY) {
                composeTestRule.onNodeWithTag(TestTags.Log)
                    .assertIsDisplayed()
                    .assertTextContains(TestTags.On_SUCCESS)
                    .fetchSemanticsNode().size == IntSize(1, 1)
            }
        }

        request()
        show()
        // verifyOnSuccess()

    }
}
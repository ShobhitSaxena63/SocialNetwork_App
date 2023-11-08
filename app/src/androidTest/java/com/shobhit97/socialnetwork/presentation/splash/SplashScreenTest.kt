package com.shobhit97.socialnetwork.presentation.splash

import androidx.activity.compose.setContent
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.shobhit97.socialnetwork.MainCoroutineRule
import com.shobhit97.socialnetwork.presentation.MainActivity
import com.shobhit97.socialnetwork.presentation.ui.theme.SocialNetworkTheme
import com.shobhit97.socialnetwork.presentation.util.Screen
import com.shobhit97.socialnetwork.util.Constants.SPLASH_SCREEN_DURATION
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class SplashScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

//    @get:Rule
//    val coroutineRule = MainCoroutineRule()

    private val testDispatcher = StandardTestDispatcher()

    @RelaxedMockK //RelaxedMockK Mock with empty functions of that class
    lateinit var navController: NavController

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }


    @Test
    fun splashScreen_displayAndDisappears() = runTest {
        composeTestRule.activity.setContent {
            SocialNetworkTheme {
                SplashScreen(navController = navController, dispatcher = testDispatcher)
            }
        }
        composeTestRule
            .onNodeWithContentDescription("logo")
            .assertExists()

        advanceTimeBy(SPLASH_SCREEN_DURATION)

        verify {
            navController.popBackStack()
            navController.navigate(Screen.LoginScreen.route)
        }
    }
}

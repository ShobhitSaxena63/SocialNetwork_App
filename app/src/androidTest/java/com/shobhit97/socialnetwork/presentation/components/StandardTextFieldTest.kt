package com.shobhit97.socialnetwork.presentation.components

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.text.input.KeyboardType
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shobhit97.socialnetwork.presentation.MainActivity
import com.shobhit97.socialnetwork.presentation.ui.theme.SocialNetworkTheme
import com.shobhit97.socialnetwork.presentation.util.TestTags.PASSWORD_TOGGLE
import com.shobhit97.socialnetwork.presentation.util.TestTags.STANDARD_TEXT_FIELD
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class StandardTextFieldTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

//    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
//        composeTestRule.activity.setContent {
//            var text by remember {
//                mutableStateOf("")
//            }
//
//            SocialNetworkTheme {
//                StandardTextField(
//                    text = text,
//                    onValueChange = { text = it },
//                    maxLength = 5,
//                    modifier = Modifier
//                        .testTag(STANDARD_TEXT_FIELD)
//                )
//            }
//        }
    }

    @Test
    fun enterTooLongString_maxLengthNotExceeded() {
        composeTestRule.activity.setContent {
            var text by remember {
                mutableStateOf("")
            }

            SocialNetworkTheme {
                StandardTextField(
                    text = text,
                    onValueChange = { text = it },
                    maxLength = 5,
                    modifier = Modifier
                        .testTag(STANDARD_TEXT_FIELD)
                )
            }
        }

        val expectedString = "aaaaa"
        composeTestRule
            .onNodeWithTag(STANDARD_TEXT_FIELD)
            .performTextClearance()


        composeTestRule.onNodeWithTag(STANDARD_TEXT_FIELD)
            .performTextInput(expectedString)
        composeTestRule.onNodeWithTag(STANDARD_TEXT_FIELD)
            .performTextInput("a")

        composeTestRule.onNodeWithTag(STANDARD_TEXT_FIELD)
            .assertTextEquals(expectedString)
    }

    @Test
    fun enterPassword_toggleVisibility_passwordVisible() {
        composeTestRule.activity.setContent {
            var text by remember {
                mutableStateOf("")
            }

            SocialNetworkTheme {
                StandardTextField(
                    text = text,
                    onValueChange = { text = it },
                    maxLength = 5,
                    keyboardType = KeyboardType.Password,
                    modifier = Modifier
                        .testTag(STANDARD_TEXT_FIELD)
                )
            }
        }

        val inputPassword = "abcdef"
        composeTestRule
            .onNodeWithTag(STANDARD_TEXT_FIELD)
            .performTextClearance()
        composeTestRule
            .onNodeWithTag(STANDARD_TEXT_FIELD)
            .performTextInput(inputPassword)
        composeTestRule
            .onNodeWithTag(PASSWORD_TOGGLE)
    }


}
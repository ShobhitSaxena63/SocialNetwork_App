package com.shobhit97.socialnetwork.presentation.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.presentation.components.StandardTextField
import com.shobhit97.socialnetwork.presentation.ui.theme.SocialNetworkTheme
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceLarge
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceSmall
import com.shobhit97.socialnetwork.presentation.util.Navigation
import com.shobhit97.socialnetwork.presentation.util.TestTags

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(
                start = SpaceLarge,
                end = SpaceLarge,
                top = SpaceLarge,
                bottom = 50.dp
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ) {
            Text(
                text = stringResource(id = R.string.register),
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(SpaceLarge))
            StandardTextField(
                text = viewModel.username.value,
                onValueChange = { viewModel.setEmail(it) },
                modifier = Modifier.testTag(TestTags.STANDARD_TEXT_FIELD),
                error = viewModel.emailError.value,
                hint = stringResource(id = R.string.email)
            )
            Spacer(modifier = Modifier.height(SpaceLarge))
            StandardTextField(
                text = viewModel.username.value,
                onValueChange = { viewModel.setUsername(it) },
                modifier = Modifier.testTag(TestTags.STANDARD_TEXT_FIELD),
                error = viewModel.usernameError.value,
                hint = stringResource(id = R.string.username)
            )
            Spacer(modifier = Modifier.height(SpaceLarge))
            StandardTextField(
                text = viewModel.password.value,
                onValueChange = { viewModel.setPassword(it) },
                modifier = Modifier.testTag(TestTags.STANDARD_TEXT_FIELD),
                hint = stringResource(id = R.string.password),
                keyboardType = KeyboardType.Password,
                error = viewModel.passwordError.value,
                showPasswordToggle = viewModel.showPassword.value,
                onPasswordToggleClick = {
                    viewModel.setShowPassword(it)
                }
            )
            Spacer(modifier = Modifier.height(SpaceLarge))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.End),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.register),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 18.sp
                )
            }
        }

        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.already_have_an_account))
                append(" ")
                val signUpText = stringResource(id = R.string.sign_in)
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                    append(signUpText)
                }


            },
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    navController.popBackStack()
                }
        )

    }
}

@Preview
@Composable
fun PreviewRegisterScreen() {
    SocialNetworkTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            RegisterScreen(navController = rememberNavController())
        }
    }

}
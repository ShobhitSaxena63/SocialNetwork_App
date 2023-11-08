package com.shobhit97.socialnetwork.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.domain.models.Post
import com.shobhit97.socialnetwork.presentation.components.Post
import com.shobhit97.socialnetwork.presentation.components.StandardScaffold
import com.shobhit97.socialnetwork.presentation.util.Navigation
import com.shobhit97.socialnetwork.presentation.ui.theme.SocialNetworkTheme
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceLarge
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceMedium
import com.shobhit97.socialnetwork.presentation.util.Screen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialNetworkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    StandardScaffold(
                        navController = navController,
                        showBottomBar = navBackStackEntry?.destination?.route in listOf(
                            Screen.MainFeedScreen.route,
                            Screen.ActivityScreen.route,
                            Screen.ProfileScreen.route,
                            Screen.ChatScreen.route
                        ),
                        modifier = Modifier.fillMaxSize(),
                        onFabClick = {
                            navController.navigate(Screen.CreatePostScreen.route)
                        }
                    ) {
                        Navigation(navController)
                    }
                }
            }
        }
    }
}

package com.shobhit97.socialnetwork.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PedalBike
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
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
//                        showToolBar = navBackStackEntry?.destination?.route !in listOf(
//                            Screen.LoginScreen.route,
//                            Screen.RegisterScreen.route,
//                            Screen.SplashScreen.route
//                        ),
//                        showBackArrow = navBackStackEntry?.destination?.route in listOf(
//                            Screen.PostDetailScreen.route,
//                            Screen.ChatScreen.route,
//                            Screen.EditProfileScreen.route,
//                            Screen.SearchScreen.route,
//                            Screen.CreatePostScreen.route,
//                            Screen.PersonListScreen.route,
//                        ),
//                        toolBarTitle = when (navBackStackEntry?.destination?.route) {
//                            Screen.MainFeedScreen.route , Screen.PostDetailScreen.route -> getString(R.string.your_feed)
//                            Screen.ChatScreen.route -> getString(R.string.your_chats)
//                            Screen.MessageScreen.route -> getString(R.string.name,"John Doe")
//                            Screen.ActivityScreen.route -> getString(R.string.your_activity)
//                            Screen.ProfileScreen.route -> getString(R.string.your_profile)
//                            Screen.EditProfileScreen.route -> getString(R.string.edit_your_profile)
//                            Screen.SearchScreen.route -> getString(R.string.search_for_users)
//                            Screen.CreatePostScreen.route -> getString(R.string.create_a_new_post)
//                            Screen.PersonListScreen.route -> getString(R.string.liked_by)
//                            else -> {
//                                ""
//                            }
//                        },
                        onFabClick = {
                            navController.navigate(Screen.CreatePostScreen.route)
                        },
//                        toolBarActions = {
//                            if (navBackStackEntry?.destination?.route in listOf(
//                                    Screen.MainFeedScreen.route,
//                                    Screen.ProfileScreen.route,
//                                    Screen.EditProfileScreen.route,
//                                    Screen.CreatePostScreen.route,
//                                )
//                            ) {
//                                var onClick: () -> Unit = { }
//                                var icon: ImageVector = Icons.Default.PedalBike
//
//                                when (navBackStackEntry?.destination?.route) {
//                                    Screen.MainFeedScreen.route -> {
//                                        onClick = {
//
//                                        }
//                                        icon = Icons.Filled.Search
//                                    }
//
//                                    Screen.ProfileScreen.route -> {
//                                        onClick = {
//
//                                        }
//                                        icon = Icons.Default.MoreVert
//                                    }
//                                    Screen.EditProfileScreen.route -> {
//                                        onClick = {
//
//                                        }
//                                        icon = Icons.Filled.Check
//                                    }
//                                    Screen.CreatePostScreen.route -> {
//                                        onClick = {
//
//                                        }
//                                        icon = Icons.Filled.Check
//                                    }
//                                }
//                                IconButton(
//                                    onClick = onClick,
//                                ) {
//                                    Icon(
//                                        imageVector = icon,
//                                        contentDescription = "thumb up"
//                                    )
//                                }
//
//
//                            }
//
//                        }
                    ) {
                        Navigation(navController)
                    }
                }
            }
        }
    }
}

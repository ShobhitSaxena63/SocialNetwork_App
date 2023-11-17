package com.shobhit97.socialnetwork.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.domain.models.Post
import com.shobhit97.socialnetwork.presentation.activity.ActivityScreen
import com.shobhit97.socialnetwork.presentation.chat.ChatScreen
import com.shobhit97.socialnetwork.presentation.create_post.CreatePostScreen
import com.shobhit97.socialnetwork.presentation.edit_profile.EditProfileScreen
import com.shobhit97.socialnetwork.presentation.login.LoginScreen
import com.shobhit97.socialnetwork.presentation.main_feed_screen.MainFeedScreen
import com.shobhit97.socialnetwork.presentation.post_detail.PostDetailScreen
import com.shobhit97.socialnetwork.presentation.profile.ProfileScreen
import com.shobhit97.socialnetwork.presentation.register.RegisterScreen
import com.shobhit97.socialnetwork.presentation.splash.SplashScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(Screen.MainFeedScreen.route) {
            MainFeedScreen(navController = navController)
        }
        composable(Screen.ChatScreen.route) {
            ChatScreen(navController = navController)
        }
        composable(Screen.ActivityScreen.route) {
            ActivityScreen(navController = navController)
        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
        composable(Screen.CreatePostScreen.route) {
            CreatePostScreen(navController = navController)
        }
        composable(Screen.PostDetailScreen.route) {
            val post = Post(
                username = "John Doe",
                imageUrl = "",
                profilePictureUrl = "",
                description = stringResource(id = R.string.dummy_text),
                likeCount = 17,
                commentCount = 7
            )
            PostDetailScreen(navController = navController,post = post )
        }
        composable(Screen.EditProfileScreen.route) {
            EditProfileScreen(navController = navController)
        }
    }

}
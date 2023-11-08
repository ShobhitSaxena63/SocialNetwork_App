package com.shobhit97.socialnetwork.presentation.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.presentation.util.Screen
import com.shobhit97.socialnetwork.util.Constants.SPLASH_SCREEN_DURATION
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import timber.log.Timber

@Composable
fun SplashScreen(
    navController: NavController,
    dispatcher: CoroutineDispatcher = Dispatchers.Main
) {
    val scale = remember {
        Animatable(
            0f,
        )
    }
    val overShootInterpolator = remember {
        OvershootInterpolator(2f) //increase the size bigger than target value and then set to target value to give nice animation
    }
    LaunchedEffect(key1 = true) {
        withContext(dispatcher) {
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 500, easing = {
                    overShootInterpolator.getInterpolation(it)
                })
            )
            delay(SPLASH_SCREEN_DURATION)
            //pop splash screen from back stack
            //way 1
//        navController.navigate(Screen.LoginScreen.route) {
//            popUpTo(Screen.SplashScreen.route) {
//                this.inclusive = true
//            }
//        }
            //way 2
            navController.popBackStack()
            navController.navigate(Screen.LoginScreen.route)
        }

    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_icon),
            contentDescription = "logo",
            modifier = Modifier
                .scale(scale.value)
        )
    }
}
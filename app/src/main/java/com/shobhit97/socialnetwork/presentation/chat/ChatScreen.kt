package com.shobhit97.socialnetwork.presentation.chat

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.shobhit97.socialnetwork.presentation.components.StandardScaffold

@Composable
fun ChatScreen(
    navController: NavController
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Text(text = "Chat Screen")
    }
}
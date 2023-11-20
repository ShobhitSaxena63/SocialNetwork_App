package com.shobhit97.socialnetwork.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

import androidx.compose.ui.unit.dp
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceMedium
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceSmall
import com.shobhit97.socialnetwork.presentation.util.toPx

@Composable
fun BannerSection(
    modifier: Modifier = Modifier,
    iconSize: Dp = 24.dp,
    onGitHubClick: () -> Unit = {},
    onInstagramClick: () -> Unit = {},
    onLinkedInClick: () -> Unit = {}
) {
    BoxWithConstraints(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.backdrop), contentDescription = "Backdrop",
//                colorFilter = ColorFilter.tint(color = Color.White),
            contentScale = ContentScale.FillBounds, modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent, Color.Black
                        ), startY = constraints.maxHeight - iconSize.toPx() * 2f
                    )
                )
        )
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(all = SpaceSmall),
            horizontalArrangement = Arrangement.spacedBy(SpaceMedium)
        ) {
            Image(
                painter = painterResource(id = R.drawable.kotlin_icon),
                contentDescription = "kotlin",
                modifier = Modifier.size(iconSize),
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(id = R.drawable.javascript_logo),
                contentDescription = "kotlin",
                modifier = Modifier.size(iconSize),
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(id = R.drawable.java_logo),
                contentDescription = "kotlin",
                modifier = Modifier.size(iconSize),
                contentScale = ContentScale.FillBounds
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(all = SpaceSmall),
            horizontalArrangement = Arrangement.spacedBy(SpaceMedium)
        ) {
            Image(
                painter = painterResource(id = R.drawable.github_logo),
                contentDescription = "github",
                modifier = Modifier
                    .size(iconSize)
                    .clickable { onGitHubClick() },
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(id = R.drawable.instagram_icon),
                contentDescription = "instagram",
                modifier = Modifier
                    .size(iconSize)
                    .clickable { onInstagramClick() },
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(id = R.drawable.linkedin_logo),
                contentDescription = "linkedin",
                modifier = Modifier
                    .size(iconSize)
                    .clickable { onLinkedInClick() },
                contentScale = ContentScale.FillBounds
            )
        }
    }


}
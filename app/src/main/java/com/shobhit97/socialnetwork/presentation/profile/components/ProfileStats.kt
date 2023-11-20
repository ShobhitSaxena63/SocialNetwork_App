package com.shobhit97.socialnetwork.presentation.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.domain.models.User
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceLarge
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceMedium

@Composable
fun ProfileStats(
    user: User,
    isOwnProfile:Boolean = true,
    modifier: Modifier = Modifier,
    isFollowing: Boolean = false,
    onFollowClick: () -> Unit = {}
) {

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        ProfileNumber(
            number = user.followerCount,
            text = stringResource(id = R.string.followers)
        )
        ProfileNumber(
            number = user.followingCount,
            text = stringResource(id = R.string.following)
        )
        ProfileNumber(
            number = user.postCount,
            text = stringResource(id = R.string.posts)
        )
        if(isOwnProfile){
            Button(
                onClick = onFollowClick,
                shape = RoundedCornerShape(10.dp), modifier = Modifier.height(36.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isFollowing) Color.Red else MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = if (isFollowing) stringResource(id = R.string.unfollow) else stringResource(
                        id = R.string.follow
                    ),
                    color = if (isFollowing) Color.White else MaterialTheme.colorScheme.onPrimary,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxHeight()
                        .align(Alignment.CenterVertically)
                )
            }

        }
    }
}
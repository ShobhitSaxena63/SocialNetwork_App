package com.shobhit97.socialnetwork.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAddAlt1
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.domain.models.User
import com.shobhit97.socialnetwork.presentation.ui.theme.MediumGray
import com.shobhit97.socialnetwork.presentation.ui.theme.ProfilePictureSizeMedium
import com.shobhit97.socialnetwork.presentation.ui.theme.ProfilePictureSizeSmall
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceMedium
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceSmall

@Composable
fun UserProfileItem(
    modifier: Modifier = Modifier,
    user: User,
    actionIcon: @Composable () -> Unit = {},
    onItemClick: () -> Unit = {},
    onActionItemClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.clickable {
            onItemClick()
        },
        elevation = CardDefaults.cardElevation(5.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MediumGray
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceMedium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.person_sample),
                contentDescription = stringResource(
                    R.string.profile_picture
                ),
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(ProfilePictureSizeMedium)
                    .weight(2f)
            )
            Spacer(modifier = Modifier.width(SpaceMedium))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(6f)
            ) {
                Text(
                    text = user.username,
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(SpaceSmall))
                Text(
                    text = user.description,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 12.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.width(SpaceMedium))
            IconButton(
                onClick = onActionItemClick,
                modifier = Modifier.weight(2f)
            ) {
                actionIcon()

            }
        }




    }
}
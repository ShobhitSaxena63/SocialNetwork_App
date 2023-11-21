package com.shobhit97.socialnetwork.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.domain.models.User
import com.shobhit97.socialnetwork.presentation.ui.theme.ProfilePictureSizeLarge
import com.shobhit97.socialnetwork.presentation.ui.theme.ProfilePictureSizeMedium
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceLarge
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceMedium
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceSmall

@Composable
fun ProfileHeaderSection(
    modifier: Modifier = Modifier,
    user: User,
    isOwnProfile: Boolean = true,
    onEditClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = -(ProfilePictureSizeLarge / 2f)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.person_sample),
            contentDescription = stringResource(
                id = R.string.profile_picture
            ),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(ProfilePictureSizeLarge)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onSurface,
                    shape = CircleShape
                )
        )
        Row(
            modifier = Modifier
                .offset(x = if(isOwnProfile) {
                    (30.dp + SpaceSmall) / 2f
                } else 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = user.username,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            if (isOwnProfile) {
                Spacer(modifier = Modifier.width(SpaceSmall))
                IconButton(
                    onClick = onEditClick, modifier = Modifier.size(30.dp),
                ) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = stringResource(id = R.string.edit_your_profile),
                    )
                }

            }


        }

        Text(
            text = user.description,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = SpaceLarge)
        )

        ProfileStats(user = user,
            isOwnProfile = isOwnProfile,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = SpaceLarge, vertical = SpaceMedium)
        )
    }
}
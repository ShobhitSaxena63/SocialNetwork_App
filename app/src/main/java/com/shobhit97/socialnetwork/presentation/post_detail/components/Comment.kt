package com.shobhit97.socialnetwork.presentation.post_detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.domain.models.Comment
import com.shobhit97.socialnetwork.presentation.ui.theme.MediumGray
import com.shobhit97.socialnetwork.presentation.ui.theme.ProfilePictureSizeSmall
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceMedium
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceSmall


@Composable
fun Comment(
    modifier: Modifier = Modifier,
    comment: Comment = Comment(),
    onLikeClick: (Boolean) -> Unit = {}
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MediumGray
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceMedium)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
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
                            .size(ProfilePictureSizeSmall)
                    )
                    Spacer(modifier = Modifier.width(SpaceSmall))
                    Text(
                        text = comment.username,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Text(
                    text = "2 days ago",
//                    text = comment.timestamp.toString(),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = comment.comment,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )
                IconButton(
                    onClick = {
                        onLikeClick(comment.isLiked)
                    },
                ) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = if (comment.isLiked) stringResource(R.string.unlike) else stringResource(
                            R.string.like
                        ),
                    )
                }
            }
            Spacer(modifier = Modifier.height(SpaceMedium))

            Text(
                text = stringResource(id = R.string.liked_by_x_people, comment.likeCount),
                style = MaterialTheme.typography.bodySmall
            )

        }
    }
}


@Preview
@Composable
fun CommentPreview() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Comment(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            comment = Comment(
                commentId = 121,
                username = "John Doe",
                profilePictureUrl = "",
                comment = stringResource(id = R.string.dummy_text),
            )
        )
    }
}
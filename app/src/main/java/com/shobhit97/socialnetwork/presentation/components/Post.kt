package com.shobhit97.socialnetwork.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.domain.models.Post
import com.shobhit97.socialnetwork.presentation.ui.theme.HintGray
import com.shobhit97.socialnetwork.presentation.ui.theme.LightGray
import com.shobhit97.socialnetwork.presentation.ui.theme.MediumGray
import com.shobhit97.socialnetwork.presentation.ui.theme.ProfilePictureSize
import com.shobhit97.socialnetwork.presentation.ui.theme.SocialNetworkTheme
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceMedium
import com.shobhit97.socialnetwork.presentation.ui.theme.TextWhite
import com.shobhit97.socialnetwork.util.Constants.MAX_POST_DESCRIPTION_LINES

@Composable
fun Post(
    modifier: Modifier = Modifier,
    post: Post,
    showProfilePicture:Boolean = true,
    onPostClick: () -> Unit = {}

) {
    Box(
        modifier = modifier
            .fillMaxWidth()

    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = ProfilePictureSize / 2f)
                .clip(RoundedCornerShape(8.dp))
                .shadow(5.dp)
                .background(color = MediumGray)
                .clickable {
                    onPostClick()
                }

        ) {
            Image(
                painter = painterResource(id = R.drawable.post), contentDescription = "user",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)


            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = SpaceMedium)

            ) {
                ActionRow(
                    username = post.username,
                    modifier = Modifier.fillMaxWidth(),
                    onLikeClick = { isLiked ->

                    },
                    onCommentClick = {},
                    onShareClick = {},
                    onUsernameClick = {}
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            SpanStyle(color = Color.White)
                        ) {
                            append(post.description)

                        }
                        withStyle(SpanStyle(color = LightGray)) {
                            append(
                                LocalContext.current.getString(
                                    R.string.read_more
                                )
                            )
                        }
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 16.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = MAX_POST_DESCRIPTION_LINES
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(R.string.liked_by_x_people, post.likeCount),
                        style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = stringResource(R.string.x_comments, post.commentCount),
                        style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold
                    )
                }
            }

        }
        if (showProfilePicture){
            Image(
                painter = painterResource(id = R.drawable.person_sample),
                contentDescription = "Profile Pic",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(ProfilePictureSize)
                    .clip(RoundedCornerShape(50.dp))
                    .align(Alignment.TopCenter)
                    .border(
                        width = 2.dp,
                        shape = CircleShape,
                        color = Color.Yellow
                    )
            )
        }

    }
}

@Composable
fun EngagementButtons(
    modifier: Modifier = Modifier,
    iconSize: Dp = 30.dp,
    isLiked: Boolean = false,
    onLikeClick: (Boolean) -> Unit = {},
    onCommentClick: () -> Unit = {},
    onShareClick: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        IconButton(
            onClick = {
                onLikeClick(!isLiked)
            },
            modifier = Modifier.size(iconSize),
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                tint = if (isLiked) Color.Red else TextWhite,
                contentDescription = if (isLiked) stringResource(R.string.unlike) else stringResource(
                    R.string.like
                )
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        IconButton(
            onClick = {
                onCommentClick()
            },
            modifier = Modifier.size(iconSize),
        ) {
            Icon(
                imageVector = Icons.Filled.Comment,
                contentDescription = stringResource(R.string.comment)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        IconButton(
            onClick = {
                onShareClick()
            },
            modifier = Modifier.size(iconSize),
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = stringResource(R.string.share)
            )
        }
    }
}

@Composable
fun ActionRow(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    onLikeClick: (Boolean) -> Unit = {},
    onCommentClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    username: String,
    onUsernameClick: (String) -> Unit = {}
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = username,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable {
                onUsernameClick(username)
            }
        )
        EngagementButtons(
            isLiked = isLiked,
            onLikeClick = onLikeClick,
            onCommentClick = onCommentClick,
            onShareClick = onShareClick,
        )
    }

}


@Preview
@Composable
fun PreviewPost() {
    SocialNetworkTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
//            Post()
        }
    }
}
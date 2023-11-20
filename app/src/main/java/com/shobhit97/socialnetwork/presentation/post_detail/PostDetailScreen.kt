package com.shobhit97.socialnetwork.presentation.post_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.border

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.domain.models.Comment
import com.shobhit97.socialnetwork.domain.models.Post
import com.shobhit97.socialnetwork.presentation.components.ActionRow
import com.shobhit97.socialnetwork.presentation.components.StandardToolbar
import com.shobhit97.socialnetwork.presentation.post_detail.components.Comment
import com.shobhit97.socialnetwork.presentation.ui.theme.ProfilePictureSizeMedium
import com.shobhit97.socialnetwork.presentation.ui.theme.SocialNetworkTheme
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceLarge
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceMedium

@Composable
fun PostDetailScreen(
    navController: NavController,
    post: Post
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        StandardToolbar(
            navController = navController,
            showBackArrow = true,
            title = {
                Text(
                    text = stringResource(id = R.string.your_feed),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )

            },
            modifier = Modifier.fillMaxWidth(),
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)

            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = ProfilePictureSizeMedium / 2f)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.post),
                        contentDescription = "user",
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
                            text = post.description,
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.bodyMedium,
                            fontSize = 16.sp,
                        )
                        Text(
                            text = stringResource(R.string.liked_by_x_people, post.likeCount),
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 20.dp),
                        )

                        LazyColumn(
                            modifier = Modifier
                                .height(500.dp)
                                .padding(top = 5.dp),

                            ) {
                            items(20) {
                                Comment(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = SpaceLarge),
                                    comment = Comment(
                                        commentId = 121,
                                        username = "John Doe $it",
                                        profilePictureUrl = "",
                                        comment = stringResource(id = R.string.dummy_text),
                                    )
                                )
                            }
                        }
                    }

                }
                Image(
                    painter = painterResource(id = R.drawable.person_sample),
                    contentDescription = "Profile Pic",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(ProfilePictureSizeMedium)
                        .clip(RoundedCornerShape(50.dp))

                        .align(Alignment.TopCenter)
                        .border(
                            width = 3.dp,
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.primary
                        )
                )
            }
        }

    }
}

@Preview
@Composable
fun PreviewPostDetailScreen() {
    SocialNetworkTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val post = Post(
                username = "John Doe",
                imageUrl = "",
                profilePictureUrl = "",
                description = stringResource(id = R.string.dummy_text),
                likeCount = 17,
                commentCount = 7
            )
            PostDetailScreen(navController = rememberNavController(), post = post)
        }
    }

}
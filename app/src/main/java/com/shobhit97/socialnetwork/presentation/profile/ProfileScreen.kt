package com.shobhit97.socialnetwork.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Save
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.domain.models.Activity
import com.shobhit97.socialnetwork.domain.models.User
import com.shobhit97.socialnetwork.domain.util.ActivityAction
import com.shobhit97.socialnetwork.domain.util.DateFormatUtil
import com.shobhit97.socialnetwork.presentation.activity.components.ActivityItem
import com.shobhit97.socialnetwork.presentation.components.Post
import com.shobhit97.socialnetwork.presentation.components.StandardScaffold
import com.shobhit97.socialnetwork.presentation.components.StandardToolbar
import com.shobhit97.socialnetwork.presentation.profile.components.BannerSection
import com.shobhit97.socialnetwork.presentation.profile.components.ProfileHeaderSection
import com.shobhit97.socialnetwork.presentation.ui.theme.ProfilePictureSizeLarge
import com.shobhit97.socialnetwork.presentation.ui.theme.ProfilePictureSizeMedium
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceLarge
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceMedium
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceSmall
import com.shobhit97.socialnetwork.presentation.util.Screen
import kotlin.random.Random

@Composable
fun ProfileScreen(
    navController: NavController,
    profilePictureSize: Dp = ProfilePictureSizeLarge,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        StandardToolbar(
            navController = navController,
            showBackArrow = false,
            title = {
                Text(
                    text = stringResource(id = R.string.your_profile),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )

            },
            navActions = {
                IconButton(
                    onClick = {
                    },
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "show menu"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            item {
                BannerSection(
                    modifier = Modifier.aspectRatio(2.5f)
                )
            }

            item {
                ProfileHeaderSection(user = User(
                    profilePictureUrl = "",
                    username = "John Doe",
                    description = stringResource(id = R.string.dummy_text_short),
                    followerCount = 25,
                    followingCount = 30,
                    postCount = 120
                ),
                    onEditClick = { navController.navigate(Screen.EditProfileScreen.route) })
            }

            items(20) {
                Post(
                    post = com.shobhit97.socialnetwork.domain.models.Post(
                        username = "John Doe",
                        imageUrl = "",
                        profilePictureUrl = "",
                        description = stringResource(id = R.string.dummy_text),
                        likeCount = 17,
                        commentCount = 7
                    ),
                    onPostClick = {
                        navController.navigate(Screen.PostDetailScreen.route)
                    },
                    showProfileImage = false,
                    modifier = Modifier
                        .padding(horizontal = SpaceMedium)
                        .offset(y = -((ProfilePictureSizeLarge / 2f) + (ProfilePictureSizeMedium / 2f))),
                )
                Spacer(modifier = Modifier.height(SpaceLarge))

            }
        }


    }

}
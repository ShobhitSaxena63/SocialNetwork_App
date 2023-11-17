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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.domain.models.Activity
import com.shobhit97.socialnetwork.domain.util.ActivityAction
import com.shobhit97.socialnetwork.domain.util.DateFormatUtil
import com.shobhit97.socialnetwork.presentation.activity.components.ActivityItem
import com.shobhit97.socialnetwork.presentation.components.Post
import com.shobhit97.socialnetwork.presentation.components.StandardScaffold
import com.shobhit97.socialnetwork.presentation.components.StandardToolbar
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceLarge
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceMedium
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceSmall
import com.shobhit97.socialnetwork.presentation.util.Screen
import kotlin.random.Random

@Composable
fun ProfileScreen(
    navController: NavController
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
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(210.dp)
                    ) {
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.backdrop),
                                contentDescription = "Backdrop",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(160.dp)
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
                                    modifier = Modifier.size(24.dp),
                                    contentScale = ContentScale.FillBounds
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.javascript_logo),
                                    contentDescription = "kotlin",
                                    modifier = Modifier.size(24.dp),
                                    contentScale = ContentScale.FillBounds
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.java_logo),
                                    contentDescription = "kotlin",
                                    modifier = Modifier.size(24.dp),
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
                                    modifier = Modifier.size(24.dp),
                                    contentScale = ContentScale.FillBounds
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.instagram_icon),
                                    contentDescription = "instagram",
                                    modifier = Modifier.size(24.dp),
                                    contentScale = ContentScale.FillBounds
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.linkedin_logo),
                                    contentDescription = "linkedin",
                                    modifier = Modifier.size(24.dp),
                                    contentScale = ContentScale.FillBounds
                                )
                            }
                        }


                        Image(
                            painter = painterResource(id = R.drawable.person_sample),
                            contentDescription = "Backdrop",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .size(110.dp)
                                .clip(CircleShape)
                                .border(
                                    width = 2.dp,
                                    color = MaterialTheme.colorScheme.primary,
                                    shape = CircleShape
                                )
                        )

                    }
                    Row(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(start = SpaceLarge),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "John Doe",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold
                        )
                        IconButton(
                            onClick = {
                                navController.navigate(Screen.EditProfileScreen.route)
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Edit,
                                contentDescription = "edit profile"
                            )
                        }

                    }

                    Text(
                        text = stringResource(id = R.string.dummy_text_short),
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = SpaceLarge)
                    )

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = SpaceLarge, vertical = SpaceMedium)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "86",
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = stringResource(R.string.followers),
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Normal
                            )
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "123",
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = stringResource(R.string.following),
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Normal
                            )
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "64",
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = stringResource(R.string.posts),
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Normal
                            )
                        }
                        Button(
                            onClick = {
                            },
                            shape = RoundedCornerShape(10.dp), modifier = Modifier.height(36.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.follow),
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .align(Alignment.CenterVertically)
                            )
                        }
                    }

                }
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
                    showProfilePicture = false,
                    modifier = Modifier.padding(horizontal = SpaceMedium)
                )
                Spacer(modifier = Modifier.height(SpaceLarge))

            }
        }


    }

}
package com.shobhit97.socialnetwork.presentation.edit_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.presentation.components.StandardTextField
import com.shobhit97.socialnetwork.presentation.components.StandardToolbar
import com.shobhit97.socialnetwork.presentation.edit_profile.components.Chip
import com.shobhit97.socialnetwork.presentation.ui.theme.ProfilePictureSizeLarge
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceLarge
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceMedium
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceSmall
import com.shobhit97.socialnetwork.presentation.util.states.StandardTextFieldState
import kotlin.random.Random


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun EditProfileScreen(
    navController: NavController,
    viewModel: EditProfileViewModel = hiltViewModel(),
    profilePictureSize: Dp = ProfilePictureSizeLarge
) {

    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        StandardToolbar(
            navController = navController,
            showBackArrow = true,
            title = {
                Text(
                    text = stringResource(id = R.string.edit_your_profile),
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
                        imageVector = Icons.Filled.Check,
                        contentDescription = stringResource(R.string.save_changes),
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            BannerEditSection(
                bannerImage = painterResource(id = R.drawable.backdrop),
                profileImage = painterResource(id = R.drawable.person_sample)
            )
            Spacer(modifier = Modifier.height(SpaceMedium))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = SpaceLarge)
            ) {
                StandardTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = viewModel.usernameState.value.text,
                    leadingIcon = Icons.Default.Person,
                    hint = stringResource(id = R.string.username),
                    error = viewModel.usernameState.value.error,
                    onValueChange = {
                        viewModel.setUsernameState(
                            StandardTextFieldState(text = it)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = viewModel.githubTextFieldState.value.text,
                    leadingIcon = ImageVector.vectorResource(id = R.drawable.github_logo),
                    hint = stringResource(id = R.string.github_profile_url),
                    error = viewModel.githubTextFieldState.value.error,
                    onValueChange = {
                        viewModel.setGithubTextFieldState(
                            StandardTextFieldState(text = it)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = viewModel.instagramTextFieldState.value.text,
                    leadingIcon = ImageVector.vectorResource(id = R.drawable.instagram_icon),
                    hint = stringResource(id = R.string.instagram_profile_url),
                    error = viewModel.instagramTextFieldState.value.error,
                    onValueChange = {
                        viewModel.setInstagramTextFieldState(
                            StandardTextFieldState(text = it)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = viewModel.linkedInTextFieldState.value.text,
                    leadingIcon = ImageVector.vectorResource(id = R.drawable.linkedin_logo),
                    hint = stringResource(id = R.string.linkedin_profile_url),
                    error = viewModel.linkedInTextFieldState.value.error,
                    onValueChange = {
                        viewModel.setLinkedInTextFieldState(
                            StandardTextFieldState(text = it)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = viewModel.bioState.value.text,
                    leadingIcon = Icons.Default.Description,
                    singleLine = false,
                    maxLines = 3,
                    hint = stringResource(id = R.string.your_bio),
                    error = viewModel.bioState.value.error,
                    onValueChange = {
                        viewModel.setBioState(
                            StandardTextFieldState(text = it)
                        )
                    }
                )
            }
            Spacer(modifier = Modifier.height(SpaceLarge))

            Text(
                text = stringResource(R.string.select_3_top_skills),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = SpaceLarge),
                horizontalArrangement = Arrangement.Center,
            ) {
                listOf(
                    "Kotlin",
                    "JavaScript",
                    "Python",
                    "C++",
                    "C",
                    "Java",
                    "C#",
                    "Dart",
                    "TypeScript",
                    "Assembly",
                ).forEach { it ->
                    Chip(text = it, selected = Random.nextInt(2)==0)
                    Spacer(modifier = Modifier.width(SpaceSmall))

                }

            }


        }

    }

}

@Composable
fun BannerEditSection(
    bannerImage: Painter,
    profileImage: Painter,
    profilePictureSize: Dp = ProfilePictureSizeLarge,
    onBannerClick: () -> Unit = {},
    onProfileImageClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp)
    ) {
        Image(
            painter = bannerImage,
            contentDescription = "Backdrop",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        )
        Image(
            painter = profileImage,
            contentDescription = "Backdrop",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(profilePictureSize)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
        )

    }
}





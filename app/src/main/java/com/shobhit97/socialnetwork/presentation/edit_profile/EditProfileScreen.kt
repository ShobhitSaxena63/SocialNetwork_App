package com.shobhit97.socialnetwork.presentation.edit_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.presentation.components.StandardToolbar
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceLarge
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceSmall


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(
    navController: NavController
) {
    var username by remember {
        mutableStateOf("")
    }
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
                        contentDescription = "show menu"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
        )

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.backdrop),
                    contentDescription = "Backdrop",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                )
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
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.username), modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(350.dp)
                    .padding(start = 50.dp, end = 50.dp, top = SpaceLarge),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    textColor = Color.Black
                )
            )

            EditProfileEditText(icon = R.drawable.instagram_icon, hintText = stringResource(id = R.string.instagram_profile_url))
            EditProfileEditText(icon = R.drawable.linkedin_logo, hintText = stringResource(id = R.string.linkedin_profile_url))
            EditProfileEditText(icon = R.drawable.github_logo, hintText = stringResource(id = R.string.github_profile_url))
            
            Text(
                text = stringResource(R.string.select_3_top_skills),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = SpaceLarge, vertical = SpaceLarge)
            ) {
                FilterChip(selected = true, onClick = { /*TODO*/ }, label = { Text(text = "Kotlin") },
                    colors = FilterChipDefaults.filterChipColors(
                        disabledLabelColor = Color.LightGray,
                        selectedLabelColor = MaterialTheme.colorScheme.primary
                    )
                )
                Spacer(modifier = Modifier.width(SpaceSmall))
                FilterChip(selected = true, onClick = { /*TODO*/ }, label = { Text(text = "Java") },
                    colors = FilterChipDefaults.filterChipColors(
                        disabledLabelColor = Color.LightGray,
                        selectedLabelColor = MaterialTheme.colorScheme.primary
                    ))
                Spacer(modifier = Modifier.width(SpaceSmall))
                FilterChip(selected = false, onClick = { /*TODO*/ }, label = { Text(text = "Python") },
                    colors = FilterChipDefaults.filterChipColors(
                        disabledLabelColor = Color.LightGray,
                        selectedLabelColor = MaterialTheme.colorScheme.primary,
                        selectedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        containerColor = Color.Transparent
                    ))
            }


        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileEditText(
    modifier:Modifier = Modifier,
    icon:Int,
    contentDescription :String = "",
    hintText: String,
) {
    var state by remember {
        mutableStateOf("")
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp, end = 50.dp, top = SpaceLarge),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = contentDescription,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(24.dp))
        OutlinedTextField(
            value = state,
            onValueChange = { state = it },
            placeholder = {
                Text(
                    text = hintText, modifier = Modifier
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                textColor = Color.Black
            )
        )
    }
}





package com.shobhit97.socialnetwork.presentation.activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.domain.models.Activity
import com.shobhit97.socialnetwork.domain.models.Comment
import com.shobhit97.socialnetwork.domain.util.ActivityAction
import com.shobhit97.socialnetwork.domain.util.DateFormatUtil
import com.shobhit97.socialnetwork.presentation.activity.components.ActivityItem
import com.shobhit97.socialnetwork.presentation.components.ActionRow
import com.shobhit97.socialnetwork.presentation.components.StandardScaffold
import com.shobhit97.socialnetwork.presentation.components.StandardToolbar
import com.shobhit97.socialnetwork.presentation.post_detail.components.Comment
import com.shobhit97.socialnetwork.presentation.ui.theme.ProfilePictureSize
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceLarge
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceMedium
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceSmall
import kotlin.random.Random

@Composable
fun ActivityScreen(
    navController: NavController,
    viewModel: ActivityViewModel = hiltViewModel()
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
                    text = stringResource(id = R.string.your_activity),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )

            },
            modifier = Modifier.fillMaxWidth(),
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth().padding(SpaceSmall), contentPadding = PaddingValues(
                SpaceSmall
            )
        ) {
            items(20) {
                ActivityItem(
                    activity = Activity(
                        username = "John Doe",
                        actionType = if(Random.nextInt(2)==0) ActivityAction.LikedPost else ActivityAction.CommentedPost,
                        formattedString = DateFormatUtil
                            .timeStampToFormattedString(
                            timeStamp = System.currentTimeMillis() ,
                            pattern = "MMM dd, hh:mm" ,
                        ),
                    ),
                    modifier = Modifier.padding(top = 16.dp))
            }
        }


    }
}



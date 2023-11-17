package com.shobhit97.socialnetwork.presentation.activity.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.domain.models.Activity
import com.shobhit97.socialnetwork.domain.util.ActivityAction
import com.shobhit97.socialnetwork.presentation.ui.theme.MediumGray
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceMedium
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceSmall

@Composable
fun ActivityItem(
    activity: Activity,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(5.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MediumGray
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = SpaceSmall, horizontal = SpaceMedium)
        ) {
            val fillerText = when (activity.actionType) {
                is ActivityAction.LikedPost -> stringResource(id = R.string.liked)
                is ActivityAction.CommentedPost -> stringResource(id = R.string.commented_on)
            }
            val actionText = when (activity.actionType) {
                is ActivityAction.LikedPost -> stringResource(id = R.string.your_post)
                is ActivityAction.CommentedPost -> stringResource(id = R.string.your_post)
            }
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(fontWeight = FontWeight.Bold)
                    withStyle(boldStyle) {
                        append(activity.username)
                        append(" ")
                    }
                    append(" $fillerText ")
                    withStyle(boldStyle) {
                        append(actionText)
                    }
                },
                color = Color.White,
                fontSize = 12.sp
            )
//            Text(text = "Jul 30th, 18:49", style = MaterialTheme.typography.headlineSmall)
            Text(
                text = activity.formattedString,
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 12.sp
            )
        }
    }
}
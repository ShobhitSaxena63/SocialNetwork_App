package com.shobhit97.socialnetwork.presentation.components

import android.graphics.drawable.Icon
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shobhit97.socialnetwork.presentation.ui.theme.CharcoalGray
import com.shobhit97.socialnetwork.presentation.ui.theme.DarkGray
import com.shobhit97.socialnetwork.presentation.ui.theme.HintGray
import com.shobhit97.socialnetwork.presentation.ui.theme.SpaceLarge
import kotlin.jvm.Throws

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Throws(IllegalArgumentException::class)
fun RowScope.StandardBottomNavItem(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    selected: Boolean = false,
    alertCount: Int? = null,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = HintGray,
    contentDescription: String,
    enabled: Boolean = true,
    onClick: () -> Unit

) {
//    alertCount?.let {
//        require(alertCount >= 0)
//    }

    if (alertCount != null && alertCount < 0) {
        throw IllegalArgumentException("Alert count can't be negative")
    }

    val lineLength = animateFloatAsState(
        targetValue = if (selected) 1f else 0f, animationSpec = tween(
            durationMillis = 300,
        ),
        label = "",
    )

    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        alwaysShowLabel = true,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = selectedColor,
            unselectedIconColor = unselectedColor,
            indicatorColor = CharcoalGray
        ),
        icon = {
            BadgedBox(

                badge = {
                    if (alertCount != null) {
                        val alertText = if (alertCount > 99) "99+" else "$alertCount"
                        Badge(
                            containerColor = selectedColor,
                            modifier = Modifier
                                .width(27.dp)
                                .height(27.dp)
                        ) {
                            Text(
                                text = alertText,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 10.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                }) {
                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = contentDescription,
                        modifier = Modifier
                            .size(35.dp)
                            .drawBehind {
                                if (selected) {
                                    drawLine(
                                        color = if (selected) selectedColor else unselectedColor,
                                        start = Offset(0f * lineLength.value, size.height + 15f),
                                        end = Offset(
                                            size.width * lineLength.value,
                                            size.height + 15f
                                        ),
                                        strokeWidth = 4.dp.toPx(),
                                        cap = StrokeCap.Round
                                    )
                                }
                            }
                    )
                }

            }
        })
}
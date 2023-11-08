package com.shobhit97.socialnetwork.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.ChatBubble
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.domain.models.BottomNavigationItem
import com.shobhit97.socialnetwork.presentation.ui.theme.CharcoalGray
import com.shobhit97.socialnetwork.presentation.ui.theme.DarkGray
import com.shobhit97.socialnetwork.presentation.util.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = false,
    bottomNavigationItems: List<BottomNavigationItem> = listOf(
        BottomNavigationItem(
            route = Screen.MainFeedScreen.route,
            icon = Icons.Outlined.Home,
            contentDescription = stringResource(id = R.string.home),
            alertCount = 10
        ),
        BottomNavigationItem(
            route = Screen.ChatScreen.route,
            icon = Icons.Outlined.ChatBubbleOutline,
            contentDescription = stringResource(id = R.string.chat),
        ),
        //Empty item between nav items so that they are bit away from fab button
        BottomNavigationItem(
            route = "emptySpace",
        ),
        BottomNavigationItem(
            route = Screen.ActivityScreen.route,
            icon = Icons.Outlined.Notifications,
            contentDescription = stringResource(id = R.string.activity),
        ),
        BottomNavigationItem(
            route = Screen.ProfileScreen.route,
            icon = Icons.Outlined.Person,
            contentDescription = stringResource(id = R.string.profile),
        )
    ),
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }
    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (showBottomBar) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(115.dp),
                ) {

                    BottomAppBar(
                        containerColor = Color.Transparent,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomStart),
                        content = {
                            NavigationBar(
                                containerColor = Color.Transparent,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .drawBehind {
                                        clipPath(
                                            path = Path().apply {
                                                addRoundRect(
                                                    RoundRect(
                                                        Rect(
                                                            center = Offset(
                                                                x = size.width / 2f,
                                                                y = size.height - 90.dp.toPx()
                                                            ),
                                                            radius = 50.dp.toPx()
                                                        ),
                                                        cornerRadius = CornerRadius(
                                                            x = 250f,
                                                            y = 250f
                                                        )
                                                    )
                                                )
                                            },
                                            clipOp = ClipOp.Difference
                                        ) {
//                                            drawRect(
//                                                color = CharcoalGray,
//                                                topLeft = Offset(0f, size.height -90.dp.toPx()),
//                                                size = Size(size.width, size.height),
//                                            )
                                            drawRect(
                                                color = CharcoalGray,
                                                size = size
                                            )
                                        }
//                                        clipRect(
//                                            clipOp = ClipOp.Intersect
//                                        ) {
//                                            val canvasQuadrantSize = size / 2F
//                                            drawRect(
//                                                color = CharcoalGray,
//                                                size = size
//                                            )
//                                            drawCircle(
//                                                center = Offset(size.width / 2f, 0f),
//                                                radius = 40.dp.toPx(),
//                                                color = DarkGray
//                                            )
//                                        }
                                    }

                            ) {

                                bottomNavigationItems.forEachIndexed { index, item ->
                                    StandardBottomNavItem(
                                        icon = item.icon,
                                        contentDescription = item.contentDescription ?: "",
                                        selected = item.route == navController.currentDestination?.route,
                                        alertCount = item.alertCount,
                                        enabled = item.icon != null
                                    ) {
                                        if (navController.currentDestination?.route != item.route)
                                            navController.navigate(item.route)
                                    }

                                }


                            }
                        }
                    )
                    FloatingActionButton(
                        onClick = onFabClick,
                        containerColor = MaterialTheme.colorScheme.primary,
                        shape = CircleShape,
                        modifier = Modifier
                            .size(65.dp)
                            .align(Alignment.TopCenter)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.add_icon),
                            contentDescription = stringResource(id = R.string.make_post)
                        )
                    }


                }
            }

        }
    ) {
        it
        content()
    }
}
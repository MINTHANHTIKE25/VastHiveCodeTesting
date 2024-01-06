package com.minthanhtike.vasthivecodetest

import android.content.res.Configuration
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.minthanhtike.vasthivecodetest.common.Constants
import com.minthanhtike.vasthivecodetest.navigation.BottomNavGraph
import com.minthanhtike.vasthivecodetest.navigation.Screens
import com.minthanhtike.vasthivecodetest.ui.theme.VastHiveCodeTestTheme
import org.w3c.dom.Text


@Composable
fun MyApps() {
    MyAppsDesign()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppsDesign(
    modifier: Modifier = Modifier
) {
    var titles by remember { mutableStateOf("ScribbleHub") }
    val navHostController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.pen_svg),
                            contentDescription = "Pens",
                            modifier = modifier
                                .size(25.dp)
                        )
                        Text(
                            text = titles,
                            fontFamily = if (titles == "ScribbleHub") {
                                FontFamily(
                                    Font(
                                        R.font.kaushan_regular,
                                        FontWeight.Bold
                                    )
                                )
                            } else {
                                FontFamily.SansSerif
                            },
                            fontSize = if (titles == "ScribbleHub") 30.sp else 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                actions = {
                    when (titles) {
                        "ScribbleHub" -> {
                            Icon(
                                imageVector = Icons.Default.NotificationsNone,
                                contentDescription = "noti",
                                modifier = modifier.padding(end = 10.dp),
                                tint = MaterialTheme.colorScheme.onBackground
                            )
                            Icon(
                                imageVector = Icons.Default.BookmarkBorder,
                                contentDescription = "BookMark",
                                modifier = modifier.padding(end = 10.dp),
                                tint = MaterialTheme.colorScheme.onBackground
                            )
                        }

                        "Discover" -> {
                            IconButton(
                                onClick = {},
                                modifier = modifier.padding(end = 10.dp)
                                    .size(24.dp),
                                colors = IconButtonDefaults
                                    .iconButtonColors(contentColor = MaterialTheme.colorScheme.onBackground)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.three_dot__circle),
                                    contentDescription = "BookMark"
                                )
                            }
                        }
                    }

                }
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = modifier.height(60.dp),
                containerColor = MaterialTheme.colorScheme.onSecondary
            ) {
                BottomNavBar(navController = navHostController) {
                    titles = it
                }
            }
        }
    ) { paddingValues ->
        BottomNavGraph(
            navHostController, paddingValues
        )
    }
}

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    sendingTitle: (title: String) -> Unit
) {
    var visibility by remember { mutableStateOf(Constants.HOME) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentScreen = currentDestination?.route

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxSize(),
        verticalAlignment = CenterVertically
    ) {
        //region Home button
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    visibility = Constants.HOME
                    navController.navigate(Screens.Home.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                modifier = modifier.size(25.dp)

            ) {
                Icon(
                    imageVector = if (currentScreen == Constants.HOME) Icons.Filled.Home else Icons.Outlined.Home,
                    contentDescription = "",
                    modifier = modifier.fillMaxSize(),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            AnimatedVisibility(visible = currentScreen == Constants.HOME) {
                sendingTitle("ScribbleHub")
                Text(
                    text = "Home",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            }
        }
        //endregion

        //region Discover button
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    visibility = Constants.DISCOVER
                    navController.navigate(Screens.Discover.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                modifier = modifier.size(20.dp)
            ) {
                Icon(
                    painter = if (currentScreen == Constants.DISCOVER) {
                        painterResource(id = R.drawable.compass_fill)
                    } else {
                        painterResource(id = R.drawable.compass_out_sv)
                    },
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            AnimatedVisibility(
                visible = currentScreen == Constants.DISCOVER
            ) {
                sendingTitle("Discover")
                Text(
                    text = "Discover",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            }
        }
        //endregion

        //region Floating ActionButton
        FloatingActionButton(
            onClick = { /*TODO*/ },
            shape = CircleShape,
            modifier = modifier.size(30.dp),
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.background
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "")
        }
        //endregion

        //region Books button
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    visibility = Constants.SAVE
                    navController.navigate(Screens.Save.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                modifier = modifier.size(20.dp),
            ) {
                Icon(
                    imageVector = if (currentScreen == Constants.SAVE) Icons.Filled.Book else Icons.Outlined.Book,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.primary,
                )
            }

            AnimatedVisibility(visible = currentScreen == Constants.SAVE) {
                Text(
                    text = "Save",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            }
        }
        //endregion

        //region Account Button
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    visibility = Constants.ACCOUNT
                    navController.navigate(Screens.Account.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                modifier = modifier.size(28.dp),
            ) {
                Icon(
                    imageVector = if (currentScreen == Constants.ACCOUNT) Icons.Filled.Person else Icons.Outlined.Person,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            AnimatedVisibility(visible = currentScreen == Constants.ACCOUNT) {
                Text(
                    text = "Account",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            }
        }
        //endregion

    }
}


@Preview(
    showSystemUi = true, showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.NONE
)
@Composable
fun MyAppsPrev() {
    VastHiveCodeTestTheme {
        MyAppsDesign()
    }

}
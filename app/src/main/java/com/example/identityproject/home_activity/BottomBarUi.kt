package com.example.identityproject.home_activity

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.identityproject.ui.theme.LightPrimaryBrandColor

@Composable
fun BottomBar(navController: NavHostController, visibility: Boolean) {
    val items = listOf(
        BottomNavBarItems.Home,
        BottomNavBarItems.Search,
        BottomNavBarItems.Clubs,
        BottomNavBarItems.Notification,
        BottomNavBarItems.Menu
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination

    if (visibility) {
        NavigationBar(
            modifier = Modifier.height(110.dp),
            containerColor = MaterialTheme.colorScheme.background,
        ) {
            items.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentRoute,
                    navController = navController
                )
            }
        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomNavBarItems,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    NavigationBarItem(
        label = {
            MarqueeText(title = screen.title)
        },
        alwaysShowLabel = false,
        icon = {
            Icon(
                painterResource(
                    id = if (selected) screen.iconSelected else screen.iconUnselected
                ),
                contentDescription = screen.title
            )
        },
        selected = selected,
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = Color.Transparent,
            selectedTextColor = LightPrimaryBrandColor,
            selectedIconColor = LightPrimaryBrandColor,
            unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
            unselectedTextColor = MaterialTheme.colorScheme.onPrimary
        ),
        onClick = {
            navController.navigate(screen.route) {
                navController.graph.startDestinationRoute?.let { route ->
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    )
}
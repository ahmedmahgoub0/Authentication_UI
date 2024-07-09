package com.example.identityproject.home_activity

import com.example.identityproject.R
import com.example.identityproject.main.Screen

sealed class BottomNavBarItems(
    var title: String, var iconSelected: Int = 0, var iconUnselected: Int = 0, var route: String
) {
    object Home : BottomNavBarItems(
        "Home",
        R.drawable.ic_home,
        R.drawable.ic_home_outline,
        Screen.HomeScreen.route
    )

    object Search : BottomNavBarItems(
        "Search",
        R.drawable.ic_search_filled,
        R.drawable.ic_search_outline,
        Screen.SearchScreen.route

    )

    object Clubs : BottomNavBarItems(
        "Clubs",
        R.drawable.ic_clubs_filled,
        R.drawable.ic_clubs_outline,
        Screen.ClubsScreen.route
    )

    object Notification : BottomNavBarItems(
        "Notifications",
        R.drawable.ic_notification,
        R.drawable.ic_notification_outline,
        Screen.NotificationsScreen.route

    )

    object Menu : BottomNavBarItems(
        "Menu",
        R.drawable.ic_menu_filled,
        R.drawable.ic_menu_outline,
        Screen.MenuScreen.route
    )
}
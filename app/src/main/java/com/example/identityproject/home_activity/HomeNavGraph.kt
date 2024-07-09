package com.example.identityproject.home_activity

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.identityproject.main.Screen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {

        composable(route = Screen.HomeScreen.route) {
            Box(
                modifier = Modifier.fillMaxSize()
            )
        }

        composable(route = Screen.SearchScreen.route) {
            Box(
                modifier = Modifier.fillMaxSize()
            )
        }

        composable(route = Screen.ClubsScreen.route) {
            Box(
                modifier = Modifier.fillMaxSize()
            )
        }

        composable(route = Screen.NotificationsScreen.route) {
            Box(
                modifier = Modifier.fillMaxSize()
            )
        }

        composable(route = Screen.MenuScreen.route) {
            Box(
                modifier = Modifier.fillMaxSize()
            )
        }

    }
}
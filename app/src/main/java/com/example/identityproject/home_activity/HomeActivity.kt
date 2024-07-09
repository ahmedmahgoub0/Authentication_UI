package com.example.identityproject.home_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.identityproject.ui.theme.IdentityProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IdentityProjectTheme {

                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        val visibility = currentRoute(navController) in listOf(
                            BottomNavBarItems.Home.route,
                            BottomNavBarItems.Search.route,
                            BottomNavBarItems.Clubs.route,
                            BottomNavBarItems.Notification.route,
                            BottomNavBarItems.Menu.route
                        )
                        BottomBar(navController = navController, visibility = visibility)
                    }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        HomeNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}
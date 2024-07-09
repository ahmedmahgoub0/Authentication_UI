package com.example.identityproject.screen.login.one_screen_login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.identityproject.main.Screen
import com.example.identityproject.screen.login.LoginViewModel

private val LOGIN_ROUTE = Screen.LoginScreen.route

fun NavGraphBuilder.loginScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel
) {
    composable(route = LOGIN_ROUTE) {
        LoginScreen(navController = navController, viewModel = loginViewModel)
    }
}

fun NavController.navigateToLogin() {
    navigate(LOGIN_ROUTE) {
        launchSingleTop = true
    }
}
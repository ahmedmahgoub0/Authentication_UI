package com.example.identityproject.screen.login.password

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.identityproject.main.Screen
import com.example.identityproject.screen.login.LoginViewModel

private val LOGIN_PASSWORD_ROUTE = Screen.LoginPasswordScreen.route

fun NavGraphBuilder.loginPasswordRoute(
    navHostController: NavHostController,
    loginViewModel: LoginViewModel
) {
    composable(route = LOGIN_PASSWORD_ROUTE) {
        LogInPasswordScreen(navController = navHostController, viewModel = loginViewModel)
    }
}

fun NavController.navigateToLoginPassword() {
    navigate(route = LOGIN_PASSWORD_ROUTE) {
        launchSingleTop = true
    }
}
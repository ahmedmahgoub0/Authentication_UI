package com.example.identityproject.screen.login.username

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.identityproject.main.Screen
import com.example.identityproject.screen.login.LoginViewModel

private val LOGIN_USERNAME_ROUTE = Screen.LoginUserNameScreen.route

fun NavGraphBuilder.loginUserNameRoute(
    navHostController: NavHostController,
    loginViewModel: LoginViewModel
) {
    composable(LOGIN_USERNAME_ROUTE) {
        LoginUserNameScreen(navController = navHostController, viewModel = loginViewModel)
    }
}

fun NavController.navigateToLoginUserName() {
    navigate(route = LOGIN_USERNAME_ROUTE) {
        popUpTo(route = LOGIN_USERNAME_ROUTE)
        launchSingleTop = true
    }
}
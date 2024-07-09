package com.example.identityproject.screen.signup.name

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.identityproject.main.Screen
import com.example.identityproject.screen.signup.SignupViewModel

private val SIGNUP_NAME_ROUTE = Screen.SignupNameScreen.route

fun NavGraphBuilder.signupNameRoute(
    navController: NavHostController,
    signupViewModel: SignupViewModel
) {
    composable(route = SIGNUP_NAME_ROUTE) {
        SignupNameScreen(navController = navController, viewModel = signupViewModel)
    }
}

fun NavController.navigateToSignupName() {
    navigate(route = SIGNUP_NAME_ROUTE) {
        launchSingleTop = true
    }
}
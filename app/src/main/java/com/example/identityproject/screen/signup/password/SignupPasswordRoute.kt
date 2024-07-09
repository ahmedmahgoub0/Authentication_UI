package com.example.identityproject.screen.signup.password

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.identityproject.main.Screen
import com.example.identityproject.screen.signup.SignupViewModel

private val SIGNUP_PASSWORD_ROUTE = Screen.SignupPasswordScreen.route

fun NavGraphBuilder.signupPasswordRoute(
    navController: NavHostController,
    signupViewModel: SignupViewModel
) {
    composable(route = SIGNUP_PASSWORD_ROUTE) {
        SignupPasswordScreen(navController = navController, viewModel = signupViewModel)
    }
}

fun NavController.navigateToSignupPassword() {
    navigate(route = SIGNUP_PASSWORD_ROUTE) {
        launchSingleTop = true
    }
}
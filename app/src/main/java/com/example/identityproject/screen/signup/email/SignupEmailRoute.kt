package com.example.identityproject.screen.signup.email

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.identityproject.main.Screen
import com.example.identityproject.screen.signup.SignupViewModel

private val SIGNUP_EMAIL_ROUTE = Screen.SignupEmailScreen.route

fun NavGraphBuilder.signupEmailRoute(
    navController: NavHostController,
    signupViewModel: SignupViewModel
) {
    composable(route = SIGNUP_EMAIL_ROUTE) {
        SignupEmailScreen(navController = navController, viewModel = signupViewModel)
    }
}

fun NavController.navigateToSignupEmail() {
    navigate(SIGNUP_EMAIL_ROUTE) {
        popUpTo(route = SIGNUP_EMAIL_ROUTE)
        launchSingleTop = true
    }
}
package com.example.identityproject.screen.signup.birthdate

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.identityproject.main.Screen
import com.example.identityproject.screen.signup.SignupViewModel

private val SIGNUP_BIRTHDATE_ROUTE = Screen.SignupBirthdateScreen.route

fun NavGraphBuilder.signupBirthdateRoute(
    navController: NavHostController,
    signupViewModel: SignupViewModel
) {
    composable(route = SIGNUP_BIRTHDATE_ROUTE) {
        SignupBirthdateScreen(navController = navController, viewModel = signupViewModel)
    }
}

fun NavController.navigateToSignupBirthdate() {
    navigate(route = SIGNUP_BIRTHDATE_ROUTE) {
        launchSingleTop = true
    }
}
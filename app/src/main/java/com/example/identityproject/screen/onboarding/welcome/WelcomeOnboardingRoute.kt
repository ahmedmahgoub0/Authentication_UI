package com.example.identityproject.screen.onboarding.welcome

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.identityproject.main.Screen

private val WELCOME_ONBOARDING_ROUTE = Screen.WelcomeScreen.route

fun NavGraphBuilder.welcomeOnboardingRoute(navController: NavHostController) {
    composable(route = WELCOME_ONBOARDING_ROUTE) {
        WelcomeOnboardingScreen(navController = navController)
    }
}
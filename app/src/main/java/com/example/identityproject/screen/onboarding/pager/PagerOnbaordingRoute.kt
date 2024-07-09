package com.example.identityproject.screen.onboarding.pager

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.identityproject.main.Screen

private val ON_BOARDING_PAGER_ROUTE = Screen.OnboardingPagerScreen.route

fun NavGraphBuilder.onBoardingPagerRoute(navHostController: NavHostController) {
    composable(ON_BOARDING_PAGER_ROUTE) {
        OnBoardingPagerScreen(navHostController)
    }
}

fun NavController.navigateToOnBoardingPager() {
    navigate(route = ON_BOARDING_PAGER_ROUTE) {
        launchSingleTop = true
    }
}
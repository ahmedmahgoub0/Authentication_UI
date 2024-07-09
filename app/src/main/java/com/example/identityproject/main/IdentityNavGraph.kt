package com.example.identityproject.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.identityproject.screen.login.LoginViewModel
import com.example.identityproject.screen.login.one_screen_login.loginScreen
import com.example.identityproject.screen.login.password.loginPasswordRoute
import com.example.identityproject.screen.login.username.loginUserNameRoute
import com.example.identityproject.screen.onboarding.pager.onBoardingPagerRoute
import com.example.identityproject.screen.onboarding.welcome.welcomeOnboardingRoute
import com.example.identityproject.screen.signup.SignupViewModel
import com.example.identityproject.screen.signup.birthdate.signupBirthdateRoute
import com.example.identityproject.screen.signup.email.signupEmailRoute
import com.example.identityproject.screen.signup.name.signupNameRoute
import com.example.identityproject.screen.signup.password.signupPasswordRoute

@Composable
fun IdentityNavGraph(
    navController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel(),
    signupViewModel: SignupViewModel = hiltViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route
    ) {
        welcomeOnboardingRoute(navController)
        onBoardingPagerRoute(navController)

        loginUserNameRoute(navController, loginViewModel)
        loginPasswordRoute(navController, loginViewModel)
        loginScreen(navController, loginViewModel)

        signupEmailRoute(navController, signupViewModel)
        signupPasswordRoute(navController, signupViewModel)
        signupNameRoute(navController, signupViewModel)
        signupBirthdateRoute(navController, signupViewModel)
    }
}
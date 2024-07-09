package com.example.identityproject.main

sealed class Screen(val route: String) {
    object WelcomeScreen : Screen("welcomeScreen")
    object OnboardingPagerScreen : Screen("onboardingPagerScreen")

    object LoginUserNameScreen : Screen("loginUserNameScreen")
    object LoginPasswordScreen : Screen("loginPasswordScreen")
    object LoginScreen : Screen("loginScreen") // just a try for login screen in one page

    object SignupEmailScreen : Screen("signupEmailScreen")
    object SignupPasswordScreen : Screen("signupPasswordScreen")
    object SignupNameScreen : Screen("signupNameScreen")
    object SignupBirthdateScreen : Screen("signupBirthdateScreen")


    object HomeScreen : Screen("homeScreen")
    object ClubsScreen : Screen("clubsScreen")
    object SearchScreen : Screen("searchScreen")
    object NotificationsScreen : Screen("notificationsScreen")
    object MenuScreen : Screen("menuScreen")

}
package com.example.identityproject.screen.onboarding.pager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.identityproject.R
import com.example.identityproject.composables.AuthButton
import com.example.identityproject.screen.login.username.navigateToLoginUserName
import com.example.identityproject.screen.signup.email.navigateToSignupEmail


@Composable
fun OnBoardingPagerScreen(
    navController: NavController
) {
    OnBoardingPagerContent({
        navController.navigateToSignupEmail()
    }, {
        navController.navigateToLoginUserName()
    })
}

@Composable
fun OnBoardingPagerContent(
    onClickSignUpScreen: () -> Unit,
    onClickLogInScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 16.dp),
    ) {

        ViewPagerSlider(
            Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.height(16.dp))


        AuthButton(
            onClick = onClickSignUpScreen,
            text = stringResource(id = R.string.sign_up),
        )

        Spacer(modifier = Modifier.height(16.dp))

        AuthButton(
            onClick = onClickLogInScreen,
            text = stringResource(id = R.string.login),
            buttonColor = MaterialTheme.colorScheme.surface,
            textColor = MaterialTheme.colorScheme.onPrimary
        )
    }
}
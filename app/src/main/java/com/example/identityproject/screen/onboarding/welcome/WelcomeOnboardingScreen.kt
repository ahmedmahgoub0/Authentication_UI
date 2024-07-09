package com.example.identityproject.screen.onboarding.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.identityproject.R
import com.example.identityproject.composables.AuthButton
import com.example.identityproject.composables.ClubText
import com.example.identityproject.screen.onboarding.pager.navigateToOnBoardingPager

@Composable
fun WelcomeOnboardingScreen(
    navController: NavController
) {
    WelcomeOnboardingScreenContent {
        navController.navigateToOnBoardingPager()
    }
}

@Composable
fun WelcomeOnboardingScreenContent(
    onClickNextScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 16.dp)
    ) {

        Box(Modifier.weight(1f)) {
            WelcomeOnBoardImage(
                painter = painterResource(id = R.drawable.welcome),
                description = stringResource(id = R.string.welcome)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        ClubText()

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(id = R.string.have_fun),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.onboard_body),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))
        AuthButton(
            onClick = onClickNextScreen,
            text = stringResource(id = R.string.lets_do),
            buttonModifier = Modifier
                .wrapContentSize()
                .align(Alignment.End)
                .padding(horizontal = 24.dp),
            textModifier = Modifier
                .padding(vertical = 8.dp, horizontal = 24.dp)
        )
    }
}
package com.example.identityproject.screen.login.username

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.identityproject.R
import com.example.identityproject.composables.AuthButton
import com.example.identityproject.composables.BackButton
import com.example.identityproject.composables.InputText
import com.example.identityproject.composables.NavigateToAnotherScreen
import com.example.identityproject.screen.login.LoginUIState
import com.example.identityproject.screen.login.LoginViewModel
import com.example.identityproject.screen.login.password.navigateToLoginPassword
import com.example.identityproject.screen.signup.email.navigateToSignupEmail

@Composable
fun LoginUserNameScreen(
    navController: NavController,
    viewModel: LoginViewModel
) {
    val state by viewModel.uiState.collectAsState()
    LoginUserNameContent(
        state = state,
        onChangeUserName = viewModel::onChangeUserName,
        onClickContinue = {
            navController.navigateToLoginPassword()
        },
        onClickBack = { navController.navigateUp() },
        onNavigate = {
            navController.navigateToSignupEmail()
        }
    )
}

@Composable
private fun LoginUserNameContent(
    state: LoginUIState,
    onChangeUserName: (String) -> Unit,
    onClickContinue: () -> Unit,
    onClickBack: () -> Unit,
    onNavigate: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        BackButton(onClick = onClickBack)

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.log_in),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.user_name),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        Spacer(Modifier.height(14.dp))
        InputText(
            type = KeyboardType.Text,
            placeHolder = stringResource(id = R.string.user_name_place_holder),
            text = state.userName,
            onTextChange = onChangeUserName
        )

        Spacer(modifier = Modifier.height(24.dp))
        AuthButton(
            onClick = onClickContinue,
            isEnabled = state.userName.isNotEmpty(),
            text = stringResource(id = R.string.continue_label),
            buttonModifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        NavigateToAnotherScreen(
            hintText = R.string.navigate_to_signup,
            navigateText = R.string.sign_up,
            onNavigate = onNavigate
        )
    }
}
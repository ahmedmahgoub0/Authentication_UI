package com.example.identityproject.screen.login.one_screen_login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.identityproject.R
import com.example.identityproject.base.ErrorMessageType
import com.example.identityproject.composables.AuthButton
import com.example.identityproject.composables.BackButton
import com.example.identityproject.composables.InputText
import com.example.identityproject.composables.Loading
import com.example.identityproject.composables.NavigateToAnotherScreen
import com.example.identityproject.composables.PasswordInputText
import com.example.identityproject.main.navigateToHome
import com.example.identityproject.screen.login.LoginUIState
import com.example.identityproject.screen.login.LoginViewModel
import com.example.identityproject.screen.login.isEnabledWithEmailAndPassword

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel
) {
    val state by viewModel.uiState.collectAsState()
    LoginContent(
        state = state,
        onChangeUserName = viewModel::onChangeUserName,
        onChangePassword = viewModel::onChangePassword,
        onLogin = viewModel::onLogin,
        onClickBack = { navController.navigateUp() },
        onValidatePassword = viewModel::onValidatePassword,
        onNavigate = {
            // TODO: navigate to signup screen
        }
    )

}

@Composable
fun LoginContent(
    state: LoginUIState,
    onChangeUserName: (String) -> Unit,
    onChangePassword: (String) -> Unit,
    onLogin: () -> Unit,
    onValidatePassword: () -> Boolean,
    onClickBack: () -> Unit,
    onNavigate: () -> Unit
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
                .imePadding()
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

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = R.string.your_password),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(Modifier.height(14.dp))
            PasswordInputText(
                placeHolder = stringResource(id = R.string.password_place_holder),
                text = state.password,
                onTextChange = onChangePassword,
            )

            Spacer(modifier = Modifier.height(24.dp))
            AuthButton(
                onClick = onLogin,
                isEnabled = state.isEnabledWithEmailAndPassword(),
                text = stringResource(id = R.string.log_in),
                buttonModifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            )

            if (state.errorType != ErrorMessageType.NO_ERROR) com.example.identityproject.composables.Error(
                errorMessage = when (state.errorType) {
                    ErrorMessageType.WRONG_PASSWORD -> stringResource(R.string.wrong_password_message)
                    ErrorMessageType.NOT_EXIST -> stringResource(R.string.user_not_exist_message)
                    ErrorMessageType.NOT_VALIDATED -> stringResource(R.string.not_validated_message)
                    else -> stringResource(R.string.unknown_error_message)
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.weight(1f))

            NavigateToAnotherScreen(
                hintText = R.string.navigate_to_signup,
                navigateText = R.string.sign_up,
                onNavigate = onNavigate
            )

        }
        if (state.isLoading) {
            Loading()
        }
    }

    LaunchedEffect(key1 = state.isLoading) {
        if (state.isSuccess) {
            navigateToHome(context)
        }
    }
}
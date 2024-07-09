package com.example.identityproject.screen.signup.password

import androidx.compose.foundation.background
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.identityproject.R
import com.example.identityproject.composables.AuthButton
import com.example.identityproject.composables.BackButton
import com.example.identityproject.composables.EmailDescriptionText
import com.example.identityproject.composables.NavigateToAnotherScreen
import com.example.identityproject.composables.PasswordInputText
import com.example.identityproject.screen.login.username.navigateToLoginUserName
import com.example.identityproject.screen.signup.SignupUiState
import com.example.identityproject.screen.signup.SignupViewModel
import com.example.identityproject.screen.signup.name.navigateToSignupName

@Composable
fun SignupPasswordScreen(
    navController: NavController,
    viewModel: SignupViewModel
) {
    val state by viewModel.uiState.collectAsState()
    SignUpConfirmPasswordContent(
        state = state,
        onConfirmCorrect = viewModel::onConfirmPassword,
        onValidate = viewModel::onValidatePassword,
        onChangePassword = viewModel::onChangePassword,
        onChangeConfirmPassword = viewModel::onChangeConfirmPassword,
        onClickSignupFirstNameScreen = {
            navController.navigateToSignupName()
        },
        onClickBack = { navController.navigateUp() },
        onNavigate = { navController.navigateToLoginUserName() }
    )
}

@Composable
fun SignUpConfirmPasswordContent(
    state: SignupUiState,
    onConfirmCorrect: () -> Boolean,
    onValidate: () -> Boolean,
    onChangePassword: (String) -> Unit,
    onChangeConfirmPassword: (String) -> Unit,
    onClickSignupFirstNameScreen: () -> Unit,
    onClickBack: () -> Unit,
    onNavigate: () -> Unit
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
            text = stringResource(id = R.string.sign_up),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(start = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        EmailDescriptionText(
            email = state.email,
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(id = R.string.your_password),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(start = 8.dp)
        )

        Spacer(Modifier.height(14.dp))

        PasswordInputText(
            placeHolder = stringResource(id = R.string.password_place_holder),
            text = state.password,
            onTextChange = onChangePassword,
            match = onConfirmCorrect.invoke()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(id = R.string.confirm_password),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(start = 8.dp)
        )

        Spacer(Modifier.height(14.dp))
        PasswordInputText(
            placeHolder = stringResource(id = R.string.password_place_holder),
            text = state.confirmPassword,
            onTextChange = onChangeConfirmPassword,
            match = onConfirmCorrect.invoke()
        )

        Spacer(modifier = Modifier.height(24.dp))

        AuthButton(
            buttonModifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            onClick = onClickSignupFirstNameScreen,
            isEnabled = onValidate.invoke(),
            text = stringResource(id = R.string.continue_label)
        )

        Spacer(modifier = Modifier.weight(1f))

        NavigateToAnotherScreen(
            hintText = R.string.navigate_to_login,
            navigateText = R.string.log_in,
            onNavigate = onNavigate
        )
    }
}
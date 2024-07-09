package com.example.identityproject.screen.signup.email

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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.identityproject.R
import com.example.identityproject.composables.AuthButton
import com.example.identityproject.composables.BackButton
import com.example.identityproject.composables.InputText
import com.example.identityproject.composables.NavigateToAnotherScreen
import com.example.identityproject.screen.login.username.navigateToLoginUserName
import com.example.identityproject.screen.signup.SignupUiState
import com.example.identityproject.screen.signup.SignupViewModel
import com.example.identityproject.screen.signup.password.navigateToSignupPassword
import com.example.identityproject.ui.theme.mediumCaption

@Composable
fun SignupEmailScreen(
    navController: NavController,
    viewModel: SignupViewModel
) {
    val state by viewModel.uiState.collectAsState()
    SignupEmailContent(
        state = state,
        onChangeEmail = viewModel::onChangeEmail,
        onValidateEmailType = viewModel::checkIfGmailOrAnotherType,
        onClickPasswordScreen = {
            navController.navigateToSignupPassword()
        },
        onClickBack = { navController.navigateUp() },
        onNavigate = { navController.navigateToLoginUserName() }
    )
}

@Composable
fun SignupEmailContent(
    state: SignupUiState,
    onChangeEmail: (String) -> Unit,
    onClickPasswordScreen: () -> Unit,
    onValidateEmailType: (String) -> Boolean,
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

        Spacer(Modifier.height(24.dp))

        Text(
            text = stringResource(id = R.string.email),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(start = 8.dp)
        )

        Spacer(Modifier.height(14.dp))

        InputText(
            type = KeyboardType.Email,
            placeHolder = stringResource(id = R.string.email_place_holder),
            text = state.email,
            onTextChange = onChangeEmail
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = stringResource(id = R.string.note_email),
            style = MaterialTheme.typography.mediumCaption,
            textAlign = TextAlign.Start,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(Modifier.height(24.dp))

        AuthButton(
            buttonModifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            isEnabled = onValidateEmailType.invoke(state.email),
            onClick = onClickPasswordScreen,
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

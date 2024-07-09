package com.example.identityproject.screen.signup.name

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.identityproject.R
import com.example.identityproject.composables.AuthButton
import com.example.identityproject.composables.BackButton
import com.example.identityproject.composables.EmailDescriptionText
import com.example.identityproject.composables.InputText
import com.example.identityproject.composables.NavigateToAnotherScreen
import com.example.identityproject.screen.login.username.navigateToLoginUserName
import com.example.identityproject.screen.signup.SignupUiState
import com.example.identityproject.screen.signup.SignupViewModel
import com.example.identityproject.screen.signup.birthdate.navigateToSignupBirthdate

@Composable
fun SignupNameScreen(
    navController: NavController,
    viewModel: SignupViewModel
) {
    val state by viewModel.uiState.collectAsState()
    SignUpFullNameContent(
        state,
        onChangeFullName = viewModel::onChangeFullName,
        onChangeUserName = viewModel::onChangeUserName,
        onValidate = viewModel::onValidateName,
        onClickBack = { navController.navigateUp() },
        onClickUserNameScreen = {
            navController.navigateToSignupBirthdate()
        },
        onNavigate = { navController.navigateToLoginUserName() }
    )
}

@Composable
private fun SignUpFullNameContent(
    state: SignupUiState,
    onClickBack: () -> Unit,
    onClickUserNameScreen: () -> Unit,
    onChangeFullName: (String) -> Unit,
    onChangeUserName: (String) -> Unit,
    onValidate: () -> Boolean,
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

        Text(
            text = stringResource(id = R.string.sign_up),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(start = 8.dp, top = 24.dp, bottom = 8.dp),
        )

        EmailDescriptionText(
            email = state.email,
        )

        Text(
            text = stringResource(id = R.string.full_naame),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(start = 8.dp, top = 24.dp, bottom = 14.dp)
        )

        InputText(
            type = KeyboardType.Text,
            placeHolder = stringResource(id = R.string.name_hint),
            text = state.firstName,
            onTextChange = onChangeFullName,
        )

        Text(
            text = stringResource(id = R.string.user_name),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(start = 8.dp, top = 24.dp, bottom = 14.dp)
        )

        InputText(
            type = KeyboardType.Text,
            placeHolder = stringResource(id = R.string.user_name_hint),
            text = state.username,
            onTextChange = onChangeUserName
        )

        AuthButton(
            onClick = onClickUserNameScreen,
            buttonModifier = Modifier
                .padding(horizontal = 8.dp, vertical = 24.dp)
                .fillMaxWidth(),
            isEnabled = onValidate.invoke(),
            text = stringResource(id = R.string.continue_label),
        )

        Spacer(modifier = Modifier.weight(1f))

        NavigateToAnotherScreen(
            hintText = R.string.navigate_to_login,
            navigateText = R.string.log_in,
            onNavigate = onNavigate
        )
    }

}
package com.example.identityproject.screen.signup.birthdate

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.identityproject.R
import com.example.identityproject.base.ErrorMessageType
import com.example.identityproject.composables.AuthButton
import com.example.identityproject.composables.BackButton
import com.example.identityproject.composables.EmailDescriptionText
import com.example.identityproject.composables.Error
import com.example.identityproject.composables.Loading
import com.example.identityproject.composables.NavigateToAnotherScreen
import com.example.identityproject.main.navigateToHome
import com.example.identityproject.screen.login.username.navigateToLoginUserName
import com.example.identityproject.screen.signup.SignupUiState
import com.example.identityproject.screen.signup.SignupViewModel
import com.example.identityproject.screen.signup.composables.SegmentControls
import com.example.identityproject.util.toFormattedString
import com.maxkeppeker.sheets.core.models.base.Header
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SignupBirthdateScreen(
    navController: NavController,
    viewModel: SignupViewModel
) {
    val state by viewModel.uiState.collectAsState()

    SignupBirthdateAndGanderContent(
        state = state,
        onChangeGender = viewModel::onChangeGender,
        onChangeBirthdate = viewModel::onChangeBirthdate,
        onClickBack = { navController.navigateUp() },
        onNavigate = { navController.navigateToLoginUserName() },
        onCreateAccount = viewModel::onSignup,
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun SignupBirthdateAndGanderContent(
    state: SignupUiState,
    onClickBack: () -> Unit,
    onChangeBirthdate: (String) -> Unit,
    onChangeGender: (String) -> Unit,
    onCreateAccount: () -> Unit,
    onNavigate: () -> Unit,
) {

    val context = LocalContext.current

    val calendarState = rememberUseCaseState()
    CalendarDialog(
        state = calendarState,
        selection = CalendarSelection.Date { date ->
            val stringDate = date.toFormattedString()
            onChangeBirthdate(stringDate)
        },
        config = CalendarConfig(
            monthSelection = true,
            yearSelection = true,
            boundary = LocalDate.of(1940, 1, 1)..LocalDate.now()
        ),
        header = Header.Default(title = "Select Date")
    )

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
            text = stringResource(id = R.string.birth_date),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(start = 8.dp)
        )

        Spacer(Modifier.height(14.dp))

        //DatePickerFun(
        //  birthDate = state.birthdate,
        //onDateChange = onChangeBirthdate
        //)

        DatePickerField(
            birthDate = state.birthdate,
            enabled = !state.isLoading
        ) {
            calendarState.show()
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(id = R.string.gender),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(start = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        SegmentControls(
            enabled = !state.isLoading,
            onChangeGander = onChangeGender
        )

        Spacer(modifier = Modifier.height(24.dp))

        AuthButton(
            onClick = onCreateAccount,
            isEnabled = !state.isLoading,
            buttonModifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            text = stringResource(id = R.string.create_account_label),
        )

        if (state.errorType != ErrorMessageType.NO_ERROR) {
            Error(
                errorMessage = when (state.errorType) {
                    ErrorMessageType.INVALID_USERNAME -> stringResource(R.string.invalid_username_message)
                    ErrorMessageType.USERNAME_INUSE -> stringResource(R.string.username_inuse_error_message)
                    ErrorMessageType.EMAIL_INUSE -> stringResource(R.string.email_inuse_error_message)
                    else -> stringResource(id = R.string.unknown_error_message)
                },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        NavigateToAnotherScreen(
            hintText = R.string.navigate_to_login,
            navigateText = R.string.log_in,
            onNavigate = onNavigate,
            enabled = !state.isLoading
        )
    }

    if (state.isLoading) {
        Loading()
    }

    LaunchedEffect(key1 = state.isLoading) {
        if (state.isSuccess) {
            navigateToHome(context)
            Toast.makeText(context, R.string.success_message, Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun DatePickerField(
    birthDate: String,
    enabled: Boolean = true,
    showDatePicker: () -> Unit,
) {
    Row(
        Modifier
            .padding(8.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(100.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = birthDate,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth()
                .weight(1f)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_down_circle),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier
                .padding(16.dp)
                .then(if (enabled) Modifier.clickable { showDatePicker() } else Modifier)
        )
    }
}
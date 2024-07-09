package com.example.identityproject.screen.signup

import androidx.lifecycle.viewModelScope
import com.example.identityproject.base.BaseViewModel
import com.example.identityproject.base.ErrorMessageType
import com.example.identityproject.util.AccountValidationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
//    private val signupUseCase: SignupUseCase,
    private val accountValidationUseCase: AccountValidationUseCase,
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(SignupUiState())
    val uiState = _uiState.asStateFlow()

    fun onSignup() {
        onLoading()
        makeSignupRequest()
    }

    private fun onLoading() {
        _uiState.update {
            it.copy(
                isLoading = true,
                isSuccess = false,
                errorType = ErrorMessageType.NO_ERROR
            )
        }
    }

    private fun makeSignupRequest() {
        viewModelScope.launch(Dispatchers.IO) {
            val state = _uiState.value
            val userData = UserData(
                fullName = state.firstName,
                jobTitle = state.jobTitle,
                fcmToken = "_",
                email = state.email,
                reEmail = state.email,
                gender = state.gender,
                birthdate = state.birthdate,
                username = state.username,
                password = state.password,
            )
            try {
                delay(1500) // Try the ui
                // val userId = signupUseCase(userData)
                onSuccess()
            } catch (t: Throwable) {
                onError(errorMessage = t)
            }
        }
    }

    private fun onSuccess() {
        _uiState.update {
            it.copy(
                isSuccess = true,
                errorType = ErrorMessageType.NO_ERROR,
                isLoading = false
            )
        }
    }

    private fun onError(errorMessage: Throwable) {
        _uiState.update {
            it.copy(
                errorType = getErrorTypeValue(errorMessage),
                isSuccess = false,
                isLoading = false
            )
        }
    }

    fun onChangeEmail(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun checkIfGmailOrAnotherType(email: String): Boolean {
        return email.isEmailValid()
    }

    private fun String.isEmailValid(): Boolean {
        return this.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
                && validDomain(this)
    }

    private fun validDomain(email: String): Boolean {
        val domain = email.substringAfter("@")
        return (domain.lowercase() in listOf("gmail.com", "yahoo.com", "hotmail.com"))
    }

    fun onChangePassword(password: String) {
        _uiState.update { it.copy(password = password) }
    }

    fun onChangeConfirmPassword(password: String) {
        _uiState.update { it.copy(confirmPassword = password) }
    }

    fun onConfirmPassword(): Boolean {
        val state = _uiState.value
        return accountValidationUseCase.checkPasswordMatching(state.password, state.confirmPassword)
    }

    fun onValidatePassword(): Boolean {
        val state = _uiState.value
        return accountValidationUseCase.validatePassword(state.password)
                && onConfirmPassword()
    }

    fun onChangeFullName(fullName: String) {
        _uiState.update { it.copy(firstName = fullName) }
    }

    fun onChangeUserName(userName: String) {
        _uiState.update { it.copy(username = userName) }
    }

    fun onValidateName(): Boolean {
        val state = _uiState.value
        return accountValidationUseCase.validateName(state.firstName, state.username)
    }

    fun onChangeBirthdate(birthdate: String) {
        _uiState.update { it.copy(birthdate = birthdate) }
    }

    fun onChangeGender(gender: String) {
        _uiState.update { it.copy(gender = gender) }
    }
}
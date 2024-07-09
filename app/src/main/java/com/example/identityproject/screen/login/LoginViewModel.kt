package com.example.identityproject.screen.login

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
class LoginViewModel @Inject constructor(
    //private val loginUseCase: LoginUseCase,
    private val accountValidationUseCase: AccountValidationUseCase,
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(LoginUIState())
    val uiState = _uiState.asStateFlow()

    fun onLogin() {
        onLoading()
        makeLoginRequest()
    }

    private fun onLoading() {
        _uiState.update {
            it.copy(
                isLoading = true,
                isSuccess = false,
                errorType = ErrorMessageType.NO_ERROR,
            )
        }
    }

    private fun makeLoginRequest() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delay(2000)
                val user = User(
                    birthdate = "2002-02-02",
                    email = "ahmedmahgoub0003@gmail.com",
                    fullName = "Ahmed Mahgoub",
                    gender = "Male",
                    guid = 7777,
                    language = "Kotlin",
                    jobTitle = "Android developer",
                    username = "ahmed_mahgoub03"
                )
                _uiState.update {
                    it.copy(userId = user.guid)
                }
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

    fun onChangeUserName(userName: String) {
        _uiState.update { it.copy(userName = userName) }
    }

    fun onChangePassword(password: String) {
        if (!uiState.value.isLoading) {
            _uiState.update { it.copy(password = password) }
        }
    }

    fun onValidatePassword(): Boolean {
        val state = _uiState.value
        return accountValidationUseCase.validatePassword(state.password)
    }
}

data class User(
    val birthdate: String,
    val email: String,
    val fullName: String,
    val gender: String,
    val guid: Int,
    val language: String,
    val jobTitle: String,
    val username: String,
)
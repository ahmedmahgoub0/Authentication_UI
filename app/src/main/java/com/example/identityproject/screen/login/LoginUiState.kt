package com.example.identityproject.screen.login

import com.example.identityproject.base.ErrorMessageType

data class LoginUIState(
    val userName: String = "",
    val password: String = "",
    val errorType: ErrorMessageType = ErrorMessageType.NO_ERROR,
    val isSuccess: Boolean = false,
    val isLoading: Boolean = false,
    val userId: Int = 0
)


fun LoginUIState.isEnabled(): Boolean {
    return !isLoading && password.length > 6
}

fun LoginUIState.isEnabledWithEmailAndPassword(): Boolean {
    return !isLoading && userName.isNotEmpty() && password.length > 6
}

fun LoginUIState.isEnabledChangePassword(): Boolean {
    return !isLoading
}
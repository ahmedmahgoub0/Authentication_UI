package com.example.identityproject.screen.signup

import com.example.identityproject.base.ErrorMessageType

data class SignupUiState(
    val birthdate: String = "11/11/2001",
    val email: String = "",
    val reEmail: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val gender: String = "male",
    val username: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val jobTitle: String = "",
    val errorType: ErrorMessageType = ErrorMessageType.NO_ERROR,
    val isSuccess: Boolean = false,
    val isLoading: Boolean = false
)

data class UserData(
    val fullName: String = "",
    val jobTitle: String = "",
    val fcmToken: String = "",
    val email: String = "",
    val reEmail: String = "",
    val gender: String = "",
    val birthdate: String = "",
    val username: String = "",
    val password: String = "",
    val userId: Int = 0,
    val newEmail: String = "",
    val newGender: String = "",
    val currentPassword: String = "",
    val newFullName: String = "",
    val newFcmToken: String = "",
    val newJobTitle: String = ""
)
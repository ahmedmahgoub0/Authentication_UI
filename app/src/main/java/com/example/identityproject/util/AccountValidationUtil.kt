package com.example.identityproject.util

import javax.inject.Inject

class AccountValidationUseCase @Inject constructor() {

    fun validateName(firstName: String, userName: String): Boolean {
        return firstName.isNotEmpty() && userName.isNotEmpty()
    }

    fun validatePassword(password: String): Boolean {
        return password.length > 6
    }

    fun checkPasswordMatching(password: String, confirmPassword: String): Boolean {
        return password == confirmPassword && password.isNotEmpty()
    }

    fun validateJobTitle(jobTitle: String): Boolean {
        return jobTitle.isNotEmpty()
    }
}
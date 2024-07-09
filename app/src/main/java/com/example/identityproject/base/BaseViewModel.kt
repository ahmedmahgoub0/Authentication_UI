package com.example.identityproject.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    fun getErrorTypeValue(t: Throwable): ErrorMessageType {

        return when (t.message.toString()) {
            "Invalid username or password!" -> ErrorMessageType.WRONG_PASSWORD
            "No such a user exists" -> ErrorMessageType.NOT_EXIST
            "User not validated" -> ErrorMessageType.NOT_VALIDATED
            "username:error" -> ErrorMessageType.INVALID_USERNAME
            "username:inuse" -> ErrorMessageType.USERNAME_INUSE
            "email:inuse" -> ErrorMessageType.EMAIL_INUSE
            else -> ErrorMessageType.UNKNOWN_ERROR
        }
    }
}

enum class ErrorMessageType {
    NO_ERROR,
    WRONG_PASSWORD,
    NOT_EXIST,
    NOT_VALIDATED,
    INVALID_USERNAME,
    USERNAME_INUSE,
    EMAIL_INUSE,
    UNKNOWN_ERROR
}
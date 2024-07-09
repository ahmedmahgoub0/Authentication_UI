package com.example.identityproject.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import com.example.identityproject.R
import com.example.identityproject.ui.theme.PlusJakartaSans
import com.example.identityproject.ui.theme.inputText

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PasswordInputText(
    text: String,
    placeHolder: String,
    match: Boolean = false,
    enabled: Boolean = true,
    onTextChange: (String) -> Unit,
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        value = text,
        onValueChange = onTextChange,
        enabled = enabled,
        shape = RoundedCornerShape(size = 100.dp),
        visualTransformation = if (passwordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                if (match) {
                    TrailingIconPassword(icon = R.drawable.ic_match)
                } else {
                    if (passwordVisible) {
                        TrailingIconPassword(icon = R.drawable.ic_remove_eye)
                    } else {
                        TrailingIconPassword(icon = R.drawable.ic_hide)
                    }
                }
            }

        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.surface,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedTextColor = MaterialTheme.colorScheme.onPrimary
        ),
        singleLine = true,
        textStyle = TextStyle(
            fontFamily = PlusJakartaSans,
            textDirection = TextDirection.Content
        ),
        placeholder = {
            Text(
                text = placeHolder,
                style = MaterialTheme.typography.inputText,
                color = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier.fillMaxWidth()
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() }
        )
    )
}

@Composable
private fun TrailingIconPassword(
    icon: Int,
) {
    Icon(
        painter = painterResource(id = icon),
        "password",
        tint = MaterialTheme.colorScheme.onSecondary
    )

}


package com.example.identityproject.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun NavigateToAnotherScreen(
    hintText: Int,
    navigateText: Int,
    enabled: Boolean = true,
    onNavigate: () -> Unit
) {
    Column {
        Spacer(Modifier.height(8.dp))
        TextTwoToneColor(
            enabled = enabled,
            firstText = stringResource(id = hintText),
            secondText = stringResource(id = navigateText),
            navigate = onNavigate
        )
    }
}
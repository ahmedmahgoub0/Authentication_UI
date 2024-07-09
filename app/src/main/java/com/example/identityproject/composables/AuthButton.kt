package com.example.identityproject.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.identityproject.ui.theme.WhiteColor


@Composable
fun AuthButton(
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    text: String,
    buttonColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = WhiteColor,
    buttonModifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 23.dp),
    textModifier: Modifier = Modifier.padding(8.dp)
) {
    Button(
        modifier = buttonModifier
            .clip(RoundedCornerShape(100.dp)),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
        ),
        enabled = isEnabled,
    ) {
        Text(
            modifier = textModifier,
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = textColor
        )
    }
}
package com.example.identityproject.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.identityproject.R
import com.example.identityproject.ui.theme.LightPrimaryBrandColor

@Composable
fun EmailDescriptionText(
    email: String,
) {

    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onSurface)) {
                append(stringResource(id = R.string.using))
            }
            withStyle(style = SpanStyle(color = LightPrimaryBrandColor)) {
                append(email)
            }
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onSurface)) {
                append(stringResource(id = R.string.to_sign_up))
            }
        },
        style = MaterialTheme.typography.titleSmall,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        textAlign = TextAlign.Start
    )
}
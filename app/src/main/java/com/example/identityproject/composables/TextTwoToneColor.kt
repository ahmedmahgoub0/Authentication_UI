package com.example.identityproject.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import com.example.identityproject.ui.theme.LightPrimaryBrandColor
import com.example.identityproject.ui.theme.mediumCaption

@Composable
fun TextTwoToneColor(
    firstText: String,
    secondText: String,
    navigate: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onSecondary)) {
                    append("$firstText ")
                }
                withStyle(
                    style = SpanStyle(color = LightPrimaryBrandColor),
                ) {
                    append(secondText)
                }
            },
            style = MaterialTheme.typography.mediumCaption,
            modifier = Modifier
                .wrapContentSize()
                .noRippleClickable { navigate() },
            textAlign = TextAlign.Center
        )
    }
}


@SuppressLint("ModifierFactoryUnreferencedReceiver")
private fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}
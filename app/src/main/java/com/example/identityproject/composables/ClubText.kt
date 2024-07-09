package com.example.identityproject.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.identityproject.R
import com.example.identityproject.ui.theme.LightPrimaryBrandColor
import com.example.identityproject.ui.theme.PlusJakartaSans

@Composable
fun ClubText() {
    Row(
        modifier = Modifier.padding(start = 24.dp)
    ) {
        Text(
            text = stringResource(id = R.string.club),
            style = MaterialTheme.typography.titleMedium,
            color = LightPrimaryBrandColor
        )
        Text(
            text = "\uD83D\uDE4C",
            fontFamily = PlusJakartaSans,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
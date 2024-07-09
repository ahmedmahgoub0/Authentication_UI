package com.example.identityproject.screen.signup.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.identityproject.R
import com.example.identityproject.ui.theme.LightPrimaryBrandColor
import com.example.identityproject.ui.theme.WhiteColor

@Composable
fun SegmentControls(
    enabled: Boolean = true,
    onChangeGander: (String) -> Unit
) {
    val index = remember { mutableStateOf(0) }
    val genderItems = listOf(
        stringResource(id = R.string.male),
        stringResource(id = R.string.female)
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .wrapContentSize()
            .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(100.dp))
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .weight(1f)
            .wrapContentHeight()
            .clip(
                shape = RoundedCornerShape(100.dp)
            )
            .background(
                color = if (index.value == 0) LightPrimaryBrandColor else MaterialTheme.colorScheme.surface
            )
            .then(if (enabled) Modifier.clickable {
                index.value = 0
                onChangeGander("male")
            } else Modifier)
        ) {
            Text(
                modifier = Modifier.padding(vertical = 12.dp),
                text = genderItems.first(),
                color = if (index.value == 0) WhiteColor else MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f)
                .wrapContentHeight()
                .clip(shape = RoundedCornerShape(100.dp))
                .background(
                    color = if (index.value == 1) LightPrimaryBrandColor else MaterialTheme.colorScheme.surface
                )
                .then(if (enabled) Modifier.clickable {
                    index.value = 1
                    onChangeGander("female")
                } else Modifier)
        ) {
            Text(
                modifier = Modifier.padding(vertical = 12.dp),
                text = genderItems.last(),
                color = if (index.value == 1) WhiteColor else MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
package com.example.identityproject.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.core.text.layoutDirection
import com.example.identityproject.R
import java.util.Locale

@Composable
fun BackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true
) {
    Column(
        modifier = modifier.wrapContentSize(),
        horizontalAlignment = Alignment.Start
    ) {
        IconButton(onClick = onClick, enabled = isEnabled) {
            Icon(
                modifier = Modifier.flipWithLanguage(),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_back_arrow),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }
}

fun Modifier.flipWithLanguage(): Modifier {
    val isLayoutRtl = Locale.getDefault().layoutDirection == LayoutDirection.Rtl.ordinal
    return if (isLayoutRtl) this.scale(scaleX = -1f, scaleY = 1f) else this
}
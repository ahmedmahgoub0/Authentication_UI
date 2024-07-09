package com.example.identityproject.home_activity

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun MarqueeText(
    title: String,
    durationMillis: Int = 1000,
    delay: Int = 100
) {
    val scrollState = rememberScrollState()
    var shouldAnimated by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = shouldAnimated) {
        scrollState.animateScrollTo(
            scrollState.maxValue,
            animationSpec = tween(
                durationMillis, delay, easing = CubicBezierEasing(0f, 0f, 0f, 0f)
            )
        )
        scrollState.scrollTo(0)
        shouldAnimated = !shouldAnimated
    }

    Text(
        text = title,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .horizontalScroll(scrollState, false)
    )
}
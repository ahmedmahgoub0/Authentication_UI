package com.example.identityproject.screen.onboarding.pager

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.identityproject.composables.HorizontalPagerIndicator
import com.example.identityproject.ui.theme.LightPrimaryBrandColor
import com.example.identityproject.ui.theme.LightSecondaryBrandColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewPagerSlider(
    modifier: Modifier = Modifier
) {
    val pageState = rememberPagerState(
        initialPage = 0,
        pageCount = sliderDataList.size
    )

    LaunchedEffect(pageState.currentPage) {
        delay(2000)
        var newPosition = pageState.currentPage + 1
        if (newPosition > sliderDataList.lastIndex) newPosition = 0
        pageState.animateScrollToPage(newPosition)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {

        HorizontalPager(
            state = pageState,
            modifier = Modifier.weight(1f)
        ) { page ->
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                val sliderData = sliderDataList[page]

                OnBoardingImage(
                    sliderData = sliderData,
                    modifier = modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                Text(
                    text = sliderData.title ?: "",
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

                Spacer(modifier = Modifier.padding(vertical = 16.dp))
                Text(
                    text = sliderData.description,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

            }
        }
        Spacer(modifier = Modifier.padding(vertical = 16.dp))
        HorizontalPagerIndicator(
            pageCount = sliderDataList.size,
            pagerState = pageState,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 24.dp),
            activeColor = LightPrimaryBrandColor,
            inactiveColor = LightSecondaryBrandColor
        )
    }
}

@Composable
private fun OnBoardingImage(
    sliderData: SliderData,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier,
        contentScale = ContentScale.Fit,
        painter = painterResource(id = sliderData.image),
        contentDescription = null
    )
}

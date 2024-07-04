@file:OptIn(ExperimentalFoundationApi::class)

package com.example.summerpractice2024

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainScreen(
    heroList: List<MarvelHero>,
    navController: NavController,
    width: Int,
    height: Int
) {
    BackGround()
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.marvellogo),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(top = (0.0375 * height).dp)
                .width((0.33 * width).dp)
                .height((0.0375 * height).dp)
        )

        Text(
            text = "Choose your hero",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(top = (0.0675 * height).dp)
        )
        val lazyListState = rememberLazyListState()
        val snapBehavior = rememberSnapFlingBehavior(
            lazyListState = lazyListState
        )
        LazyRow(
            modifier = Modifier
                .padding(top = (0.08 * height).dp)
                .fillMaxSize(),
            state = lazyListState,
            flingBehavior = snapBehavior
        ) {
            val heroCount = heroList.size
            items(heroCount)
            {
                FunForLazyRow(
                    heroes = heroList,
                    heroIndex = it,
                    navController = navController,
                    width = width,
                    height = height
                )
            }
        }
    }
}

@Composable
private fun BackGround() {
    val gradient = Brush.linearGradient(
        0.3f to MaterialTheme.colorScheme.secondary,
        3.0f to MaterialTheme.colorScheme.primary,
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Box(
        modifier = Modifier
            .background(gradient)
            .fillMaxSize()
    )
}
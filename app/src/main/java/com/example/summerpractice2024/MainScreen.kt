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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainScreen(
    heroList: List<MarvelHero>,
    navController: NavController
) {
    BackGround()
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.marvellogo),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(top = 40.dp)
                .width(256.dp)
                .height(54.dp)
        )

        Text(
            text = "Choose your hero",
            style = TextStyle(
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = Bold,
                fontStyle = FontStyle.Normal
            ),
            modifier = Modifier
                .padding(top = 30.dp)
        )
        val lazyListState = rememberLazyListState()
        val snapBehavior = rememberSnapFlingBehavior(
            lazyListState = lazyListState
        )
        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp),
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
                )
            }
        }
    }
}

@Composable
fun BackGround() {
    val gradient = Brush.linearGradient(
        0.0f to Color.Black,
        600.0f to Color.Red,
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Box(modifier = Modifier
        .background(gradient)
        .fillMaxSize())
}
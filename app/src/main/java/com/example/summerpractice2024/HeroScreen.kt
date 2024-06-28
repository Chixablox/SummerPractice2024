package com.example.summerpractice2024

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun HeroScreen(
    heroes : List<MarvelHero>,
    heroIndex : Int?,
    navController : NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Box(
            contentAlignment = Alignment.BottomStart
        ) {

            val painter = rememberAsyncImagePainter(heroes[heroIndex!!].imageUrl)

            Image(
                painter = painter,
                contentDescription = "Background Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            Column(modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 60.dp)) {
                Text(
                    text = heroes[heroIndex].heroName,
                    style = TextStyle(color = Color.White, fontSize = 40.sp, fontWeight = Bold)
                    //modifier = Modifier.padding(40.dp)
                )
                Text(
                    text = heroes[heroIndex].heroDescription,
                    style = TextStyle(color = Color.White, fontSize = 20.sp, fontWeight = Bold)
                    //modifier = Modifier.padding(70.dp)
                )
            }
        }
    }
}
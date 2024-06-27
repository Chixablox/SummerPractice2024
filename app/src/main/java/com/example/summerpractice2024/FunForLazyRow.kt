package com.example.summerpractice2024

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun FunForLazyRow (hero: MarvelHero){
    Box(
        contentAlignment = Alignment.BottomStart
    ) {

        val painter = rememberAsyncImagePainter(hero.imageUrl)

        Image(
            painter = painter,
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(20.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .width(300.dp)
                .height(550.dp)
        )

        Text(
            text = hero.heroName,
            style = TextStyle(color= Color.White, fontSize = 32.sp, fontWeight = Bold),
            modifier = Modifier.padding(30.dp)
        )
    }
}
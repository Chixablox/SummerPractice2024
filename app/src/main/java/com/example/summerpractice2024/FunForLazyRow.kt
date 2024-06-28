package com.example.summerpractice2024

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun FunForLazyRow (heroes: List<MarvelHero>,
                   heroIndex: Int,
                   navController : NavController,
){
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = Modifier
            .clickable {
                navController.navigate(route= "HeroScreen/$heroIndex")
            }
    ) {

        val painter = rememberAsyncImagePainter(heroes[heroIndex].imageUrl)

        Image(
            painter = painter,
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(20.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .width(350.dp)
                .height(700.dp)
        )

        Text(
            text = heroes[heroIndex].heroName,
            style = TextStyle(color= Color.White, fontSize = 32.sp, fontWeight = Bold),
            modifier = Modifier.padding(horizontal = 40.dp, vertical = 50.dp)
        )
    }
}
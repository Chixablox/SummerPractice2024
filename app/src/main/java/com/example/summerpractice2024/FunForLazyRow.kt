package com.example.summerpractice2024

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun FunForLazyRow (
    heroes: List<MarvelHero>,
    heroIndex: Int,
    navController : NavController,
    width : Int,
    height: Int
){
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = Modifier
            .clickable {
                navController.navigate(route= "HeroScreen/$heroIndex")
            }
            .padding(start = (0.1*width).dp, end = (0.1*width).dp)

    ) {

        val painter = rememberAsyncImagePainter(heroes[heroIndex].imageUrl)

        Image(
            painter = painter,
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(30.dp))
                .width((0.8*width).dp)
                .height((0.7*height).dp)
        )

        Text(
            text = heroes[heroIndex].heroName,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(start = (0.1*(0.8*width)).dp, bottom = (0.05*(0.6875*height)).dp)
        )
    }
}
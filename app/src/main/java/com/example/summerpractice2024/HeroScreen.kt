package com.example.summerpractice2024

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun HeroScreen(
    heroes : List<MarvelHero>,
    heroIndex : Int?,
    navController : NavController,
    width : Int,
    height: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
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

            IconButton(onClick = {
                navController.previousBackStackEntry
                navController.popBackStack()
            },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = (0.02*height).dp, start = (0.02*width).dp)
                    .width((0.1*width).dp)
                    .height((0.05*height).dp)
            ){
                Icon(
                    bitmap = ImageBitmap.imageResource(R.drawable.img),
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .width((0.08*width).dp)
                        .height((0.04*height).dp)
                )
            }
            Column(modifier = Modifier
                .padding(start = (0.02*width).dp, bottom = 50.dp)) {
                Text(
                    text = heroes[heroIndex].heroName,
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = heroes[heroIndex].heroDescription,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
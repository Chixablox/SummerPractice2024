package com.example.summerpractice2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.summerpractice2024.ui.theme.SummerPractice2024Theme

@OptIn(ExperimentalFoundationApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SummerPractice2024Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BackGround()
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(bitmap = ImageBitmap.imageResource(R.drawable.marvellogo),
                            contentDescription = "Логотип",
                            modifier = Modifier
                                .width(200.dp)
                                .height(100.dp))

                        Text(
                            text = "Choose your hero",
                            style = TextStyle(
                                color= Color.White,
                                fontSize = 40.sp,
                                fontWeight = Bold)
                        )

                        val lazyListState = rememberLazyListState()
                        val snapBehavior = rememberSnapFlingBehavior(
                            lazyListState = lazyListState)
                        LazyRow (
                            modifier = Modifier
                                .fillMaxSize(),
                            state = lazyListState,
                            flingBehavior = snapBehavior
                        ) {
                            itemsIndexed(
                                listOf(
                                    MarvelHero("https://i.postimg.cc/JtwjpygL/image.png",
                                        "Deadpool",
                                        "Please don’t make the super suit green...or animated!"),
                                    MarvelHero("https://i.postimg.cc/1zhQmWZc/image.png",
                                        "Iron Man",
                                        "I AM IRON MAN"),
                                    MarvelHero("https://i.postimg.cc/vZDNJ5g7/image.png",
                                        "Spider Man",
                                        "In iron suit")
                                )
                            )
                            {
                                _,hero ->
                                FunForLazyRow(hero = hero)
                            }
                        }
                    }
                }
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

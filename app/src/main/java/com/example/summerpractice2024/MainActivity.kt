package com.example.summerpractice2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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

                    val configuration = LocalConfiguration.current

                    val width = configuration.screenWidthDp
                    val height = configuration.screenHeightDp

                    val heroList = listOf(
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

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainScreen"){
                        composable(route = "MainScreen"){
                            MainScreen(heroList, navController, width, height)
                        }
                        composable(route = "HeroScreen/{index}",
                            arguments = listOf(
                                navArgument(name = "index"){
                                    type = NavType.IntType
                                }
                            )
                        ){ index ->
                           HeroScreen(
                               heroes = heroList,
                               heroIndex = index.arguments?.getInt("index"),
                               navController = navController,
                               width = width,
                               height = height
                           )
                        }
                    }
                }
            }
        }
    }
}


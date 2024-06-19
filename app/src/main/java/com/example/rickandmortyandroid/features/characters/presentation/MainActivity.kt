package com.example.rickandmortyandroid.features.characters.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyandroid.features.characters.presentation.character_deatiled.CharacterDetailScreen
import com.example.rickandmortyandroid.features.characters.presentation.character_list.CharacterListScreen
import com.example.rickandmortyandroid.features.characters.presentation.ui.theme.RickAndMortyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CharacterListScreen.route
                    ) {
                        composable(
                            route = Screen.CharacterListScreen.route
                        ) {
                            CharacterListScreen(navController)
                        }
                        composable(
                            route = Screen.CharacterDetailedScreen.route + "/{charId}"
                        ) {
                            CharacterDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
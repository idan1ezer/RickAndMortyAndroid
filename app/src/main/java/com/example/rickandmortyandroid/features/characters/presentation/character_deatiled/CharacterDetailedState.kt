package com.example.rickandmortyandroid.features.characters.presentation.character_deatiled

import com.example.rickandmortyandroid.features.characters.domain.entities.CharacterEntity

data class CharacterDetailedState(
    val isLoading: Boolean = false,
    val character: CharacterEntity? = null,
    val error: String = ""
)

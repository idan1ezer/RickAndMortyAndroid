package com.example.rickandmortyandroid.features.characters.presentation.character_list

import com.example.rickandmortyandroid.features.characters.domain.entities.CharacterEntity

data class CharacterListState(
    val isLoading: Boolean = false,
    val characters: List<CharacterEntity> = emptyList(),
    val error: String = ""
)

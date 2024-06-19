package com.example.rickandmortyandroid.features.characters.domain.entities

import com.example.rickandmortyandroid.features.characters.data.models.Origin

data class CharacterEntity (
    val created: String,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
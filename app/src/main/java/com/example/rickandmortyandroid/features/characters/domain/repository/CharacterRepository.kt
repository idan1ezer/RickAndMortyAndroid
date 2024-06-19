package com.example.rickandmortyandroid.features.characters.domain.repository

import com.example.rickandmortyandroid.features.characters.data.models.CharacterDto

interface CharacterRepository {
    suspend fun getCharacters(): List<CharacterDto>

    suspend fun getCharacterById(charId: String): CharacterDto
}
package com.example.rickandmortyandroid.features.characters.data.repository

import com.example.rickandmortyandroid.features.characters.data.data_sources.remote.RickAndMortyApi
import com.example.rickandmortyandroid.features.characters.data.models.CharacterDto
import com.example.rickandmortyandroid.features.characters.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
): CharacterRepository {

    override suspend fun getCharacters(): List<CharacterDto> {
        return api.getCharacters()
    }

    override suspend fun getCharacterById(charId: String): CharacterDto {
        return api.getCharacterById(charId)
    }

}
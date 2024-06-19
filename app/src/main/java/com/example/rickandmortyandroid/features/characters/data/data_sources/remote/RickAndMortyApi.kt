package com.example.rickandmortyandroid.features.characters.data.data_sources.remote
import com.example.rickandmortyandroid.features.characters.data.models.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApi {

    @GET("/character")
    suspend fun getCharacters(): List<CharacterDto>

    @GET("/character/{charId}")
    suspend fun getCharacterById(@Path("charId") charId: String): CharacterDto
}
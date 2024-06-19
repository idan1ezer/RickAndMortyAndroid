package com.example.rickandmortyandroid.features.characters.data.models

import com.example.rickandmortyandroid.features.characters.domain.entities.CharacterEntity

data class CharacterDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun CharacterDto.toCharacterEntity(): CharacterEntity {
    return CharacterEntity(
        id = id,
        created = created,
        gender = gender,
        image = image,
        name = name,
        origin = origin,
        species = species,
        status = status,
        type = type,
        url = url
    )
}
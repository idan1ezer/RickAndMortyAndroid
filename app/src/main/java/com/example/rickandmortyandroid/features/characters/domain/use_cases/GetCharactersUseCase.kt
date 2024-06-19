package com.example.rickandmortyandroid.features.characters.domain.use_cases

import com.example.rickandmortyandroid.common.Resource
import com.example.rickandmortyandroid.features.characters.data.models.toCharacterEntity
import com.example.rickandmortyandroid.features.characters.domain.entities.CharacterEntity
import com.example.rickandmortyandroid.features.characters.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(): Flow<Resource<List<CharacterEntity>>> = flow {
        try {
            emit(Resource.Loading<List<CharacterEntity>>())
            val characters = repository.getCharacters().map { it.toCharacterEntity() }
            emit(Resource.Success<List<CharacterEntity>>(characters))
        } catch (e: HttpException) {
            emit(Resource.Error<List<CharacterEntity>>(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error<List<CharacterEntity>>("Couldn't reach server. Check your internet connection."))
        }
    }
}
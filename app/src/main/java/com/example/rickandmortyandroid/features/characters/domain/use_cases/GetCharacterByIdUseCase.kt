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

class GetCharacterByIdUseCase @Inject constructor(
    private val repository: CharacterRepository
){
    operator fun invoke(charId: String): Flow<Resource<CharacterEntity>> = flow {
        try {
            emit(Resource.Loading<CharacterEntity>())
            val character = repository.getCharacterById(charId).toCharacterEntity()
            emit(Resource.Success<CharacterEntity>(character))
        } catch (e: HttpException) {
            emit(Resource.Error<CharacterEntity>(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error<CharacterEntity>("Couldn't reach server. Check your internet connection."))
        }
    }
}
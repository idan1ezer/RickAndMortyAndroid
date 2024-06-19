package com.example.rickandmortyandroid.features.characters.presentation.character_deatiled

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.rickandmortyandroid.common.Constants
import com.example.rickandmortyandroid.common.Resource
import com.example.rickandmortyandroid.features.characters.domain.use_cases.GetCharacterByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CharacterDetailedState())
    val state: State<CharacterDetailedState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_CHAR_ID)?.let { charId ->
            getCharacter(charId)
        }
    }

    private fun getCharacter(charId: String) {
        getCharacterByIdUseCase(charId).onEach {result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CharacterDetailedState(character = result.data)
                }
                is Resource.Error -> {
                    _state.value = CharacterDetailedState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CharacterDetailedState(isLoading = true)
                }
            }
        }
    }
}
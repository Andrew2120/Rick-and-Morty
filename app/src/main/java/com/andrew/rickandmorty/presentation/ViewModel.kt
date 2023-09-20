package com.andrew.rickandmorty.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrew.rickandmorty.domain.models.Character
import com.andrew.rickandmorty.domain.use_cases.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
) : ViewModel() {



    private val _state = MutableStateFlow(CountriesState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                )
            }
            _state.update {
                it.copy(
                    countries = getCharactersUseCase(),
                    isLoading = false,
                )
            }
        }
    }

    data class CountriesState(
        val countries: List<Character> = emptyList(),
        val isLoading: Boolean = false,
    )
}

package kr.pe.ssun.myapplication.ui.home

import kr.pe.ssun.myapplication.model.Pokemon

sealed interface HomeUiState {
    object Loading : HomeUiState
    data class Success(
        val pokemons: List<Pokemon>
    ) : HomeUiState
    object Error : HomeUiState
}
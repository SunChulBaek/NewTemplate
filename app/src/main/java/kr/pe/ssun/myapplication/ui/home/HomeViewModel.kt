package kr.pe.ssun.myapplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kr.pe.ssun.myapplication.data.MyRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MyRepository
) : ViewModel() {

    private var _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        repository.getPokemonList(offset = 0)
            .map { pokemons ->
                HomeUiState.Success(pokemons)
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = HomeUiState.Loading
            ).collect { newState ->
                _uiState.value = newState
            }
    }
}
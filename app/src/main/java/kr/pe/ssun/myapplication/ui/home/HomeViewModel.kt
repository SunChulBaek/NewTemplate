package kr.pe.ssun.myapplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.pe.ssun.myapplication.data.MyRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MyRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            repository.getPokemonList(offset = 0).collect { pokemons ->
                pokemons.forEach { p ->
                    println("[x1210x] id = ${p.id}, name = ${p.name}")
                }
            }
        }
    }
}
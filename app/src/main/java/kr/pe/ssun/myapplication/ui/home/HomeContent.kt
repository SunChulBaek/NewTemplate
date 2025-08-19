package kr.pe.ssun.myapplication.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.pe.ssun.myapplication.model.Pokemon

@Composable
fun HomeContent(
    uiState: HomeUiState.Success,
    onClick: (Pokemon) -> Unit
) {
    val pokemons = uiState.pokemons

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(
                    count = pokemons.size,
                    key = { index -> pokemons[index].id }
                ) { index ->
                    HomeListItem(
                        pokemon = pokemons[index],
                        onClick = { pokemon -> onClick(pokemon) }
                    )
                }
            }
        }
    }
}
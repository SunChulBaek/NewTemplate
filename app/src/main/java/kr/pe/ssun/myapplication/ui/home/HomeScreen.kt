package kr.pe.ssun.myapplication.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kr.pe.ssun.myapplication.navigation.detailNavigationRoute

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigate: (String, Any?) -> Unit,
) {
    val uiState = viewModel.uiState.collectAsState()
    val pokemons = (uiState.value as? HomeUiState.Success)?.pokemons

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(
                    count = pokemons?.size ?: 0,
                    key = { index -> pokemons?.get(index)?.id ?: 0}
                ) {
                    HomeListItem(
                        pokemon = pokemons?.get(it)!!,
                        onClick = {
                            navigate(detailNavigationRoute, pokemons[it].id)
                        }
                    )
                }
            }
        }
    }
}
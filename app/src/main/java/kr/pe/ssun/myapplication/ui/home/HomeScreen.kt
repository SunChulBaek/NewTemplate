package kr.pe.ssun.myapplication.ui.home

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kr.pe.ssun.myapplication.navigation.detailNavigationRoute
import kr.pe.ssun.myapplication.ui.common.ErrorScreen
import kr.pe.ssun.myapplication.ui.common.LoadingScreen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun HomeScreen(
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    viewModel: HomeViewModel = hiltViewModel(),
    navigate: (String, Any?) -> Unit,
) {
    val uiState = viewModel.uiState.collectAsState().value

    when (uiState) {
        HomeUiState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
        is HomeUiState.Success -> HomeContent(
            sharedTransitionScope,
            animatedContentScope,
            uiState
        ) { pokemon ->
            navigate(detailNavigationRoute, pokemon.id)
        }
        HomeUiState.Error -> ErrorScreen(modifier = Modifier.fillMaxSize())
    }
}
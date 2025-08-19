package kr.pe.ssun.myapplication.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kr.pe.ssun.myapplication.ui.detail.DetailScreen

const val detailNavigationRoute = "detail"

const val detailIdArg = "id"

internal class DetailArgs(val id: Int) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        id = checkNotNull(savedStateHandle[detailIdArg]).toString().toInt()
    )
}

fun NavController.navigateToDetail(id: Int) {
    this.navigate("$detailNavigationRoute/$id")
}

fun NavGraphBuilder.detailScreen(
    enterTransition: EnterTransition = EnterTransition.None,
    exitTransition: ExitTransition = ExitTransition.None,
    popEnterTransition: EnterTransition = EnterTransition.None,
    popExitTransition: ExitTransition = ExitTransition.None,
    navigate: (String, Any?) -> Unit,
) {
    composable(
        route = "$detailNavigationRoute/{$detailIdArg}",
        enterTransition = { enterTransition },
        exitTransition = { exitTransition },
        popEnterTransition = { popEnterTransition },
        popExitTransition = { popExitTransition }
    ) {
        DetailScreen(navigate = navigate)
    }
}
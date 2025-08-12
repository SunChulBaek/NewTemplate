package kr.pe.ssun.myapplication.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kr.pe.ssun.myapplication.ui.detail.DetailScreen

const val detailNavigationRoute = "detail"

fun NavController.navigateToDetail() {
    this.navigate(detailNavigationRoute)
}

fun NavGraphBuilder.detailScreen(
    enterTransition: EnterTransition = EnterTransition.None,
    exitTransition: ExitTransition = ExitTransition.None,
    popEnterTransition: EnterTransition = EnterTransition.None,
    popExitTransition: ExitTransition = ExitTransition.None,
    navigate: (String, Any?) -> Unit,
) {
    composable(
        route = detailNavigationRoute,
        enterTransition = { enterTransition },
        exitTransition = { exitTransition },
        popEnterTransition = { popEnterTransition },
        popExitTransition = { popExitTransition }
    ) {
        DetailScreen(navigate = navigate)
    }
}
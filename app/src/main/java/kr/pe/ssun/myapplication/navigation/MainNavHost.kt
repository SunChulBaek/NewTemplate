package kr.pe.ssun.myapplication.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun MainNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = homeNavigationRoute,
) {
    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            // 홈
            homeScreen(
                sharedTransitionScope = this@SharedTransitionLayout,
                enterTransition = defaultEnterTransition(),
                exitTransition = defaultExitTransition(),
                popEnterTransition = defaultPopEnterTransition(),
                popExitTransition = defaultPopExitTransition(),
                navigate = { route, params -> navigate(navController, route, params) },
            )
            // 상세
            detailScreen(
                sharedTransitionScope = this@SharedTransitionLayout,
                enterTransition = defaultEnterTransition(),
                exitTransition = defaultExitTransition(),
                popEnterTransition = defaultPopEnterTransition(),
                popExitTransition = defaultPopExitTransition(),
                navigate = { route, params -> navigate(navController, route, params) },
            )
        }
    }
}

fun defaultEnterTransition(): EnterTransition = slideInHorizontally(
    initialOffsetX = { fullWidth -> fullWidth },
    animationSpec = tween(
        durationMillis = 300,
        easing = FastOutSlowInEasing
    )
)

fun defaultExitTransition(): ExitTransition = slideOutHorizontally(
    targetOffsetX = { fullWidth -> -fullWidth },
    animationSpec = tween(
        durationMillis = 300,
        easing = FastOutSlowInEasing
    )
)

fun defaultPopEnterTransition(): EnterTransition = slideInHorizontally(
    initialOffsetX = { fullWidth -> -fullWidth },
    animationSpec = tween(
        durationMillis = 300,
        easing = FastOutSlowInEasing
    )
)

fun defaultPopExitTransition(): ExitTransition = slideOutHorizontally(
    targetOffsetX = { fullWidth -> fullWidth },
    animationSpec = tween(
        durationMillis = 300,
        easing = FastOutSlowInEasing
    )
)

fun navigate(
    navController: NavHostController,
    dest: String,
    params: Any? = null,
) {
    when (dest) {
        detailNavigationRoute -> navController.navigateToDetail(params as Int)
        else -> TODO()
    }
}
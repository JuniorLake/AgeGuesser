package com.example.ageguesser.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.navArgument
import com.example.ageguesser.view.DetailScreen
import com.example.ageguesser.view.MainScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.animation.composable


@ExperimentalAnimationApi
@Composable
fun Navigation(){
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(
            route = Screen.MainScreen.route,
            enterTransition = {_,_ ->
                slideInHorizontally(
                    initialOffsetX = {-1000},
                    animationSpec = tween(1000, easing = FastOutSlowInEasing),
                )
            },
            exitTransition = {_,_ ->
                slideOutHorizontally(
                    targetOffsetX = {-1000},
                    animationSpec = tween(1000, easing = FastOutSlowInEasing),
                )
            },
            popEnterTransition = {_,_ -> EnterTransition.None},
            popExitTransition =  {_,_ -> ExitTransition.None}
        ){
            MainScreen(navController = navController)
        }

        composable(
            route = Screen.DetailScreen.route + "?name={name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    nullable = true
                }
            ),
            enterTransition = {_,_ ->
                slideInHorizontally(
                    initialOffsetX = {1000},
                    animationSpec = tween(1000, easing = FastOutSlowInEasing),
                )
            },
            exitTransition = {_,_ ->
                slideOutHorizontally(
                    targetOffsetX = {1000},
                    animationSpec = tween(1000, easing = FastOutSlowInEasing),
                )
            },
            popEnterTransition = {_,_ -> EnterTransition.None},
            popExitTransition =  {_,_ -> ExitTransition.None}
        ){ entry ->
            DetailScreen(
                navController = navController,
                name = entry.arguments?.getString("name")
            )
        }
    }
}
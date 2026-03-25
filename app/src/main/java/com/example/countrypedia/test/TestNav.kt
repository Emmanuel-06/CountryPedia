package com.example.countrypedia.test

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgumentBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun TestNav() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "ScreenA"
    ){
        composable(Route.ScreenA.route){
            ScreenA(
                onNavigate = { name, dob ->
                    navController.navigate(
                        Route.ScreenB.createRoute(name, dob)
                    )
                }
            )
        }


        composable(
            route = Route.ScreenB.route,
            arguments = listOf(
                navArgument(name = "name"){
                    type = NavType.StringType
                },
                navArgument(name = "dob"){
                    type = NavType.StringType
                }
            )
        ){navBackStackEntry ->
            ScreenB(
                name = navBackStackEntry.arguments?.getString("name"),
                dob = navBackStackEntry.arguments?.getString("dob")
            )
        }
    }
}


sealed class Route(val route: String){
    data object ScreenA: Route("ScreenA")
    data object ScreenB: Route("ScreenB/{name}/{dob}"){
        fun createRoute(name: String, dob: String) = "ScreenB/$name/$dob"
    }
}
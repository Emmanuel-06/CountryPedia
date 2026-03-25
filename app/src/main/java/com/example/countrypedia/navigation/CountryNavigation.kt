package com.example.countrypedia.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.countrypedia.ui.screen.DetailsScreen
import com.example.countrypedia.ui.screen.Home
import com.example.countrypedia.utils.Screens

@Composable
fun CountryNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.HOME_SCREEN.name
    ) {

        composable(
            route = Screens.HOME_SCREEN.name
        ){
            Home(
                navigateDetails = {name ->
                    navController.navigate(Screens.DETAILS_SCREEN.name + "/$name")
                }
            )
        }

        composable(
            route = Screens.DETAILS_SCREEN.name + "/{countryId}",
            arguments = listOf(
                navArgument("countryId"){
                    type = NavType.StringType
                }
            )
        ) { navbackStackEntry ->
            navbackStackEntry.arguments?.getString("countryId")?.let {
                DetailsScreen(
                    popBackStack = {
                        navController.popBackStack()
                    },
                    countryId = it
                )
            }
        }

    }
}
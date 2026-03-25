package com.example.countrypedia.light.lightnav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.countrypedia.light.CheckOutScreen
import com.example.countrypedia.light.DetailsScreen
import com.example.countrypedia.light.EditContentScreen
import com.example.countrypedia.light.ForgotPassword
import com.example.countrypedia.light.HomeScreen
import com.example.countrypedia.light.LoginScreen
import com.example.countrypedia.light.PaymentScreen
import com.example.countrypedia.light.SearchScreen
import com.example.countrypedia.light.SignUpScreen

@Composable
fun LightNav() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.Login.route
    ) {
        composable(Route.Login.route){
            LoginScreen(
                navigateSignup = Route.SignUp.route,
                navigateForgotPassword = Route.ForgotPassword.route,
                navigateHome = Route.Home.route
            ) { route ->
                when(route) {
                    Route.SignUp.route -> navController.navigate(Route.SignUp.route)
                    Route.ForgotPassword.route -> navController.navigate(Route.ForgotPassword.route)
                    Route.Home.route -> navController.navigate(Route.Home.route)
                }

            }
        }


        composable(Route.SignUp.route){
            SignUpScreen(
                navigateLogin = Route.Login.route,
                navigateHome = Route.Home.route
            ) {route ->
                when(route) {
                    Route.Login.route -> navController.navigate(Route.Login.route)
                    Route.Home.route -> navController.navigate(Route.Home.route)
                }


            }
        }

        composable(Route.ForgotPassword.route){
            ForgotPassword(
                navigateHome = Route.Home.route
            ) {route ->
                when(route) {
                    Route.Home.route -> navController.navigate(Route.Home.route)
                }
            }
        }

        composable(Route.Home.route){
            HomeScreen(
                navigateHome = Route.Home.route,
                navigateCheckout = Route.Checkout.route,
                navigateDetails = Route.Details.route,
                navigateLogout = Route.Login.route
            ) { route ->
                when (route) {
                    Route.Home.route -> navController.navigate(Route.Home.route)
                    Route.Checkout.route -> navController.navigate(Route.Checkout.route)
                    Route.Details.route -> navController.navigate(Route.Details.route)
                    Route.Login.route -> navController.navigate(Route.Login.route)
                }

            }
        }

        composable(Route.EditContent.route){
            EditContentScreen(
                navigatePayment = Route.Payment.route
            ) {route ->
                when(route) {
                    Route.Payment.route -> navController.navigate(Route.Payment.route)
                }

            }
        }

        composable(Route.Details.route){
            DetailsScreen(
                navigateHome = Route.Home.route,
                navigateEditContent = Route.EditContent.route
            ) { route ->
                when(route) {
                    Route.EditContent.route -> navController.navigate(Route.EditContent.route)
                    Route.Home.route -> navController.navigate(Route.Home.route)
                }
            }
        }

        composable(Route.Checkout.route){
            CheckOutScreen(
                navigateHome = Route.Home.route,
                navigateEditContent = Route.EditContent.route,
                navigatePayment = Route.Payment.route
            ) { route ->
                when(route) {
                    Route.EditContent.route -> navController.navigate(Route.EditContent.route)
                    Route.Payment.route -> navController.navigate(Route.Payment.route)
                    Route.Home.route -> navController.navigate(Route.Home.route)
                }

            }
        }

        composable(Route.Payment.route){
            PaymentScreen(
                navigateHome = Route.Home.route
            ) {route ->
                when(route) {
                    Route.Home.route -> navController.navigate(Route.Home.route)
                }

            }
        }

        composable(Route.Search.route){
            SearchScreen(
                navigateHome = Route.Home.route
            ) {route ->
                when(route) {
                    Route.Home.route -> navController.navigate(Route.Home.route)
                }

            }
        }
    }
}
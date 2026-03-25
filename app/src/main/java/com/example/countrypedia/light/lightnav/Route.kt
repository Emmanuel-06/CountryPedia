package com.example.countrypedia.light.lightnav

sealed class Route(val route: String) {

    data object Login: Route("Login")

    data object SignUp: Route("SignUp")

    data object ForgotPassword: Route("ForgotPassword")

    data object Home: Route("Home")

    data object Checkout: Route("Checkout")

    data object Payment: Route("Payment")

    data object Search: Route("Search")

    data object EditContent: Route("EditContent")

    data object Details: Route("Details")

    data object Auth: Route("Auth")

    data object Main: Route("Main")



}
package com.example.countrypedia.light

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun HomeScreen(
    navigateHome: String,
    navigateCheckout: String,
    navigateDetails: String,
    navigateLogout: String,
    onNavigate: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {


        Text(text = "Welcome, home!")
        Button(
            onClick = {onNavigate(navigateHome)}
        ) {
            Text(text = "Search")
        }

        Button(
            onClick = {onNavigate(navigateCheckout)}
        ) {
            Text(text = "CheckOut")
        }

        Button(
            onClick = {onNavigate(navigateDetails)}
        ) {
            Text(text = "Details")
        }

        Button(
            onClick = {onNavigate(navigateLogout)}
        ) {
            Text(text = "Logout")
        }

    }
}


@Composable
fun CheckOutScreen(
    navigateHome: String,
    navigateEditContent: String,
    navigatePayment: String,
    onNavigate: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {


        Text(text = "Checkout")
        Button(
            onClick = {onNavigate(navigateHome)}
        ) {
            Text(text = "Home")
        }

        Button(
            onClick = {onNavigate(navigatePayment)}
        ) {
            Text(text = "Payment")
        }

        Button(
            onClick = {onNavigate(navigateEditContent)}
        ) {
            Text(text = "Edit Content")
        }

    }
}

@Composable
fun SearchScreen(
    navigateHome: String,
    onNavigate: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {


        Text(text = "Checkout")
        Button(
            onClick = {onNavigate(navigateHome)}
        ) {
            Text(text = "Home")
        }
    }
}

@Composable
fun EditContentScreen(
    navigatePayment: String,
    onNavigate: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {


        Text(text = "Payment")
        Button(
            onClick = {onNavigate(navigatePayment)}
        ) {
            Text(text = "Home")
        }
    }
}

@Composable
fun PaymentScreen(
    navigateHome: String,
    onNavigate: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Text(text = "PaymentScreen")
        Button(
            onClick = {onNavigate(navigateHome)}
        ) {
            Text(text = "Home")
        }
    }
}

@Composable
fun DetailsScreen(
    navigateHome: String,
    navigateEditContent: String,
    onNavigate: (String) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {


        Text(text = "DetailsScreen")
        Button(
            onClick = {onNavigate(navigateHome)}
        ) {
            Text(text = "Home")
        }
        Button(
            onClick = {onNavigate(navigateEditContent)}
        ) {
            Text(text = "Edit Content")
        }
    }
}
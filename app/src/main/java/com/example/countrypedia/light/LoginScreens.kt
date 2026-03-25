package com.example.countrypedia.light

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.countrypedia.light.lightnav.Route

@Composable
fun LoginScreen(
    navigateSignup: String,
    navigateForgotPassword: String,
    navigateHome: String,
    onNavigate: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {


        Text(text = "Login")
        Button(
            onClick = {onNavigate(navigateSignup)}
        ) {
            Text(text = "Sign up")
        }
        Button(
            onClick = {onNavigate(navigateForgotPassword)}
        ) {
            Text(text = "Forgot Password")
        }
        Button(
            onClick = {onNavigate(navigateHome)}
        ) {
            Text(text = "Home")
        }
    }
}

@Composable
fun ForgotPassword(
    navigateHome: String,
    onNavigate: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {


        Text(text = "Forgot Password")
        Button(
            onClick = {onNavigate(navigateHome)}
        ) {
            Text(text = "Home")
        }
    }
}

@Composable
fun SignUpScreen(
    navigateLogin: String,
    navigateHome: String,
    onNavigate: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {


        Text(text = "Sign up")
        Button(
            onClick = {onNavigate(navigateLogin)}
        ) {
            Text(text = "Login")
        }

        Button(
            onClick = {onNavigate(navigateHome)}
        ) {
            Text(text = "Home")
        }
    }
}

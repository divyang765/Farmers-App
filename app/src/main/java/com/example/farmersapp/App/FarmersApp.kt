package com.example.farmersapp.App

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.farmersapp.SignUpLogin.Screens.HomeScreen
import com.example.farmersapp.SignUpLogin.Screens.LoginScreen

import com.example.farmersapp.SignUpLogin.Screens.SignUpScreen

@Composable

fun FarmersApp() {

    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Crossfade(targetState = FarmersAppRouter.currentScreen, label = "") { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }

                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.HomeScreen -> {
                    HomeScreen()
                }

            }

        }
    }
}

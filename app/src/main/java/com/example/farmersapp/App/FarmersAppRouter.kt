package com.example.farmersapp.App

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {
    object SignUpScreen : Screen()
    object LoginScreen : Screen()
    object HomeScreen : Screen()
    object MainScreen : Screen()
}

object FarmersAppRouter {
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.MainScreen)
    fun navigateTo(destination: Screen) {
        currentScreen.value = destination
    }
}
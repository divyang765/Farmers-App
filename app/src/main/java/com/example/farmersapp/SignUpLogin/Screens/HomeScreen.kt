package com.example.farmersapp.SignUpLogin.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.farmersapp.App.Screen
import com.example.farmersapp.SignUpLogin.ButtonComponent
import com.example.farmersapp.SignUpLogin.HeadingTextComponent
import com.example.farmersapp.SignUpLogin.ViewModels.SignInViewModel

@Composable
fun HomeScreen(signInViewModel: SignInViewModel = SignInViewModel()) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeadingTextComponent(value = "Home")
            ButtonComponent(
                value = "Logout",
                onClicked = { signInViewModel.logOut() },

                )

        }
    }
}
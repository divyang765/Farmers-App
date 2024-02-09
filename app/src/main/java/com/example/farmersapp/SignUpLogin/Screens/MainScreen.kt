package com.example.farmersapp.SignUpLogin.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmersapp.App.FarmersAppRouter
import com.example.farmersapp.App.Screen
import com.example.farmersapp.SignUpLogin.ButtonComponent
import com.example.farmersapp.SignUpLogin.MainScreenTopCard
import com.example.farmersapp.SignUpLogin.TopCard
import com.example.farmersapp.SignUpLogin.TransparentButtonComponent

@Composable
fun MainScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()


    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color(7, 63, 44, 255)
                )
        ) {
            MainScreenTopCard(value = "Welcome to")
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = "One stop solution ",
                style = TextStyle(
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Black,
                    fontStyle = FontStyle.Italic
                )
            )
            Text(
                text = "for all farmers ",
                style = TextStyle(
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Black,
                    fontStyle = FontStyle.Italic
                )
            )
            Spacer(modifier = Modifier.height(30.dp))
            ButtonComponent(value = "Sign In") {
                FarmersAppRouter.navigateTo(Screen.LoginScreen)
            }


            Spacer(modifier = Modifier.height(15.dp))
            TransparentButtonComponent(value = "Sign Up") {
                FarmersAppRouter.navigateTo(Screen.SignUpScreen)
            }
        }
    }

}

@Preview
@Composable

fun DefaultMainScreen() {
    MainScreen()
}
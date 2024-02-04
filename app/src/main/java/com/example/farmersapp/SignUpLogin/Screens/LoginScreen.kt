package com.example.farmersapp.SignUpLogin.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmersapp.App.FarmersAppRouter
import com.example.farmersapp.App.Screen
import com.example.farmersapp.App.SystemBackButtonHandler
import com.example.farmersapp.R
import com.example.farmersapp.SignUpLogin.ButtonComponent
import com.example.farmersapp.SignUpLogin.CircularIndeterminateProgressBar
import com.example.farmersapp.SignUpLogin.ClickableTextComponent
import com.example.farmersapp.SignUpLogin.DividerTextComponent
import com.example.farmersapp.SignUpLogin.HeadingTextComponent
import com.example.farmersapp.SignUpLogin.LoginUiEvents
import com.example.farmersapp.SignUpLogin.MyTextField
import com.example.farmersapp.SignUpLogin.PasswordTextField
import com.example.farmersapp.SignUpLogin.UnderLinedTextComponent
import com.example.farmersapp.SignUpLogin.ViewModels.LoginViewModel

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = LoginViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize()

            .paint(
                painterResource(id = R.drawable.loginscreen),
                contentScale = ContentScale.FillBounds
            )
            .padding(20.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HeadingTextComponent(value = "LOGIN")
            HeadingTextComponent(value = "Welcome Back")
            Spacer(modifier = Modifier.height(25.dp))
            MyTextField(
                labelValue = " Email",
                imageVector = Icons.Default.Email,
                onTextSelected = {
                    loginViewModel.onEvent(
                        LoginUiEvents.emailChanged(it)
                    )
                })
            Spacer(modifier = Modifier.height(10.dp))
            PasswordTextField(labelValue = "Password", onTextSelected = {
                loginViewModel.onEvent(
                    LoginUiEvents.passwordChanged(it)
                )
            })
            Spacer(modifier = Modifier.height(20.dp))
            UnderLinedTextComponent(value = "Forgot Password")
            Spacer(modifier = Modifier.height(20.dp))
            ButtonComponent(
                value = "Login",
                onClicked = { loginViewModel.onEvent(LoginUiEvents.registerButtonClicked) })
            Spacer(modifier = Modifier.height(10.dp))
            DividerTextComponent()
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Don't Have An Account?",
                style = TextStyle(
                    fontSize = 15.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Black
                )
            )
            ClickableTextComponent(
                value = buildAnnotatedString { append("Sign In ") },
                onTextSelected = { FarmersAppRouter.navigateTo(Screen.SignUpScreen) }
            )
        }
        if (loginViewModel.LoginInProgress.value) {
            CircularIndeterminateProgressBar()
        }
    }
    SystemBackButtonHandler {
        FarmersAppRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Preview
@Composable

fun DefaultLoginScreen() {
    LoginScreen()
}

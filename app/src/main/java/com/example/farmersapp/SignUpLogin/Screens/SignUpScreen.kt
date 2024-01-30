package com.example.farmersapp.SignUpLogin.Screens

import android.support.v4.os.IResultReceiver2.Default
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.example.farmersapp.R
import com.example.farmersapp.SignUpLogin.ButtonComponent
import com.example.farmersapp.SignUpLogin.ClickableTextComponent
import com.example.farmersapp.SignUpLogin.HeadingTextComponent
import com.example.farmersapp.SignUpLogin.MyTextField
import com.example.farmersapp.SignUpLogin.PasswordTextField
import com.example.farmersapp.SignUpLogin.SignUpUiEvents
import com.example.farmersapp.SignUpLogin.ViewModels.SignInViewModel

@Composable
fun SignUpScreen(signInViewModel: SignInViewModel = SignInViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize()

            .paint(
                painterResource(id = R.drawable.signupscreen),
                contentScale = ContentScale.FillBounds
            )
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeadingTextComponent(value = "Greetings")

            Spacer(modifier = Modifier.height(20.dp))

            HeadingTextComponent(value = "Join Today ")
            Spacer(modifier = Modifier.height(10.dp))
            MyTextField(labelValue = " First Name", onTextSelected = {
                signInViewModel.onEvent(
                    SignUpUiEvents.firstNameChanged(it)
                )

            })
            MyTextField(labelValue = " Last Name", onTextSelected = {
                signInViewModel.onEvent(
                    SignUpUiEvents.lastNameChanged(it)
                )
            })
            MyTextField(
                labelValue = " Email",
                imageVector = Icons.Default.Email,
                onTextSelected = {
                    signInViewModel.onEvent(
                        SignUpUiEvents.emailChanged(it)
                    )
                })
            PasswordTextField(labelValue = "Password", onTextSelected = {
                signInViewModel.onEvent(
                    SignUpUiEvents.passwordChanged(it)
                )
            })
            Spacer(modifier = Modifier.height(30.dp))
            ButtonComponent(value = "Sign Up")
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Already Have An Account?",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Black
                )
            )
            ClickableTextComponent(buildAnnotatedString { append("Login") }, onTextSelected = {
                FarmersAppRouter.navigateTo(Screen.LoginScreen)
            })
        }
    }
}


@Preview
@Composable

fun DefaultSignupScreen() {
    SignUpScreen()
}

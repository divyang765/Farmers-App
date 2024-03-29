package com.example.farmersapp.SignUpLogin.Screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.example.farmersapp.App.SystemBackButtonHandler
import com.example.farmersapp.R

import com.example.farmersapp.SignUpLogin.ButtonComponent
import com.example.farmersapp.SignUpLogin.CircularIndeterminateProgressBar
import com.example.farmersapp.SignUpLogin.ClickableTextComponent
import com.example.farmersapp.SignUpLogin.HeadingTextBlock
import com.example.farmersapp.SignUpLogin.HeadingTextComponent
import com.example.farmersapp.SignUpLogin.MyTextField
import com.example.farmersapp.SignUpLogin.PasswordTextField
import com.example.farmersapp.SignUpLogin.SignUpUiEvents
import com.example.farmersapp.SignUpLogin.SnackbarWithoutScaffold
import com.example.farmersapp.SignUpLogin.TopCard

import com.example.farmersapp.SignUpLogin.ViewModels.SignInViewModel

@Composable


fun SignUpScreen(signInViewModel: SignInViewModel = SignInViewModel()) {


    Box(
        modifier = Modifier
            .fillMaxSize(), contentAlignment = Alignment.Center


    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()


        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
//                    .paint(
//                        painterResource(id = R.drawable.signupscreen),
//                        contentScale = ContentScale.FillBounds
//                    )

                    .background(Color(7, 63, 44, 255))
//                    .padding(10.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TopCard(value = "Sign Up Now")

                Spacer(modifier = Modifier.height(20.dp))


                Spacer(modifier = Modifier.height(15.dp))
                MyTextField(labelValue = " First Name", onTextSelected = {
                    signInViewModel.onEvent(
                        SignUpUiEvents.firstNameChanged(it)
                    )

                })
                Spacer(modifier = Modifier.height(15.dp))
                MyTextField(labelValue = " Last Name", onTextSelected = {
                    signInViewModel.onEvent(
                        SignUpUiEvents.lastNameChanged(it)
                    )
                })
                Spacer(modifier = Modifier.height(15.dp))
                MyTextField(
                    labelValue = " Email",
                    imageVector = Icons.Default.Email,
                    onTextSelected = {
                        signInViewModel.onEvent(
                            SignUpUiEvents.emailChanged(it)
                        )
                    })
                Spacer(modifier = Modifier.height(15.dp))
                PasswordTextField(labelValue = "Password", onTextSelected = {
                    signInViewModel.onEvent(
                        SignUpUiEvents.passwordChanged(it)
                    )
                })
                Spacer(modifier = Modifier.height(15.dp))



                ButtonComponent(
                    value = "Sign Up",
                    onClicked = {
                        signInViewModel.onEvent(SignUpUiEvents.registerButtonClicked)

                    }
                )



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
                if (!signInViewModel.allValidataionsPassed.value)
                    SnackbarWithoutScaffold(
                        message = "Invalid Details",
                        showSb = true,
                        openSnackbar = {})


            }
        }

        if (signInViewModel.signUpInProgress.value) {
            CircularProgressIndicator()

        }

    }
    SystemBackButtonHandler {
        FarmersAppRouter.navigateTo(Screen.MainScreen)
    }
}


@Preview
@Composable

fun DefaultSignupScreen() {
    SignUpScreen()
}

package com.example.farmersapp.SignUpLogin.ViewModels

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.lifecycle.ViewModel
import com.example.farmersapp.App.FarmersAppRouter
import com.example.farmersapp.App.Screen
import com.example.farmersapp.SignUpLogin.LoginUIState
import com.example.farmersapp.SignUpLogin.LoginUiEvents
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    var loginUIState = mutableStateOf(LoginUIState())
    val LoginInProgress = mutableStateOf(false)
    var allValidataionsPassed = mutableStateOf(true)

    fun onEvent(event: LoginUiEvents) {
        when (event) {
            is LoginUiEvents.emailChanged -> {
                loginUIState.value = loginUIState.value.copy(email = event.email)
                onPrintState()
            }

            is LoginUiEvents.passwordChanged -> {
                loginUIState.value = loginUIState.value.copy(password = event.password)
                onPrintState()
            }

            is LoginUiEvents.registerButtonClicked -> {

                if (loginUIState.value.email.isNotEmpty() && loginUIState.value.password.isNotEmpty()) {
                    login()

                } else {
                    allValidataionsPassed.value = false
                }

            }
        }

    }

    private fun onPrintState() {
        Log.d("TAG", "inside_PrintStata")
        Log.d("TAG", loginUIState.value.toString())

    }

    private fun login() {
        LoginInProgress.value = true
        val email = loginUIState.value.email
        val password = loginUIState.value.password
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d("Taga", "Inside Login Successful")
                Log.d("Taga", "${it.isSuccessful}")

                if (it.isSuccessful) {
                    LoginInProgress.value = false
                    FarmersAppRouter.navigateTo(com.example.farmersapp.App.Screen.HomeScreen)
                }
            }
            .addOnFailureListener {
                allValidataionsPassed.value=false
                LoginInProgress.value = false
                Log.d("Taga", "Inside Login Failure")
                Log.d("Taga", "${it.localizedMessage}")

            }
    }
}
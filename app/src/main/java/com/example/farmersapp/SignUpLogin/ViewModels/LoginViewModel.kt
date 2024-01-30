package com.example.farmersapp.SignUpLogin.ViewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.farmersapp.SignUpLogin.LoginUIState
import com.example.farmersapp.SignUpLogin.LoginUiEvents

class LoginViewModel : ViewModel() {
    var loginUIState = mutableStateOf(LoginUIState())

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
        }
    }

    private fun onPrintState() {
        Log.d("TAG", "inside_PrintStata")
        Log.d("TAG", loginUIState.value.toString())

    }
}
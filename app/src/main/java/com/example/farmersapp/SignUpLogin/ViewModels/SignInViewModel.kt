package com.example.farmersapp.SignUpLogin.ViewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.farmersapp.SignUpLogin.RegistrationUiState
import com.example.farmersapp.SignUpLogin.SignUpUiEvents

class SignInViewModel : ViewModel() {
    var registrationUiState = mutableStateOf(RegistrationUiState())
    var allValidataionsPassed = mutableStateOf(false)

    fun onEvent(event: SignUpUiEvents) {

        when (event) {
            is SignUpUiEvents.firstNameChanged -> {
                registrationUiState.value =
                    registrationUiState.value.copy(firstName = event.firstName)
                onPrintState()
            }

            is SignUpUiEvents.lastNameChanged -> {
                registrationUiState.value =
                    registrationUiState.value.copy(lastName = event.lastName)
                onPrintState()
            }

            is SignUpUiEvents.emailChanged -> {
                registrationUiState.value =
                    registrationUiState.value.copy(email = event.email)
                onPrintState()
            }

            is SignUpUiEvents.passwordChanged -> {

                registrationUiState.value =
                    registrationUiState.value.copy(password = event.password)
                onPrintState()
            }
        }
    }

    private fun onPrintState() {
        Log.d("TAG", "inside_PrintStata")
        Log.d("TAG", registrationUiState.value.toString())

    }


}
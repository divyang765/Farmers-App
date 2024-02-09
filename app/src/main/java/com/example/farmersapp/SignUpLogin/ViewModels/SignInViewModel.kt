package com.example.farmersapp.SignUpLogin.ViewModels

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.farmersapp.App.FarmersAppRouter
import com.example.farmersapp.App.Screen
import com.example.farmersapp.SignUpLogin.RegistrationUiState
import com.example.farmersapp.SignUpLogin.SignUpUiEvents
import com.example.farmersapp.SignUpLogin.SnackbarWithoutScaffold
import com.google.firebase.auth.FirebaseAuth

class SignInViewModel : ViewModel() {
    var registrationUiState = mutableStateOf(RegistrationUiState())
    var allValidataionsPassed = mutableStateOf(true)
    val signUpInProgress = mutableStateOf(false)


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

            is SignUpUiEvents.registerButtonClicked -> {
                SignUp()
            }
        }
    }

    private fun onPrintState() {
        Log.d("TAG", "inside_PrintStata")
        Log.d("TAG", registrationUiState.value.toString())

    }


    private fun SignUp() {
        Log.d("TAG", "Inside SignUp")
        onPrintState()

        if (registrationUiState.value.firstName.isNotEmpty() && registrationUiState.value.lastName.isNotEmpty() && registrationUiState.value.email.isNotEmpty() && registrationUiState.value.password.isNotEmpty()) {
            allValidataionsPassed.value = true
            createUserInFireBase(
                email = registrationUiState.value.email,
                password = registrationUiState.value.password
            )
        } else {
            allValidataionsPassed.value = false

        }

    }

    private fun createUserInFireBase(email: String, password: String) {
        signUpInProgress.value = true

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d("Tag", "Inside On complete listener ")
                Log.d("Tag", "isSuccessful= ${it.isSuccessful}")


                if (it.isSuccessful) {
                    FarmersAppRouter.navigateTo(Screen.HomeScreen)
                    signUpInProgress.value = false

                }
            }.addOnFailureListener {
                Log.d("Tag", "Inside not completed  listener ")
                Log.d("Tag", "isSuccessful= ${it.message}")
                signUpInProgress.value = false
                allValidataionsPassed.value = false

            }
    }

    fun logOut() {

        val fireBaseAuth = FirebaseAuth.getInstance()
        fireBaseAuth.signOut()

        val authStateListner = FirebaseAuth.AuthStateListener {
            if (it.currentUser == null) {
                Log.d("TAG", "Inside SignOut Successful")
                FarmersAppRouter.navigateTo(Screen.LoginScreen)
            } else {
                Log.d("TAG", "Inside SignOut Not Successful")
            }
        }
        fireBaseAuth.addAuthStateListener(authStateListner)
    }
}
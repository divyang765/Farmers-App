package com.example.farmersapp.SignUpLogin

sealed class LoginUiEvents {

    data class emailChanged(val email: String) : LoginUiEvents()
    data class passwordChanged(val password: String) : LoginUiEvents()

}
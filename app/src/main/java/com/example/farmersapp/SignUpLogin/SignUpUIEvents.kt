package com.example.farmersapp.SignUpLogin

sealed class SignUpUiEvents {
    data class firstNameChanged(val firstName: String) : SignUpUiEvents()
    data class lastNameChanged(val lastName: String) : SignUpUiEvents()
    data class emailChanged(val email: String) : SignUpUiEvents()
    data class passwordChanged(val password: String) : SignUpUiEvents()

    object registerButtonClicked : SignUpUiEvents()


}
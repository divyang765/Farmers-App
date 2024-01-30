package com.example.farmersapp.SignUpLogin

object Validator {

    fun validateFirstName(fName: String): validationResult {
        return (validationResult(fName.isNotEmpty() && fName.length >= 4))
    }

    fun validateLastName(lName: String): validationResult {
        return (validationResult(lName.isNotEmpty() && lName.length >= 2))
    }

    fun validateEmail(email: String): validationResult {
        return (validationResult(email.isNotEmpty()))
    }

    fun validatePassword(password: String): validationResult {
        return validationResult(password.isNotEmpty() && password.length >= 8)
    }
}

data class validationResult(val status: Boolean = false)


package com.example.mealmeatapp.controller



import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val passwordVisible = mutableStateOf(false)
    val userCredentials = mutableStateOf(UserCredentials())
    val confirmPassword = mutableStateOf("")
    val confirmPasswordVisible = mutableStateOf(false)

    fun onSignIn(): Boolean {
        return true // Always allow navigation for frontend-only
    }

    fun togglePasswordVisibility() {
        passwordVisible.value = !passwordVisible.value
    }

    fun toggleConfirmPasswordVisibility() {
        confirmPasswordVisible.value = !confirmPasswordVisible.value
    }

    fun onSignUp() {
        // No-op for frontend-only, just updates state
        userCredentials.value = userCredentials.value.copy(
            email = email.value,
            password = password.value
        )
    }

    fun onForgotPassword() {
        // No-op for frontend-only
    }
}

data class UserCredentials(
    val name: String = "",
    val email: String = "",
    val password: String = ""
)

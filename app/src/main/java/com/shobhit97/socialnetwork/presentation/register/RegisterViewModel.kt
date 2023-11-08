package com.shobhit97.socialnetwork.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
) : ViewModel() {

    private val _email = mutableStateOf<String>("")
    val email: State<String> = _email

    private val _username = mutableStateOf<String>("")
    val username: State<String> = _username

    private val _password = mutableStateOf<String>("")
    val password: State<String> = _password

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _emailError = mutableStateOf("")
    val emailError: State<String> = _emailError

    private val _usernameError = mutableStateOf("")
    val usernameError: State<String> = _usernameError

    private val _passwordError = mutableStateOf("")
    val passwordError: State<String> = _passwordError

    fun setEmail(value:String) {
        _email.value =  value
    }

    fun setUsername(value:String) {
        _username.value = value
    }

    fun setPassword(value:String) {
        _password.value = value
    }
    fun setShowPassword(showPassword:Boolean) {
        _showPassword.value = showPassword
    }
    fun setIsEmailError(error:String) {
        _emailError.value = error
    }
    fun setIsUsernameError(error:String) {
        _usernameError.value = error
    }
    fun setIsPasswordError(error:String) {
        _passwordError.value = error
    }




}



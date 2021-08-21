package com.example.pizzario.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pizzario.repository.Repository

class LoginViewModelFactory(private val repo :Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(repo) as T
    }


}
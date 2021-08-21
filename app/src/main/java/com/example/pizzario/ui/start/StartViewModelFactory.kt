package com.example.pizzario.ui.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pizzario.repository.Repository

class StartViewModelFactory(private val repo :Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StartViewModel(repo) as T
    }


}
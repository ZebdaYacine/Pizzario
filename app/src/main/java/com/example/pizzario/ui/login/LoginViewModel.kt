package com.example.pizzario.ui.login

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.pizzario.R
import com.example.pizzario.repository.Repository

class LoginViewModel(private val repo:Repository):ViewModel() {



    fun goToHomeFragment(view: View){
        Navigation.findNavController(view).
        navigate(R.id.action_loginFragment_to_homeFragment)
    }


}
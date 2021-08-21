package com.example.pizzario.ui.start

import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.pizzario.R
import com.example.pizzario.model.Post
import com.example.pizzario.repository.Repository

class StartViewModel(private val repo:Repository):ViewModel() {

    var checkIfLogin=MutableLiveData("")

    fun goToLoginFragment(viw: View){
            Navigation.findNavController(viw).
            navigate(R.id.action_startFragment_to_loginFragment)
    }

    fun goToHomeFragment(viw: View){
        Navigation.findNavController(viw).
        navigate(R.id.action_startFragment_to_homeFragment)
    }

}
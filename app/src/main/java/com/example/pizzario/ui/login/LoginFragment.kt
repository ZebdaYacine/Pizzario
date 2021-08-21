package com.example.pizzario.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.pizzario.R
import com.example.pizzario.databinding.HomeFragmentBinding
import com.example.pizzario.databinding.LoginFragmentBinding
import com.example.pizzario.repository.Repository
import com.example.pizzario.ui.home.HomeViewModel
import com.example.pizzario.ui.home.HomeViewModelFactory

class LoginFragment:Fragment(R.layout.login_fragment) {


    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = LoginFragmentBinding.inflate(inflater, container, false)
        val repo = Repository()
        val loginViewModelFactory = LoginViewModelFactory(repo)
        loginViewModel = ViewModelProvider(this, loginViewModelFactory)[LoginViewModel::class.java]
        binding.viewmodel=loginViewModel
        binding.lifecycleOwner=viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.login.setOnClickListener {
            loginViewModel.goToHomeFragment(it)
        }
    }

}
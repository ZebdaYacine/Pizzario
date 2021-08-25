package com.example.pizzario.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pizzario.R
import com.example.pizzario.databinding.LoginFragmentBinding
import com.example.pizzario.repository.Repository
import com.example.pizzario.ui.common.ViewModelFactory
import com.example.pizzario.utils.Constants.Companion.repo

class LoginFragment:Fragment(R.layout.login_fragment) {


    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = LoginFragmentBinding.inflate(inflater, container, false)
        val loginViewModelFactory = ViewModelFactory("LoginViewModel",repo,this.activity as AppCompatActivity)
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
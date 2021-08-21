package com.example.pizzario.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pizzario.R
import com.example.pizzario.databinding.StartFragmentBinding
import com.example.pizzario.repository.Repository

class StartFragment:Fragment(R.layout.start_fragment) {

    private lateinit var startViewModel: StartViewModel
    private lateinit var binding: StartFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = StartFragmentBinding.inflate(inflater, container, false)
        val repo = Repository()
        val startViewModelFactory = StartViewModelFactory(repo)
        startViewModel = ViewModelProvider(this, startViewModelFactory)[StartViewModel::class.java]
        binding.data=startViewModel
        binding.lifecycleOwner=viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        startViewModel.checkIfLogin.observe(viewLifecycleOwner, Observer {
           when(it){
               "0" ->{
                   startViewModel.goToLoginFragment(binding.root)
               }
               "1"->{
                   startViewModel.goToHomeFragment(binding.root)
               }
           }
        })
    }

}
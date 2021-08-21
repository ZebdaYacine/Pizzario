package com.example.pizzario.ui.detailsFood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.pizzario.R
import com.example.pizzario.databinding.DetailsFoodFragmentBinding
import com.example.pizzario.model.Post


class DetailsFoodFragment:Fragment(R.layout.details_food_fragment) {


    private lateinit var detailsViewModel: DetailsViewModel
    private lateinit var binding: DetailsFoodFragmentBinding

    private val args: DetailsFoodFragmentArgs by navArgs()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DetailsFoodFragmentBinding.inflate(inflater, container, false)
        val detailsViewModelFactory = DetailsViewModelFactory()
        detailsViewModel = ViewModelProvider(this, detailsViewModelFactory)[DetailsViewModel::class.java]
        binding.lifecycleOwner=viewLifecycleOwner
        binding.viewModel=detailsViewModel
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val post=arguments?.get("data") as Post
        detailsViewModel.bindArgs(post)
    }

}
package com.example.pizzario.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzario.R
import com.example.pizzario.databinding.HomeFragmentBinding
import com.example.pizzario.repository.Repository
import com.example.pizzario.ui.adapter.PostAdapter


class HomeFragment : Fragment(R.layout.home_fragment) {


    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        val repo = Repository()
        val homeViewModelFactory = HomeViewModelFactory(repo)
        homeViewModel = ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        homeViewModel.getPost()
        this.activity?.let { it ->
            homeViewModel.myResponse.observe(it, Observer {
                binding.recycler.apply {
                    layoutManager= LinearLayoutManager(activity)
                    adapter=PostAdapter(homeViewModel.post!!,listener = {
                        homeViewModel.goToAnotherFragment() })
                }
            })
        }
    }
}
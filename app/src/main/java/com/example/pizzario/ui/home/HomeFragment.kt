package com.example.pizzario.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzario.R
import com.example.pizzario.databinding.HomeFragmentBinding
import com.example.pizzario.repository.Repository
import com.example.pizzario.ui.common.ViewModelFactory
import com.example.pizzario.ui.adapter.category.CategoryAdapter
import com.example.pizzario.ui.adapter.post.PostAdapter
import com.example.pizzario.utils.Constants.Companion.repo
import com.example.pizzario.utils.Status


class HomeFragment : Fragment(R.layout.home_fragment) {


    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        val homeViewModelFactory = ViewModelFactory("HomeViewModel",repo,this.activity as AppCompatActivity)
        homeViewModel = ViewModelProvider(this, homeViewModelFactory)[HomeViewModel::class.java]
        binding.viewmodel = homeViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observer()
        homeViewModel.search.observe(viewLifecycleOwner, Observer {
            Toast.makeText(this.context, it, Toast.LENGTH_LONG).show()
        })
    }



    private fun observer() {
        homeViewModel.getPost()
        homeViewModel.isLoading.observe(this.viewLifecycleOwner, Observer { it ->
            when (it) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    binding.recycler.visibility = View.VISIBLE
                    homeViewModel.allPostsAvailable.observe(viewLifecycleOwner, Observer {
                        binding.recyclerM.apply {
                            layoutManager =
                                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                            adapter = CategoryAdapter(homeViewModel.categories!!, listener = {
                                homeViewModel.displayAllDishes(it, binding.root)
                            })
                        }
                        binding.recycler.apply {
                            layoutManager = GridLayoutManager(context, 2)
                            adapter = PostAdapter(homeViewModel.posts!!, listener = {
                                homeViewModel.goToDetailsFragment(it, binding.root)
                            })
                        }
                    })
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recycler.visibility = View.GONE
                }
                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this.context, "No connection...!!", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}


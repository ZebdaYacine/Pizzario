package com.example.pizzario.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzario.R
import com.example.pizzario.databinding.HomeFragmentBinding
import com.example.pizzario.repository.Repository
import com.example.pizzario.ui.adapter.PostAdapter
import com.example.pizzario.utils.Status


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
        observer()
        //TODO PROGRESS BAR NOT WORKS WE MUST TO FIX IT
        //setObserve()
    }

    private fun observer() {
        homeViewModel.getPost()
        homeViewModel.isLoading.observe(this.viewLifecycleOwner, Observer {
            when(it){
                Status.SUCCESS->{
                    binding.progressBar.visibility = View.GONE
                    binding.recycler.visibility = View.VISIBLE
                    homeViewModel.allPostsAvailable.observe(viewLifecycleOwner, Observer {
                        binding.recycler.apply {
                            layoutManager = LinearLayoutManager(activity)
                            adapter = PostAdapter(homeViewModel.posts!!, listener = {
                                homeViewModel.goToAnotherFragment(it)
                            })
                        }
                    })
                }
                Status.LOADING->{
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recycler.visibility = View.GONE
                }
                Status.ERROR->{
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this.context,"No connection...!!", Toast.LENGTH_LONG).show()
                }
            }
        })
    }


    private fun setObserve() {
        /*homeViewModel.getPost1()
        this.activity?.let { it ->
            homeViewModel.postsAvialable.observe(it, Observer {
                when (it!!.status) {
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        it.data?.let {
                            binding.recycler.apply {
                                layoutManager = LinearLayoutManager(activity)
                                adapter = PostAdapter(homeViewModel.posts!!, listener = {
                                    homeViewModel.goToAnotherFragment(it)
                                })
                            }
                        }
                        binding.recycler.visibility = View.VISIBLE
                    }
                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.recycler.visibility = View.GONE
                    }
                    Status.ERROR -> {
                        //Handle Error
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this.context, it.message, Toast.LENGTH_LONG).show()
                    }
                }

            })
        }*/
    }
}
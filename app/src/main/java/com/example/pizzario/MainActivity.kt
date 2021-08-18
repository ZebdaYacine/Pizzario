package com.example.pizzario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pizzario.repository.Repository
import com.example.pizzario.ui.home.HomeViewModel
import com.example.pizzario.ui.home.HomeViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repo = Repository()
        val homeViewModelFactory = HomeViewModelFactory(repo)
        homeViewModel = ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)
        homeViewModel.getPost()
        homeViewModel.myResponse.observe(this, Observer {
            Log.d("Response", it.id.toString())
            Log.d("Response", it.userId.toString())
            Log.d("Response", it.body)
            Log.d("Response", it.title)
        })
    }
}
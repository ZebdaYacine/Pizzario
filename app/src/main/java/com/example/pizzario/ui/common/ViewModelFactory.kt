package com.example.pizzario.ui.common

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import androidx.room.Room
import com.example.pizzario.data.PostDB
import com.example.pizzario.repository.Repository
import com.example.pizzario.ui.detailsFood.DetailsViewModel
import com.example.pizzario.ui.home.HomeViewModel
import com.example.pizzario.ui.login.LoginViewModel
import com.example.pizzario.ui.start.StartViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ViewModelFactory(val viewModel:String,private val repo :Repository,var act:AppCompatActivity):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val db = Room.databaseBuilder(
            act.applicationContext, PostDB::class.java,
            "PostDB"
        ).allowMainThreadQueries().build()
        when(viewModel){
            "DetailsViewModel"->{
                return DetailsViewModel() as T
            }
            "HomeViewModel"->{
                return HomeViewModel(repo,db) as T
            }
            "StartViewModel"->{
                return StartViewModel(repo) as T
            }
            "LoginViewModel"->{
                return LoginViewModel(repo) as T
            }
        }
        return  null as T
    }


}
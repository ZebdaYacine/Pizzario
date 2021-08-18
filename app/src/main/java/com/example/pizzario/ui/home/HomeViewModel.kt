package com.example.pizzario.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzario.model.Post
import com.example.pizzario.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel(private val repo :Repository):ViewModel() {

    val myResponse :MutableLiveData<Post>  = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            myResponse.value=repo.getPost()

        }
    }
}
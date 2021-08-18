package com.example.pizzario.ui.home

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzario.model.Post
import com.example.pizzario.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel(private val repo :Repository):ViewModel() {

    val myResponse :MutableLiveData<Post>  = MutableLiveData()
    val allPostsAvailable :MutableLiveData<List<Post>>  = MutableLiveData()
    var posts=ArrayList<Post>()
    val TAG="HomeViewModel"

    fun getPost(){
        viewModelScope.launch {
            posts.clear()
            myResponse.value=repo.getPost()
            repo.getPosts().also {
                allPostsAvailable.value = it
            }
            for(i in allPostsAvailable.value!!) {
                posts!!.add(i)
            }
        }
    }

    fun goToAnotherFragment(){
        Log.d("$TAG"," goToAnotherFragment  is running")
    }
}
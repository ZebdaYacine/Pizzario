package com.example.pizzario.ui.home

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzario.model.Post
import com.example.pizzario.repository.Repository
import com.example.pizzario.utils.Resource
import com.example.pizzario.utils.Status
import com.google.android.material.internal.ContextUtils.getActivity
import kotlinx.coroutines.launch

class HomeViewModel(private val repo: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Post> = MutableLiveData()
    val allPostsAvailable: MutableLiveData<List<Post>> = MutableLiveData()
    val postsAvialable: MutableLiveData<Resource<List<Post>>> = MutableLiveData()
    var posts = ArrayList<Post>()
    val TAG = "HomeViewModel"


    private val _isLoading = MutableLiveData<Status>()
    val isLoading: LiveData<Status> get() = _isLoading

    fun getPost() {
        viewModelScope.launch {
            posts.clear()
            myResponse.value = repo.getPost()
            repo.getPosts().also {
                allPostsAvailable.value = it
            }
            for (i in allPostsAvailable.value!!) {
                posts!!.add(i)
            }
        }
    }

    fun getPost1() {
        viewModelScope.launch {
            posts.clear()
            val posts = repo.getPosts()
            posts.also {
                postsAvialable.value!!.data=it
            }
            if(posts!=null){
                postsAvialable.value!!.status=Status.LOADING
            }else{
                postsAvialable.value!!.status=Status.SUCCESS
            }

        }
    }

    private fun checkDataIsNotNull(it: List<Post>): Int {
        var returnValue = 0
        if (it.isEmpty() && it != null) {
            returnValue = 1
        }
        return returnValue
    }


    fun goToAnotherFragment(post: Post) {
        Log.d("$TAG", " goToAnotherFragment  is running ${post.id}")
    }
}
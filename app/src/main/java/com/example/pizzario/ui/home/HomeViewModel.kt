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

    val allPostsAvailable: MutableLiveData<List<Post>> = MutableLiveData()
    var posts = ArrayList<Post>()
    val TAG = "HomeViewModel"


    private val _isLoading = MutableLiveData<Status>()
    val isLoading: LiveData<Status> get() = _isLoading

    fun getPost() {
        _isLoading.value=Status.LOADING
        viewModelScope.launch {
            posts.clear()
            allPostsAvailable.value = repo.getPosts()
            repo.getPosts().also {
                if(it==null){
                    _isLoading.value=Status.ERROR
                }else{
                    _isLoading.value=Status.SUCCESS
                }
                for (i in it!!) {
                    posts!!.add(i)
                }
            }
        }
    }


    fun goToAnotherFragment(post: Post) {
        Log.d("$TAG", " goToAnotherFragment  is running ${post.id}")
    }
}
package com.example.pizzario.ui.home


import android.os.Bundle
import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import com.example.pizzario.R
import com.example.pizzario.model.Post
import com.example.pizzario.repository.Repository
import com.example.pizzario.utils.Status
import kotlinx.coroutines.launch

class HomeViewModel(private val repo: Repository) : ViewModel() {


    val allPostsAvailable: MutableLiveData<List<Post>> = MutableLiveData()
    var posts = ArrayList<Post>()

    val search: MutableLiveData<String> =MutableLiveData("Search")

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


    fun goToDetailsFragment(post: Post, view:View) {
        val bundle= Bundle()
        bundle.putParcelable("data",post)
        Navigation.findNavController(view).
        navigate(R.id.action_homeFragment_to_detailsFoodFragment,bundle)
    }

}

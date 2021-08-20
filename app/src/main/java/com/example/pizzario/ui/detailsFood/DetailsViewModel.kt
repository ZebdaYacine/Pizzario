package com.example.pizzario.ui.detailsFood

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pizzario.model.Post


class DetailsViewModel : ViewModel() {


    val id: MutableLiveData<String> =MutableLiveData("0")
    val title: MutableLiveData<String> =MutableLiveData("Init Value")



    fun bindArgs(post: Post){
        title.value=post.title
        id.value=post.id.toString()
    }


}
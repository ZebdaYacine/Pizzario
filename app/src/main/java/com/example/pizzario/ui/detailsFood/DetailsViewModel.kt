package com.example.pizzario.ui.detailsFood

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class DetailsViewModel : ViewModel() {

    val id= MutableLiveData<Int>(0)
    val title= MutableLiveData<String>("")



}
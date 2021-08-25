package com.example.pizzario.utils

import android.content.Context
import androidx.room.Room
import com.example.pizzario.data.PostDB
import com.example.pizzario.repository.Repository

class Constants {

    companion object{
        const val Base_Url="https://jsonplaceholder.typicode.com/"
        val repo = Repository()
    }
}
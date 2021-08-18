package com.example.pizzario.repository

import com.example.pizzario.api.RetrofitInstance
import com.example.pizzario.model.Post

class Repository {

    suspend fun getPost():Post{
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPosts():List<Post>{
        return RetrofitInstance.api.getPosts()
    }
}
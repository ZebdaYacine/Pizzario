package com.example.pizzario.api

import com.example.pizzario.model.Post
import com.example.pizzario.utils.Resource
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost():Post

    @GET("posts")
    suspend fun getPosts():List<Post>

}
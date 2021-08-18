package com.example.pizzario.api

import com.example.pizzario.utils.Constants
import com.example.pizzario.utils.Constants.Companion.Base_Url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api :SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}
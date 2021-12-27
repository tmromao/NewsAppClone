package com.example.newsappclone.network

import retrofit2.Retrofit

object Api {

    private val BASE_URL = "https://newsapi.org/v2/"

    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL).build()

    val retrofitService: NewsService by lazy {
        retrofit.create(NewsService::class.java)
    }
}
package com.example.newsappclone

import com.example.newsappclone.ui.model.TopNewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsService {

    @GET("top-headlines")
    fun getTopArticles(
        @Query(value = "country") country: String,
        @Query("apiKey") apiKey: String
    ): Call<TopNewsResponse>

}
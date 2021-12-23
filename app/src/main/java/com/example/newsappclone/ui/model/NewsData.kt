package com.example.newsappclone.ui.model

import com.example.newsappclone.R

data class NewsData(
    val id: Int,
    val image: Int = R.drawable.breaking_news_us,
    val author: String,
    val title: String,
    val description: String,
    val publishedAt: String
)

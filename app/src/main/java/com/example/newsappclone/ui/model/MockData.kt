package com.example.newsappclone.ui.model

import android.os.Build
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

object MockData {
    val topNewsList = listOf<NewsData>(

        NewsData(
            1,
            author = "Autor 1",
            title = "Título 1",
            description = "Descrição 1",
            publishedAt = "2022-11-04T01:55:00Z"
        ),
        NewsData(
            2,
            author = "Autor 2",
            title = "Título 2",
            description = "Descricao 2",
            publishedAt = "2022-11-04T01:55:00Z"
        ),
        NewsData(
            3,
            author = "Autor 3",
            title = "Titulo 3",
            description = "Descricao 3",
            publishedAt = "2022-11-04T01:55:00Z"
        ),
        NewsData(
            4,
            author = "Autor 4",
            title = "Titulo 4",
            description = "Descricao 4",
            publishedAt = "2022-11-04T01:55:00Z"
        ),
        NewsData(
            5,
            author = "Autor 5",
            title = "Título 5",
            description = "Descricao 5",
            publishedAt = "2022-11-04T01:55:00Z"
        ),
        NewsData(
            6,
            author = "Autor 6",
            title = "Título 6",
            description = "Descricao 6",
            publishedAt = "2022-11-04T01:55:00Z"
        ),
        NewsData(
            7,
            author = "Autor 7",
            title = "Título 7",
            description = "Descricao 7",
            publishedAt = "2022-11-04T01:55:00Z"
        ),
        NewsData(
            8,
            author = "Autor 8",
            title = "Tíutlo 8",
            description = "Descricao 8",
            publishedAt = "2022-11-04T01:55:00Z"
        ),
        NewsData(
            9,
            author = "Autor 9",
            title = "Título 9",
            description = "Descricao 9",
            publishedAt = "2022-11-04T01:55:00Z"
        ),
        NewsData(
            10,
            author = "Autor 10",
            title = "Título 10",
            description = "Descricao 10",
            publishedAt = "2022-11-04T01:55:00Z"
        )
    )

    fun getNews(newsId: Int?): NewsData {
        return topNewsList.first { it.id == newsId }
    }

    fun Date.getTimeAgo(): String {

        val calendar = Calendar.getInstance()
        calendar.time = this

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val currentCalendar = Calendar.getInstance()
        val currentYear = currentCalendar.get(Calendar.YEAR)
        val currentMonth = currentCalendar.get(Calendar.MONTH)
        val currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH)
        val currentHour = currentCalendar.get(Calendar.HOUR_OF_DAY)
        val currentMinute = currentCalendar.get(Calendar.MINUTE)

        return if (year < currentYear) {
            val interval = currentYear - year
            if (interval == 1) "$interval year ago" else "$interval year ago"
        } else if (month < currentMonth) {
            val interval = currentMonth - month
            if (interval == 1) "$interval months ago" else "$interval months ago"
        } else if (day < currentDay) {
            val interval = currentDay - day
            if (interval == 1) "$interval months ago" else "$interval months ago"
        } else if (hour < currentHour) {
            val interval = currentHour - hour
            if (interval == 1) "$interval hours ago" else "$interval hours ago"
        } else if (minute < currentMinute) {
            val interval = currentMinute - minute
            if (interval == 1) "$interval minutes ago" else "$interval minutes ago"
        } else {
            "a moment ago"
        }

    }

    fun stringToDate(publishedAt: String): Date {

        val date =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH).parse(publishedAt)

            } else {
                java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH).parse(publishedAt)
            }
        Log.d("published", "$date")
        return date
    }
}


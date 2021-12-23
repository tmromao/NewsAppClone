package com.example.newsappclone.ui.model

object MockData {
    val topNewsList = listOf<NewsData>(

        NewsData(
            1,
            author = "Autor 1",
            title = "Título 1",
            description = "Descrição 1",
            publishedAt = "2022-01-0"
        ),
        NewsData(
            2,
            author = "Autor 2",
            title = "Título 2",
            description = "Descricao 2",
            publishedAt = "2022-01-0"
        ),
        NewsData(
            3,
            author = "Autor 3",
            title = "Titulo 3",
            description = "Descricao 3",
            publishedAt = "2022-01-0"
        ),
        NewsData(
            4,
            author = "Autor 4",
            title = "Titulo 4",
            description = "Descricao 4",
            publishedAt = "2022-01-0"
        ),
        NewsData(
            5,
            author = "Autor 5",
            title = "Título 5",
            description = "Descricao 5",
            publishedAt = "2022-01-0"
        ),
        NewsData(
            6,
            author = "Autor 6",
            title = "Título 6",
            description = "Descricao 6",
            publishedAt = "2022-01-0"
        ),
        NewsData(
            7,
            author = "Autor 7",
            title = "Título 7",
            description = "Descricao 7",
            publishedAt = "2022-01-0"
        ),
        NewsData(
            8,
            author = "Autor 8",
            title = "Tíutlo 8",
            description = "Descricao 8",
            publishedAt = "2022-01-0"
        ),
        NewsData(
            9,
            author = "Autor 9",
            title = "Título 9",
            description = "Descricao 9",
            publishedAt = "2022-01-0"
        ),
        NewsData(
            10,
            author = "Autor 10",
            title = "Título 10",
            description = "Descricao 10",
            publishedAt = "2022-01-0"
        )
    )

    fun getNews(newsId: Int?): NewsData {
        return topNewsList.first { it.id == newsId }
    }
}

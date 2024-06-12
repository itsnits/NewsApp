package com.example.newsapplocal.presentation.bookmark

import com.example.newsapplocal.domain.model.Article


data class BookmarkState(
    val articles: List<Article> = emptyList()
)

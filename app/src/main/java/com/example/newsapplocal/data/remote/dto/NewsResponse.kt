package com.example.newsapplocal.data.remote.dto

import com.example.newsapplocal.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
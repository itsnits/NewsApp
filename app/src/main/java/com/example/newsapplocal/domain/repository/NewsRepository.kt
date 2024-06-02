package com.example.newsapplocal.domain.repository

import androidx.paging.PagingData
import com.example.newsapplocal.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources : List<String>) : Flow<PagingData<Article>>
}
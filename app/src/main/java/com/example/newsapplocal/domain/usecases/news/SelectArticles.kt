package com.example.newsapplocal.domain.usecases.news

import com.example.newsapplocal.data.local.NewsDao
import com.example.newsapplocal.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles (
    private val newsDao: NewsDao
) {
    operator fun invoke() : Flow<List<Article>>{
        return newsDao.getArticles()
    }
}
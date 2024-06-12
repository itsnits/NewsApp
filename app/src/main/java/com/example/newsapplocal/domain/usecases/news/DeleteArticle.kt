package com.example.newsapplocal.domain.usecases.news

import com.example.newsapplocal.data.local.NewsDao
import com.example.newsapplocal.domain.model.Article

class DeleteArticle (
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article){
        newsDao.delete(article = article)
    }
}
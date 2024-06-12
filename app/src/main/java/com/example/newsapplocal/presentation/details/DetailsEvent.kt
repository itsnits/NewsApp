package com.example.newsapplocal.presentation.details

sealed class DetailsEvent {
    object SaveArticle : DetailsEvent()
}
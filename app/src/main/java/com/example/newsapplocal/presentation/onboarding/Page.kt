package com.example.newsapplocal.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.newsapplocal.R

data class Page(
    val title: String,
    val description : String,
    @DrawableRes val image : Int
)

val pages = listOf(
    Page(
        title = "Lorem Ipsum is a simple dummy text",
        description = "Lorem Ipsum is a simple dummy text for text rendenring and partitioning",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Lorem Ipsum is a simple dummy text",
        description = "Lorem Ipsum is a simple dummy text for text rendenring and partitioning",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Lorem Ipsum is a simple dummy text",
        description = "Lorem Ipsum is a simple dummy text for text rendenring and partitioning",
        image = R.drawable.onboarding3
    )
)

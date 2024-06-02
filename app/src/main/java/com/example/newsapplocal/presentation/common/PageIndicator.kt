package com.example.newsapplocal.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapplocal.presentation.Dimens.indicatorSize

@Preview(showBackground = true)
@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int = 3,
    selctedPage : Int = 0,
    selectedColor : Color = MaterialTheme.colorScheme.primary,
    unselectedColor : Color = Color.DarkGray
){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
            repeat(pageSize){
                page ->
                Box(
                    modifier = Modifier.size(indicatorSize)
                        .clip(CircleShape)
                        .background(color = if(page == selctedPage) selectedColor else unselectedColor)
                )
            }
    }
}
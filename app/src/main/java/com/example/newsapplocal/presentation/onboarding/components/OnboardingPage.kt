package com.example.newsapplocal.presentation.onboarding.components

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import com.example.newsapplocal.R
import com.example.newsapplocal.presentation.Dimens.mediumPadding1
import com.example.newsapplocal.presentation.Dimens.mediumPadding2
import com.example.newsapplocal.presentation.onboarding.Page

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun OnboardingPage(
    modifier: Modifier = Modifier,
    Page: Page = Page(
        title = "Lorem Ipsum is a simple dummy",
        description = "Lorem ipsum is a simple dummy text of printing and typesetting industry",
        image = R.drawable.onboarding1
    ),
){
        Column(modifier = modifier) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(fraction = 0.6f),
                painter = painterResource(id = Page.image),
                contentDescription = null,
                contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.height(mediumPadding1))
            Text(
                text = Page.title,
                modifier = Modifier.padding(horizontal = mediumPadding2),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.display_small)
            )
            Text(
                text = Page.description,
                modifier = Modifier.padding(horizontal = mediumPadding2),
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_medium)
            )

        }
}
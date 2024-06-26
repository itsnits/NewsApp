package com.example.newsapplocal.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsapplocal.presentation.bookmark.BookmarkScreen
import com.example.newsapplocal.presentation.bookmark.BookmarkViewModel
import com.example.newsapplocal.presentation.home.HomeScreen
import com.example.newsapplocal.presentation.home.HomeViewModel
import com.example.newsapplocal.presentation.onboarding.OnBoardingScreen
import com.example.newsapplocal.presentation.onboarding.OnboardingViewModel
import com.example.newsapplocal.presentation.search.SearchScreen
import com.example.newsapplocal.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination : String
){
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnboardingScreen.route
        ){
            composable(
                route = Route.OnboardingScreen.route
            ){
                val viewModel : OnboardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel :: onEvent
                )
            }
        }
//        navigation(
//            route = Route.NewsNavigation.route,
//            startDestination = Route.NewsNavigationScreen.route
//        ){
//            composable(
//                route = Route.NewsNavigationScreen.route
//            ){
//                val viewModel : HomeViewModel = hiltViewModel()
//                val articles = viewModel.news.collectAsLazyPagingItems()
//                HomeScreen(
//                    articles = articles,
//                    navigate = {})
//            }
//        }

//        navigation(
//            route = Route.NewsNavigation.route,
//            startDestination = Route.NewsNavigationScreen.route
//        ){
//            composable(
//                route = Route.NewsNavigationScreen.route
//            ){
//                val viewModel : SearchViewModel = hiltViewModel()
//                SearchScreen(
//                    state = viewModel.state.value,
//                    event = viewModel :: onEvent,
//                    navigate = {}
//                )
//            }
//        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigationScreen.route
        ){
            composable(
                route = Route.NewsNavigationScreen.route
            ){
                val viewModel : BookmarkViewModel = hiltViewModel()
                BookmarkScreen(
                    state = viewModel.state.value,
                    navigate = {}
                )
            }
        }
    }
}
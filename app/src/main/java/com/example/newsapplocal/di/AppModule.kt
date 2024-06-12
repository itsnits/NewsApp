package com.example.newsapplocal.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsapplocal.data.local.NewsDao
import com.example.newsapplocal.data.local.NewsDatabase
import com.example.newsapplocal.data.local.NewsTypeConverter
import com.example.newsapplocal.data.manager.LocalUserManagerImpl
import com.example.newsapplocal.data.remote.NewsApi
import com.example.newsapplocal.data.repository.NewsRepositoryImpl
import com.example.newsapplocal.domain.manager.LocalUserManager
import com.example.newsapplocal.domain.repository.NewsRepository
import com.example.newsapplocal.domain.usecases.app_entry.AppEntryUseCases
import com.example.newsapplocal.domain.usecases.app_entry.ReadAppEntry
import com.example.newsapplocal.domain.usecases.app_entry.SaveAppEntry
import com.example.newsapplocal.domain.usecases.news.DeleteArticle
import com.example.newsapplocal.domain.usecases.news.GetNews
import com.example.newsapplocal.domain.usecases.news.NewsUseCases
import com.example.newsapplocal.domain.usecases.news.SearchNews
import com.example.newsapplocal.domain.usecases.news.SelectArticles
import com.example.newsapplocal.domain.usecases.news.UpsertArticle
import com.example.newsapplocal.utils.Constants.BASE_URL
import com.example.newsapplocal.utils.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent ::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ) : LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi():NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi :: class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ) : NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ) : NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsDao),
            deleteArticle = DeleteArticle(newsDao),
            selectArticles = SelectArticles(newsDao)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabas(
        application: Application
    ) : NewsDatabase{
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase :: class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    @Singleton
    fun providesNewsDao(
        newsDatabase: NewsDatabase
    ) : NewsDao = newsDatabase.newsDao
}
package com.example.newsapplocal.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.example.newsapplocal.domain.model.Article
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article)

    @Delete
    suspend fun delete(article: Article)

    @Query("Select * From Article")
    fun getArticles():Flow<List<Article>>
}
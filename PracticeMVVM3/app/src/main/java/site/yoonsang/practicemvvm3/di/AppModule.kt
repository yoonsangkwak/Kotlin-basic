package site.yoonsang.practicemvvm3.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import site.yoonsang.practicemvvm3.database.BookmarkNewsDatabase
import site.yoonsang.practicemvvm3.network.HttpRequestInterceptor
import site.yoonsang.practicemvvm3.network.NewsApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideBookmarkNewsDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        BookmarkNewsDatabase::class.java,
        "bookmark_db"
    ).build()

    @Singleton
    @Provides
    fun provideBookmarkNewsDao(db: BookmarkNewsDatabase) = db.bookmarkNewsDao()

    @Singleton
    @Provides
    fun provideClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addNetworkInterceptor(HttpRequestInterceptor())
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(NewsApi.BASE_URL)
            .client(provideClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideNewsApi(retrofit: Retrofit): NewsApi =
        retrofit.create(NewsApi::class.java)
}
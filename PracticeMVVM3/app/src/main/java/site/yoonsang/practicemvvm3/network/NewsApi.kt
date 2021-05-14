package site.yoonsang.practicemvvm3.network

import retrofit2.http.GET
import retrofit2.http.Query
import site.yoonsang.practicemvvm3.models.NewsResponse

interface NewsApi {

    companion object {
        const val BASE_URL = "https://openapi.naver.com/"
    }

    @GET("/v1/search/news.json")
    suspend fun getSearchNews(
        @Query("query") query: String,
        @Query("display") display: Int? = 10,
        @Query("start") start: Int? = 1,
        @Query("sort") sort: String? = "sim"
    ): NewsResponse
}
package site.yoonsang.koinpractice.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import site.yoonsang.koinpractice.model.MovieDetails
import site.yoonsang.koinpractice.model.MovieResponse

interface MovieApi {

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/"
    }

    @GET("/3/movie/popular")
    suspend fun getPopularMovie(
        @Query("page") page: Int
    ): MovieResponse

    @GET("/3/movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") id: Int
    ): MovieDetails
}
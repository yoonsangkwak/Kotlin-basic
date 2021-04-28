package site.yoonsang.moviemvvm.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import site.yoonsang.moviemvvm.data.vo.MovieDetails
import site.yoonsang.moviemvvm.data.vo.MovieResponse

interface TheMovieDBInterface {

    // https://api.themoviedb.org/3/movie/popular?api_key=ce93d459c0e647dd2bc8bc9834eae6a3
    // https://api.themoviedb.org/3/movie/399566?api_key=ce93d459c0e647dd2bc8bc9834eae6a3
    // https://api.themoviedb.org/3/

    @GET("/3/movie/popular")
    fun getPopularMovie(
        @Query("page") page: Int
    ): Single<MovieResponse>

    @GET("/3/movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") id: Int
    ): Single<MovieDetails>
}
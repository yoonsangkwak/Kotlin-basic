package site.yoonsang.koinpractice.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.rxjava3.observable
import site.yoonsang.koinpractice.network.MovieApi

class MovieRepository(
    private val movieApi: MovieApi
) {

    fun getPopularMovies() =
        Pager(
            config = PagingConfig(
                pageSize = 5,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PopularMoviePagingSource(movieApi)
            }
        ).observable
}
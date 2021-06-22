package site.yoonsang.koinpractice.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import site.yoonsang.koinpractice.model.Movie
import site.yoonsang.koinpractice.network.MovieApi
import site.yoonsang.koinpractice.util.Constants
import java.io.IOException

class PopularMoviePagingSource(
    private val movieApi: MovieApi
): PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val position = params.key ?: Constants.STARTING_PAGE_INDEX
        return try {
            val response = movieApi.getPopularMovie(
                page = position
            )
            val movieList = response.movies

            LoadResult.Page(
                data = movieList,
                prevKey = if (position == Constants.STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (movieList.size < Constants.ITEM_MEMBERS_IN_PAGE) null else position + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}
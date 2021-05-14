package site.yoonsang.practicemvvm3.repositories

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import site.yoonsang.practicemvvm3.models.News
import site.yoonsang.practicemvvm3.network.NewsApi
import java.io.IOException

private const val SHOW_STARTING_PAGE_INDEX = 1
private const val ITEM_MEMBERS_IN_PAGE = 20

class NewsSearchPagingSource(
    private val newsApi: NewsApi,
    private val query: String
) : PagingSource<Int, News>() {

    override fun getRefreshKey(state: PagingState<Int, News>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, News> {
        val position = params.key ?: SHOW_STARTING_PAGE_INDEX
        return try {
            val response = newsApi.getSearchNews(query, start = position)
            val news = response.news

            LoadResult.Page(
                data = news,
                prevKey = if (position == SHOW_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (news.size < ITEM_MEMBERS_IN_PAGE) null else position + 1
            )
        } catch (e: IOException) {
            Log.d("checkkk", "IOE ${e.message}")
            LoadResult.Error(e)
        } catch (e: HttpException) {
            Log.d("checkkk", "HE ${e.message}")
            LoadResult.Error(e)
        }
    }
}
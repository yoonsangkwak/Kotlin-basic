package site.yoonsang.practicemvvm3.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import site.yoonsang.practicemvvm3.network.NewsApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(private val newsApi: NewsApi) {

    fun getSearchNews(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 1,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                NewsSearchPagingSource(newsApi, query)
            }
        ).liveData
}
package site.yoonsang.practicemvvm3.repositories

import androidx.lifecycle.LiveData
import site.yoonsang.practicemvvm3.database.BookmarkNewsDao
import site.yoonsang.practicemvvm3.models.BookmarkNews
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookmarkRepository @Inject constructor(private val bookmarkNewsDao: BookmarkNewsDao) {

    suspend fun insert(bookmarkNews: BookmarkNews) {
        bookmarkNewsDao.insert(bookmarkNews)
    }

    suspend fun delete(bookmarkNews: BookmarkNews) {
        bookmarkNewsDao.delete(bookmarkNews)
    }

    suspend fun deleteAll() {
        bookmarkNewsDao.deleteAll()
    }

    fun getBookmarkNews(): LiveData<List<BookmarkNews>> = bookmarkNewsDao.getBookmarkNews()

    suspend fun checkNews(title: String) = bookmarkNewsDao.checkNews(title)

    suspend fun removeFromBookmark(title: String) {
        bookmarkNewsDao.removeFromBookmark(title)
    }
}
package site.yoonsang.practicemvvm3.database

import androidx.lifecycle.LiveData
import androidx.room.*
import site.yoonsang.practicemvvm3.models.BookmarkNews

@Dao
interface BookmarkNewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bookmarkNews: BookmarkNews)

    @Query("select * from bookmark_table")
    fun getBookmarkNews(): LiveData<List<BookmarkNews>>

    @Query("select count(*) from bookmark_table where bookmark_table.id = :id")
    suspend fun checkNews(id: String): Int

    @Query("delete from bookmark_table where bookmark_table.id = :id")
    suspend fun removeFromBookmark(id: String): Int

    @Delete
    suspend fun delete(bookmarkNews: BookmarkNews)

    @Query("delete from bookmark_table")
    suspend fun deleteAll()
}
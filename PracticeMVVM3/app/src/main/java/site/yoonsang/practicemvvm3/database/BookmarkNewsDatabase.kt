package site.yoonsang.practicemvvm3.database

import androidx.room.Database
import androidx.room.RoomDatabase
import site.yoonsang.practicemvvm3.models.BookmarkNews

@Database(entities = [BookmarkNews::class], version = 1, exportSchema = false)
abstract class BookmarkNewsDatabase: RoomDatabase() {
    abstract fun bookmarkNewsDao(): BookmarkNewsDao
}
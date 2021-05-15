package site.yoonsang.practicemvvm3.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "bookmark_table")
@Parcelize
class BookmarkNews(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val description: String,
    val link: String,
    val originalLink: String,
    val pubDate: String,
    val title: String
): Parcelable
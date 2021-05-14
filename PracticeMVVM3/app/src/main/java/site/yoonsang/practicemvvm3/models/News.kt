package site.yoonsang.practicemvvm3.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val description: String,
    val link: String,
    val originallink: String,
    val pubDate: String,
    val title: String
): Parcelable
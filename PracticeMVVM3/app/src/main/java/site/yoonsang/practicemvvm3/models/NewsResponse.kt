package site.yoonsang.practicemvvm3.models


import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("display")
    val display: Int,
    @SerializedName("items")
    val news: List<News>,
    @SerializedName("lastBuildDate")
    val lastBuildDate: String,
    @SerializedName("start")
    val start: Int,
    @SerializedName("total")
    val total: Int
)
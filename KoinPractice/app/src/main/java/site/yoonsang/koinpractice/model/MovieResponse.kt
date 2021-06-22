package site.yoonsang.koinpractice.model

import com.google.gson.annotations.SerializedName
import site.yoonsang.koinpractice.model.Movie

data class MovieResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movies: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
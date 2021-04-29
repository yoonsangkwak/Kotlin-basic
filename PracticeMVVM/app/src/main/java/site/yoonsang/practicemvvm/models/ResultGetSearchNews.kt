package site.yoonsang.practicemvvm.models

data class ResultGetSearchNews(
    var start: Int = 0,
    var display: Int = 0,
    var items: List<NewsItems>
)
package site.yoonsang.practicemvvm3.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import site.yoonsang.practicemvvm3.models.BookmarkNews
import site.yoonsang.practicemvvm3.repositories.BookmarkRepository
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: BookmarkRepository) :
    ViewModel() {

    fun addToBookmark(bookmarkNews: BookmarkNews) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(bookmarkNews)
        }
    }

    suspend fun checkNews(id: String) = repository.checkNews(id)

    fun removeFromBookmark(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeFromBookmark(id)
        }
    }
}
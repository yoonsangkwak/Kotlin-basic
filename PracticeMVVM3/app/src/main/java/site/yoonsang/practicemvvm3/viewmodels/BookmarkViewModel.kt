package site.yoonsang.practicemvvm3.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import site.yoonsang.practicemvvm3.models.BookmarkNews
import site.yoonsang.practicemvvm3.repositories.BookmarkRepository
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(private val repository: BookmarkRepository) :
    ViewModel() {

    val news = repository.getBookmarkNews()

    fun insert(bookmarkNews: BookmarkNews) {
        viewModelScope.launch {
            repository.insert(bookmarkNews)
        }
    }

    fun delete(bookmarkNews: BookmarkNews) {
        viewModelScope.launch {
            repository.delete(bookmarkNews)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
}
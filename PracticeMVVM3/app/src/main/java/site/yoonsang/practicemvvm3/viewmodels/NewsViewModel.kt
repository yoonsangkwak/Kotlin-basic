package site.yoonsang.practicemvvm3.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import site.yoonsang.practicemvvm3.repositories.NewsRepository
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    val searchText = MutableLiveData<String>()

    val searchNews = Transformations.switchMap(searchText) { text ->
        repository.getSearchNews(text).cachedIn(viewModelScope)
    }

    fun getSearchNews(text: String) {
        searchText.value = text
    }
}
package site.yoonsang.testapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _num =  MutableLiveData(0)
    val num: LiveData<Int>
        get() = _num

    private var count = 1

    fun addNum() {
        count++
        _num.postValue(count)
    }
}
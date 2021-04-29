package site.yoonsang.practicemvvm.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import site.yoonsang.practicemvvm.api.NaverAPI
import site.yoonsang.practicemvvm.models.ResultGetSearchNews

class CoronaRepository(application: Application) {

    private val api = NaverAPI.create()
    private var newsData: MutableLiveData<ResultGetSearchNews> = MutableLiveData()

    fun getNews(n: Int): Observable<ResultGetSearchNews> = api
        .getSearchNews("코로나 부산", 100, n)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}
package site.yoonsang.practicemvvm3.network

import okhttp3.Interceptor
import okhttp3.Response
import site.yoonsang.practicemvvm3.BuildConfig

class HttpRequestInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("X-NAVER-CLIENT-ID", BuildConfig.NAVER_CLIENT_ID)
        builder.addHeader("X-NAVER-CLIENT-SECRET", BuildConfig.NAVER_CLIENT_SECRET)
        return chain.proceed(builder.build())
    }
}
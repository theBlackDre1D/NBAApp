package co.init.nbaapp.network

import co.init.nbaapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val requestWithApiKey = originalRequest.newBuilder()
            .header("Authorization", BuildConfig.API_KEY)
            .build()

        return chain.proceed(requestWithApiKey)
    }
}
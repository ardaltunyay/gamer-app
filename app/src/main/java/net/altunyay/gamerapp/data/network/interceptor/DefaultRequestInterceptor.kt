package net.altunyay.gamerapp.data.network.interceptor

import net.altunyay.gamerapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class DefaultRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(with(chain.request().newBuilder()) {
            addHeader("Content-Type", "application/json")
            addHeader("VersionCode", BuildConfig.VERSION_CODE.toString())
            addHeader("VersionName", BuildConfig.VERSION_NAME)
            addHeader("ApplicationId", BuildConfig.APPLICATION_ID)
            addHeader("user-key", BuildConfig.USER_KEY)
            build()
        })
    }
}
package net.altunyay.gamerapp.data.network

import net.altunyay.gamerapp.BuildConfig
import net.altunyay.gamerapp.data.network.interceptor.DefaultRequestInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun createRequestInterceptor(): DefaultRequestInterceptor = DefaultRequestInterceptor()

fun createHttpLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

fun createOkHttpClient(
    requestInterceptor: DefaultRequestInterceptor,
    httpLoggingInterceptor: HttpLoggingInterceptor
): OkHttpClient =
    with(OkHttpClient.Builder()) {
        connectTimeout(NetworkConstants.CONNECT_TIMEOUT_IN_MILLISECONDS, TimeUnit.MILLISECONDS)
        readTimeout(NetworkConstants.READ_TIMEOUT_IN_MILLISECONDS, TimeUnit.MILLISECONDS)
        addInterceptor(requestInterceptor)
        if (BuildConfig.DEBUG) addInterceptor(httpLoggingInterceptor)
        build()
    }

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    return with(Retrofit.Builder()) {
        baseUrl(url)
        client(okHttpClient)
        addConverterFactory(GsonConverterFactory.create())
        build()
    }.create(T::class.java)
}

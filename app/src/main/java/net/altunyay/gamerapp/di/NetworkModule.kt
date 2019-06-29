package net.altunyay.gamerapp.di

import net.altunyay.gamerapp.data.network.createHttpLoggingInterceptor
import net.altunyay.gamerapp.data.network.createOkHttpClient
import net.altunyay.gamerapp.data.network.createRequestInterceptor
import org.koin.dsl.module

val networkModule = module {
    single { createRequestInterceptor() }
    single { createHttpLoggingInterceptor() }
    single { createOkHttpClient(get(), get()) }
}
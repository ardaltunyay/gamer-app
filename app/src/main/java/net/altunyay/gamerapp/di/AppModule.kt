package net.altunyay.gamerapp.di

import net.altunyay.gamerapp.common.coroutines.ISchedulerProvider
import net.altunyay.gamerapp.common.coroutines.SchedulerProvider
import net.altunyay.gamerapp.common.preferences.ClientPreferences
import org.koin.dsl.module
import org.koin.experimental.builder.singleBy

val appModule = module {

    single { ClientPreferences(get()) }
    singleBy<ISchedulerProvider, SchedulerProvider>(createOnStart = true)
}
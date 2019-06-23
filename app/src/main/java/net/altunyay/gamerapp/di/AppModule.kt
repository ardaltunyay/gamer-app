package net.altunyay.gamerapp.di

import net.altunyay.gamerapp.common.utils.ClientPreferences
import org.koin.dsl.module

val appModule = module {

    single { ClientPreferences(get()) }
}
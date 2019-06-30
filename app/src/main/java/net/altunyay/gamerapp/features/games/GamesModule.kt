package net.altunyay.gamerapp.features.games

import net.altunyay.gamerapp.BuildConfig
import net.altunyay.gamerapp.data.network.createWebService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val gamesModule = module {
    single { createWebService<GamesApi>(get(), BuildConfig.BASE_URL) }
    viewModel { GamesViewModel(get(), get()) }
}
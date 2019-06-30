package net.altunyay.gamerapp.features.games

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import net.altunyay.gamerapp.common.coroutines.CoroutineViewModel
import net.altunyay.gamerapp.common.coroutines.ISchedulerProvider
import net.altunyay.gamerapp.data.domain.Game

class GamesViewModel(private val gamesApi: GamesApi, private val schedulerProvider: ISchedulerProvider): CoroutineViewModel(schedulerProvider) {

    private val _games = MutableLiveData<MutableList<Game>>()
    val games : LiveData<MutableList<Game>>
        get() = _games

    fun getGames() {
        launch {
            val response = gamesApi.games("fields *;")
            if(response.isSuccessful) {
                response.body()?.let {
                    _games.value = it
                }
            }
        }
    }
}
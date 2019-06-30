package net.altunyay.gamerapp.features.games

import net.altunyay.gamerapp.data.domain.Game
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface GamesApi {

    @POST("/games")
    suspend fun games(@Body body : String) : Response<MutableList<Game>>
}
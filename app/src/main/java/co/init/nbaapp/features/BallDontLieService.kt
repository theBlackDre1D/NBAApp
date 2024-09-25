package co.init.nbaapp.features

import co.init.nbaapp.data.PageResponse
import co.init.nbaapp.data.Player
import retrofit2.Response
import retrofit2.http.GET

interface BallDontLieService {

    @GET("players")
    suspend fun getPlayers(): Response<PageResponse<Player>>
}
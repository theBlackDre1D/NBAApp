package co.init.nbaapp.features.playersList.domain

import co.init.nbaapp.data.PageResponse
import co.init.nbaapp.data.Player
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BallDontLieService {

    @GET("players")
    suspend fun getPlayers(
        @Query("cursor") cursor: Int,
        @Query("per_page") perPage: Int
    ): Response<PageResponse<Player>>
}
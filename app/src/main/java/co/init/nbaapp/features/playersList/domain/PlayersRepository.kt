package co.init.nbaapp.features.playersList.domain

import co.init.nbaapp.data.PageRequest
import javax.inject.Inject

class PlayersRepository @Inject constructor(
    private val remoteDataSource: PlayersRemoteDataSource
) {

    suspend fun getPlayers(pageRequest: PageRequest) = remoteDataSource.getPlayers(pageRequest)
}
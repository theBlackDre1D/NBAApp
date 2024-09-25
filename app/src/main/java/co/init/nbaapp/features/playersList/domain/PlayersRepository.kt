package co.init.nbaapp.features.playersList.domain

import javax.inject.Inject

class PlayersRepository @Inject constructor(
    private val remoteDataSource: PlayersRemoteDataSource
) {

    suspend fun getPlayers() = remoteDataSource.getPlayers()
}
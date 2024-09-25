package co.init.nbaapp.features.playersList.domain

import javax.inject.Inject

class GetPlayersUseCase @Inject constructor(
    private val repository: PlayersRepository
) {

    suspend operator fun invoke() = repository.getPlayers()
}
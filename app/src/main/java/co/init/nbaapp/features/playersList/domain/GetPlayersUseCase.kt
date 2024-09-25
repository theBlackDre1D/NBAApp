package co.init.nbaapp.features.playersList.domain

import co.init.nbaapp.data.PageRequest
import javax.inject.Inject

class GetPlayersUseCase @Inject constructor(
    private val repository: PlayersRepository
) {

    suspend operator fun invoke(pageRequest: PageRequest) = repository.getPlayers(pageRequest)
}
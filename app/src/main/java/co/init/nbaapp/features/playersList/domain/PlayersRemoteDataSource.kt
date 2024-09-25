package co.init.nbaapp.features.playersList.domain

import co.init.nbaapp.data.PageRequest
import co.init.nbaapp.data.PageResponse
import co.init.nbaapp.data.Player
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlayersRemoteDataSource @Inject constructor(
    private val service: BallDontLieService
) {

    suspend fun getPlayers(pageRequest: PageRequest) = flow<Result<PageResponse<Player>>> {
        val response = service.getPlayers(pageRequest.cursor, pageRequest.perPage)
        if (response.isSuccessful) {
            response.body()?.let { body ->
                emit(Result.success(body))
            }
        } else {
            emit(Result.failure(Throwable(response.message())))
        }
    }.catch {
        emit(Result.failure(it))
    }
}
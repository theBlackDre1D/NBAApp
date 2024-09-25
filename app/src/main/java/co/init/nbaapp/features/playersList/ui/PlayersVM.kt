package co.init.nbaapp.features.playersList.ui

import androidx.lifecycle.ViewModel
import co.init.nbaapp.data.PageRequest
import co.init.nbaapp.data.Player
import co.init.nbaapp.extensions.doInCoroutine
import co.init.nbaapp.features.playersList.domain.GetPlayersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PlayersVM @Inject constructor(
    private val getPlayersUseCase: GetPlayersUseCase
) : ViewModel() {

    data class ScreenState(
        val players: Result<List<Player>> = Result.success(listOf()),
        val loading: Boolean = false
    )

    private val _state = MutableStateFlow(ScreenState())
    val state: StateFlow<ScreenState> = _state

    var pickedPlayer: Player? = null

    private val pageRequest: PageRequest
        get() = PageRequest(_state.value.players.getOrNull()?.size ?: 0)

    fun getPlayers() {
        doInCoroutine {
            _state.update { it.copy(loading = true) }

            getPlayersUseCase(pageRequest).collect { result ->
                _state.update { it.copy(loading = false) }

                result.fold(
                    onSuccess = { success ->
                        _state.update { currentState ->
                            currentState.copy(
                                players = Result.success(
                                    currentState.players.getOrNull().orEmpty() + success.data
                                )
                            )
                        }
                    },
                    onFailure = { throwable ->
                        _state.update { it.copy(players = Result.failure(throwable)) }
                    }
                )
            }
        }
    }
}
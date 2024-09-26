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
        val players: List<Player> = listOf(),
        val loading: Boolean = false
    )

    private val _state = MutableStateFlow(ScreenState())
    val state: StateFlow<ScreenState> = _state

    val error = MutableStateFlow<Throwable?>(null)

    var pickedPlayer: Player? = null

    fun initialLoadData() {
        if (state.value.players.isEmpty() && !state.value.loading) {
            getPlayers()
        }
    }

    fun getPlayers() {
        doInCoroutine {
            _state.update { it.copy(loading = true) }

            val pageRequest = PageRequest(_state.value.players.size)
            getPlayersUseCase(pageRequest).collect { result ->
                _state.update { it.copy(loading = false) }

                result.fold(
                    onSuccess = { success ->
                        _state.update {
                            currentState -> currentState.copy(players = currentState.players + success.data)
                        }
                    },
                    onFailure = { throwable ->
                        error.update { throwable }
                    }
                )
            }
        }
    }

    fun clearError() = error.update { null }
}
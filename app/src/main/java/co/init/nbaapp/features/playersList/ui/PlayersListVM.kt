package co.init.nbaapp.features.playersList.ui

import androidx.lifecycle.ViewModel
import co.init.nbaapp.data.Player
import co.init.nbaapp.data.events.PlayersEvents
import co.init.nbaapp.extensions.doInCoroutine
import co.init.nbaapp.features.playersList.domain.GetPlayersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PlayersListVM @Inject constructor(
    private val getPlayersUseCase: GetPlayersUseCase
) : ViewModel() {

    data class ScreenState(
        val players: List<Player> = listOf(),
        val event: PlayersEvents? = null
    )

    private val _state = MutableStateFlow(ScreenState())
    val state: StateFlow<ScreenState> = _state


    fun getPlayers() {
        doInCoroutine {
            getPlayersUseCase().collect { result ->
                result.fold(
                    onSuccess = { success ->
                        _state.update { it.copy(players = it.players + success.data) }
                    },
                    onFailure = { throwable ->
                        _state.update { it.copy(event = PlayersEvents.Error(throwable)) }
                    }
                )
            }
        }
    }
}
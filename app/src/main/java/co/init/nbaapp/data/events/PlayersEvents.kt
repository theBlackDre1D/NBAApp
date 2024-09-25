package co.init.nbaapp.data.events

sealed class PlayersEvents {
    data class Error(val throwable: Throwable?) : PlayersEvents()
}
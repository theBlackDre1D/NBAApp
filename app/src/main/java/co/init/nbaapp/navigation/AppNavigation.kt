package co.init.nbaapp.navigation

abstract class Path(open val path: String)

sealed class PlayersListNavigation(override val path: String) : Path(path) {
    data object Home : PlayersListNavigation("home")
}
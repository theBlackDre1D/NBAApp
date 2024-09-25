package co.init.nbaapp.navigation

abstract class Path(open val path: String)

sealed class PlayersListNavigation(override val path: String) : Path(path) {
    data object PlayersList : PlayersListNavigation("players_list")
    data object ClubDetail : PlayersListNavigation("club_detail")
}
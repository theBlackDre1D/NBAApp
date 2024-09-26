package co.init.nbaapp.navigation

abstract class Path(open val path: String)

sealed class MainActivityNavigation(override val path: String) : Path(path) {
    data object PlayersList : MainActivityNavigation("players_list")
    data object PlayerDetail : MainActivityNavigation("player_detail")
    data object ClubDetail : MainActivityNavigation("club_detail")
}
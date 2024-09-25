package co.init.nbaapp.navigation

abstract class Path(open val path: String)

sealed class AppNavigation(override val path: String) : Path(path) {
    data object PlayersList : AppNavigation("players_list")
    data object PlayerDetail : AppNavigation("player_detail")
    data object ClubDetail : AppNavigation("club_detail")
}
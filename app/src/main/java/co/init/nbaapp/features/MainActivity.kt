package co.init.nbaapp.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import co.init.nbaapp.extensions.composablePath
import co.init.nbaapp.features.playerDetail.PlayerDetailScreen
import co.init.nbaapp.features.playersList.ui.PlayersListScreen
import co.init.nbaapp.features.playersList.ui.PlayersVM
import co.init.nbaapp.features.teamDetail.TeamDetailScreen
import co.init.nbaapp.navigation.AppNavigation
import co.init.nbaapp.ui.theme.NBAAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val sharedVM: PlayersVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedVM.initialLoadData()

        setContent {
            NBAAppTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { _ ->
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = AppNavigation.PlayersList.path) {
                        composablePath(AppNavigation.PlayersList) { PlayersListScreen(sharedVM, navController) }
                        composablePath(AppNavigation.PlayerDetail) { PlayerDetailScreen(sharedVM, navController) }
                        composablePath(AppNavigation.ClubDetail) { TeamDetailScreen(sharedVM) }
                    }
                }
            }
        }
    }
}
package co.init.nbaapp.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import co.init.nbaapp.extensions.composablePath
import co.init.nbaapp.features.playersList.ui.PlayersListScreen
import co.init.nbaapp.navigation.PlayersListNavigation
import co.init.nbaapp.ui.theme.NBAAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NBAAppTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { _ ->
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = PlayersListNavigation.PlayersList.path) {
                        composablePath(PlayersListNavigation.PlayersList) { PlayersListScreen() }
                        composablePath(PlayersListNavigation.ClubDetail) { /* TODO */ }
                    }
                }
            }
        }
    }
}
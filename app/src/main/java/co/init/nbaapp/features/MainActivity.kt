package co.init.nbaapp.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import co.init.nbaapp.extensions.composablePath
import co.init.nbaapp.features.playerDetail.PlayerDetailScreen
import co.init.nbaapp.features.playersList.ui.PlayersListScreen
import co.init.nbaapp.features.playersList.ui.PlayersVM
import co.init.nbaapp.features.teamDetail.TeamDetailScreen
import co.init.nbaapp.navigation.MainActivityNavigation
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
                val snackbarHostState = remember { SnackbarHostState() }
                val error = sharedVM.error.collectAsState()

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackbarHostState) }
                ) { _ ->
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = MainActivityNavigation.PlayersList.path) {
                        composablePath(MainActivityNavigation.PlayersList) { PlayersListScreen(sharedVM, navController) }
                        composablePath(MainActivityNavigation.PlayerDetail) { PlayerDetailScreen(sharedVM, navController) }
                        composablePath(MainActivityNavigation.ClubDetail) { TeamDetailScreen(sharedVM) }
                    }

                    error.value?.let { throwable ->
                        LaunchedEffect(throwable) {
                            snackbarHostState.showSnackbar(
                                message = throwable.message.orEmpty())
                        }
                    }
                }
            }
        }
    }
}
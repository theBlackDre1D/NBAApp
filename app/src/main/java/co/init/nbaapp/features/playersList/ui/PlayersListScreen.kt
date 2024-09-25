package co.init.nbaapp.features.playersList.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import co.init.nbaapp.extensions.navigateToPath
import co.init.nbaapp.navigation.AppNavigation

@Composable
fun PlayersListScreen(
    viewModel: PlayersVM,
    navController: NavHostController
) {
    val state = viewModel.state.collectAsState()
    val listState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        items(state.value.players.getOrNull().orEmpty()) { player ->
            PlayerItem(player) {
                viewModel.pickedPlayer = it
                navController.navigateToPath(AppNavigation.PlayerDetail)
            }
        }

        item {
            LaunchedEffect(listState) {
                viewModel.getPlayers()
            }
        }

        item {
            if (state.value.loading) {
                CircularProgressIndicator(
                    modifier = Modifier.wrapContentSize()
                )
            }
        }
    }
}
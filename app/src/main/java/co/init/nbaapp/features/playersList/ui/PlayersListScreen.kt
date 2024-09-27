package co.init.nbaapp.features.playersList.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import co.init.nbaapp.extensions.navigateToPath
import co.init.nbaapp.navigation.MainActivityNavigation

@Composable
fun PlayersListScreen(
    sharedVM: PlayersVM,
    navController: NavHostController
) {
    val state = sharedVM.state.collectAsState()

    Column {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            itemsIndexed(state.value.players) { index, player ->
                PlayerItem(player) {
                    sharedVM.pickedPlayer = it
                    navController.navigateToPath(MainActivityNavigation.PlayerDetail)
                }

                if (index == state.value.players.size - 1 && !state.value.loading) {
                    sharedVM.getPlayers()
                }
            }

            if (state.value.loading) {
                item {
                    CircularProgressIndicator(
                        modifier = Modifier.wrapContentSize()
                    )
                }
            }
        }
    }
}
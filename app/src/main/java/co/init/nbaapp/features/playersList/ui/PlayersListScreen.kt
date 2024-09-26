package co.init.nbaapp.features.playersList.ui

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import co.init.nbaapp.extensions.navigateToPath
import co.init.nbaapp.navigation.AppNavigation

@Composable
fun PlayersListScreen(
    sharedVM: PlayersVM,
    navController: NavHostController
) {
    val state = sharedVM.state.collectAsState()
    val error = sharedVM.error.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        itemsIndexed(state.value.players) { index, player ->
            PlayerItem(player) {
                sharedVM.pickedPlayer = it
                navController.navigateToPath(AppNavigation.PlayerDetail)
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

    error.value?.let {
        Toast.makeText(LocalContext.current, it.message, Toast.LENGTH_LONG).show()
        sharedVM.clearError()
    }
}
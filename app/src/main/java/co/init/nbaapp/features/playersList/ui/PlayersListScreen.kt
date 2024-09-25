package co.init.nbaapp.features.playersList.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PlayersListScreen() {
    val viewModel: PlayersListVM = hiltViewModel()
    val state = viewModel.state

    LazyRow(
        modifier = Modifier.fillMaxSize()
    ) {

    }
}
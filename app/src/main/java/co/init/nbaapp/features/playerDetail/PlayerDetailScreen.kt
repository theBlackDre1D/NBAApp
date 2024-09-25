package co.init.nbaapp.features.playerDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import co.init.nbaapp.features.playersList.ui.PlayersVM

@Composable
fun PlayerDetailScreen(
    sharedVM: PlayersVM
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(sharedVM.pickedPlayer?.fullName.orEmpty())
    }
}
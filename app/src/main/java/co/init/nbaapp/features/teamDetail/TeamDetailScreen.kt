package co.init.nbaapp.features.teamDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import co.init.nbaapp.features.playersList.ui.PlayersVM

@Composable
fun TeamDetailScreen(
    sharedVM: PlayersVM
) {

    Column {
        Text(text = "Full name: ${sharedVM.pickedTeam?.fullName}")
        Text(text = "Conference: ${sharedVM.pickedTeam?.conference}")
        Text(text = "Division: ${sharedVM.pickedTeam?.division}")
        Text(text = "City: ${sharedVM.pickedTeam?.city}")
        Text(text = "Name: ${sharedVM.pickedTeam?.name}")
        Text(text = "Abbreviation: ${sharedVM.pickedTeam?.abbreviation}")
    }
}
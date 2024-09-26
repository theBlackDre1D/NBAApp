package co.init.nbaapp.features.playerDetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import co.init.nbaapp.extensions.navigateToPath
import co.init.nbaapp.features.playersList.ui.PlayersVM
import co.init.nbaapp.navigation.MainActivityNavigation

@Composable
fun PlayerDetailScreen(
    sharedVM: PlayersVM,
    navController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Text(text = "Full name: ${sharedVM.pickedPlayer?.fullName.orEmpty()}")
        Text(text = "Position: ${sharedVM.pickedPlayer?.position}")
        Text(text = "Height: ${sharedVM.pickedPlayer?.height}")
        Text(text = "Weight: ${sharedVM.pickedPlayer?.weight}")
        Text(text = "Jersey number: ${sharedVM.pickedPlayer?.jerseyNumber}")
        Text(text = "College: ${sharedVM.pickedPlayer?.college}")
        Text(text = "Country: ${sharedVM.pickedPlayer?.country}")
        Text(text = "Draft year: ${sharedVM.pickedPlayer?.draftYear}")
        Text(text = "Draft round: ${sharedVM.pickedPlayer?.draftRound}")
        Text(text = "Draft number: ${sharedVM.pickedPlayer?.draftNumber}")
        Text(
            modifier = Modifier.clickable {
                navController.navigateToPath(MainActivityNavigation.ClubDetail)
            },
            text = "Team: ${sharedVM.pickedPlayer?.team?.fullName}"
        )
    }
}
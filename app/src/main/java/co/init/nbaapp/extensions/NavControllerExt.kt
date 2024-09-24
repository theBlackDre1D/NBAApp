package co.init.nbaapp.extensions

import androidx.navigation.NavController
import co.init.nbaapp.navigation.Path

fun NavController.navigateToPath(path: Path) {
    this.navigate(path.path)
}
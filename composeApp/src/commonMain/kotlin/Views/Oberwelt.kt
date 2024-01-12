package Views

import LevelButton
import Models.Level
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun Oberwelt(
    listOfLevels : List<Level>,
    navigator : Navigator
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row (modifier = Modifier.padding(10.dp)) {
            Text(
                "OBERWELT",
                Modifier.background(color = Color.Red).padding(10.dp)
            )
        }

        Row(modifier = Modifier) {
            for (i in 0..<listOfLevels.size / 2) {
                LevelButton(listOfLevels[i].location, level = listOfLevels[i]) {
                    navigator.navigate("/${listOfLevels[i].location.toString().lowercase()}")
                    // Muss später persistent gespeichert werden!
                    // Sonst resettet der Fortschritt bei jedem Neustart
                    listOfLevels[i].discovered = true
                    // ACHTUNG das hier muss später geändert werden
                    // Darf erst getoggelt werden wenn das Level komplett durchgespielt wurde
                    listOfLevels[i].cleared = true
                }
            }
        }

        Row(modifier = Modifier) {
            for (i in listOfLevels.size / 2..<listOfLevels.size) {
                LevelButton(listOfLevels[i].location, level = listOfLevels[i]) {
                    navigator.navigate("/${listOfLevels[i].location.toString().lowercase()}")
                    listOfLevels[i].discovered = true
                    // ACHTUNG das hier muss später geändert werden
                    // Darf erst getoggelt werden wenn das Level komplett durchgespielt wurde
                    listOfLevels[i].cleared = true
                }
            }
        }
    }
}
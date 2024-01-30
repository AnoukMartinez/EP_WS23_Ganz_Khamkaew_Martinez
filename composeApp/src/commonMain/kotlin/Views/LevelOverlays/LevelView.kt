package Views.LevelOverlays

import LocationBackground
import Models.Level
import Views.LevelOverlays.DialogueOverlay
import Views.LevelOverlays.SettingsOverlay
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun LevelView(navigator: Navigator, level : Level) {
    var currentRoomIndex by remember { mutableStateOf(0) }

    // val dialogueIsActive by remember { mutableStateOf(true) }
    val dialogueIsActive by remember { mutableStateOf(false) }

    LocationBackground(level.location, dialogueIsActive, currentRoomIndex)
    InspectionOverlay(
        level.location,
        {
            if(currentRoomIndex > 0) {
                currentRoomIndex--
            }
        },
        {
            if(currentRoomIndex < level.location.getRoomList().size - 1) {
                currentRoomIndex++
            }
        },
        currentRoomIndex
    )

    // DialogueOverlay(navigator, level)
    SettingsOverlay(navigator, level)
}
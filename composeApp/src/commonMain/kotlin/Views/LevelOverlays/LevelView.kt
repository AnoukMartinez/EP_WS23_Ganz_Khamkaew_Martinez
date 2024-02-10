package Views.LevelOverlays

import LocationBackground
import Models.Level
import Models.ScriptType
import Views.LevelOverlays.DialogueOverlay
import Views.LevelOverlays.SettingsOverlay
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import moe.tlaster.precompose.navigation.Navigator

enum class GameSituation {
    GREETINGDIALOGUE,
    TASKEXPLANATION,
    INSPECTIONMODE,
    LOOKHEREDIALOGUE,
    FEEDBACK
}

@Composable
fun LevelView(navigator: Navigator, level : Level) {
    var currentRoomIndex by remember { mutableStateOf(0) } // In welchem Raum sind wir?
    val dialogueIsActive by remember { mutableStateOf(false) } // Hintergrund blurry?
    val currentSituation by remember { mutableStateOf(GameSituation.INSPECTIONMODE) } // Wichtig für später

    LocationBackground(level.location, dialogueIsActive, currentRoomIndex)

    when(currentSituation) {
        GameSituation.GREETINGDIALOGUE -> DialogueOverlay(level.scripts[0])
        GameSituation.TASKEXPLANATION -> DialogueOverlay(level.scripts[1])
        GameSituation.INSPECTIONMODE -> {
            InspectionOverlay(
                level.location,
                { if(currentRoomIndex > 0) {currentRoomIndex--} },
                { if(currentRoomIndex < level.location.getRoomList().size - 1) {currentRoomIndex++} },
                currentRoomIndex
            )
        }
        GameSituation.LOOKHEREDIALOGUE -> DialogueOverlay(level.scripts[4]) // NICHT DER RICHTIGE WERT
        GameSituation.FEEDBACK -> DialogueOverlay(level.scripts[2])
    }

    val currentHelpContent = when(currentSituation) {
        GameSituation.GREETINGDIALOGUE -> level.helpContents.first { it.situation == GameSituation.GREETINGDIALOGUE }
        GameSituation.TASKEXPLANATION -> level.helpContents.first { it.situation == GameSituation.TASKEXPLANATION }
        GameSituation.INSPECTIONMODE -> level.helpContents.first { it.situation == GameSituation.INSPECTIONMODE }
        GameSituation.LOOKHEREDIALOGUE -> level.helpContents.first { it.situation == GameSituation.LOOKHEREDIALOGUE }
        GameSituation.FEEDBACK -> level.helpContents.first { it.situation == GameSituation.FEEDBACK }
    }

    SettingsOverlay(navigator, level, currentRoomIndex, currentHelpContent)
}
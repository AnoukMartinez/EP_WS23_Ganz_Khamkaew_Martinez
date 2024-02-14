package Views.LevelOverlays

import LocationBackground
import Models.Level
import Models.ScriptType
import Views.LevelOverlays.DialogueOverlay
import Views.LevelOverlays.SettingsOverlay
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Dialog
import moe.tlaster.precompose.navigation.Navigator

enum class GameSituation {
    GREETINGDIALOGUE,
    TASKEXPLANATION,
    TASKVIEW,
    INSPECTIONMODE,
    LOOKHEREDIALOGUE,
    FEEDBACK
}

@Composable
fun LevelView(navigator: Navigator, level : Level, levelStateManager : LevelStateManager) {

    var currentRoomIndex by remember { mutableStateOf(0) }
    var dialogueIsActive by remember { mutableStateOf(true) }
    var currentSituation by remember { mutableStateOf(GameSituation.GREETINGDIALOGUE) }
    var currentLookHere by remember { mutableStateOf(0) }

    if (currentSituation != GameSituation.TASKEXPLANATION && currentSituation != GameSituation.TASKVIEW) {
        LocationBackground(level.location, dialogueIsActive, currentRoomIndex)
    }

    when(currentSituation) {
        GameSituation.GREETINGDIALOGUE -> DialogueOverlay(level.scripts.first{ it.scriptType == ScriptType.GREETING }) {
            currentSituation = GameSituation.TASKEXPLANATION
        }

        GameSituation.TASKEXPLANATION -> {
            TestTaskView(navigator) { currentSituation = GameSituation.INSPECTIONMODE }
            // Könnte crashen wenn ein Level noch kein Help Script/Task hat
            // Mach ich später noch aber ist momentan keine Priorität
            DialogueOverlay(level.scripts.first{ it.scriptType == ScriptType.TASKEXPLANATION }) {
                currentSituation = GameSituation.TASKVIEW
                dialogueIsActive = false
            }
        }

        GameSituation.TASKVIEW -> {
            TestTaskView(navigator) { currentSituation = GameSituation.INSPECTIONMODE }
        }

        GameSituation.INSPECTIONMODE -> {
            dialogueIsActive = false
            InspectionOverlay(
                level.location,
                { if(currentRoomIndex > 0) {currentRoomIndex--} },
                { if(currentRoomIndex < level.location.getRoomList().size - 1) { currentRoomIndex++ } },
                currentRoomIndex,
                currentRoomIndex
            )
        }

        GameSituation.LOOKHEREDIALOGUE -> DialogueOverlay(level.scripts[4]) {
            currentSituation = GameSituation.INSPECTIONMODE
        }

        GameSituation.FEEDBACK -> DialogueOverlay(level.scripts[2]) {
            // Noch nichts tun, hab das Feedback noch nicht implementiert
        }
    }

    val currentHelpContent = level.helpContents.first { it.situation == levelStateManager.currentSituation }
    SettingsOverlay(navigator, level, levelStateManager.currentRoomIndex, currentHelpContent)
}

// EXTREM WIP NICHT BENUTZEN, KANN SPÄTER NOCH MIT STATE MANAGER VERFEINERN
@Composable
fun LevelView2(navigator: Navigator, level : Level, levelStateManager : LevelStateManager) {
    /*
    var currentRoomIndexby remember { mutableStateOf(0) }
    val dialogueIsActive by remember { mutableStateOf(true) }
    val currentSituation by remember { mutableStateOf(levelStateManager.currentSituation) }
    val currentLookHere by remember { mutableStateOf(levelStateManager.currentLookHere) }
    */

    val currentRoomIndex by remember { mutableStateOf(levelStateManager.currentRoomIndex) }
    val dialogueIsActive by remember { mutableStateOf(levelStateManager.dialogueIsActive) }
    val currentSituation by remember { mutableStateOf(levelStateManager.currentSituation) }
    val currentLookHere by remember { mutableStateOf(levelStateManager.currentLookHere) }

    LocationBackground(level.location, levelStateManager.dialogueIsActive, levelStateManager.currentRoomIndex)

    when(currentSituation) {
        GameSituation.GREETINGDIALOGUE -> DialogueOverlay(level.scripts.first{ it.scriptType == ScriptType.GREETING }) {
            levelStateManager.currentSituation = GameSituation.TASKEXPLANATION
        }

        GameSituation.TASKEXPLANATION -> DialogueOverlay(level.scripts.first{ it.scriptType == ScriptType.TASKEXPLANATION}) {
            levelStateManager.currentSituation = GameSituation.TASKVIEW
            levelStateManager.dialogueIsActive = false
        }

        GameSituation.TASKVIEW -> {
            TestTaskView(navigator) { levelStateManager.currentSituation = GameSituation.INSPECTIONMODE }
        }

        GameSituation.INSPECTIONMODE -> {
            levelStateManager.dialogueIsActive = false
            InspectionOverlay(
                level.location,
                { if(levelStateManager.currentRoomIndex > 0) {levelStateManager.currentRoomIndex--} },
                { if(levelStateManager.currentRoomIndex < level.location.getRoomList().size - 1) {levelStateManager.currentRoomIndex++} },
                // levelStateManager
                currentRoomIndex,
                currentLookHere
            )
        }

        GameSituation.LOOKHEREDIALOGUE -> DialogueOverlay(level.scripts[4]) {
            levelStateManager.currentSituation = GameSituation.INSPECTIONMODE
        }

        GameSituation.FEEDBACK -> DialogueOverlay(level.scripts[2]) {
            // Noch nichts tun, hab das Feedback noch nicht implementiert
        }
    }

    val currentHelpContent = level.helpContents.first { it.situation == levelStateManager.currentSituation }

    SettingsOverlay(navigator, level, levelStateManager.currentRoomIndex, currentHelpContent)
}
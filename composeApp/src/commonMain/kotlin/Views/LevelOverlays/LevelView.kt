package Views.LevelOverlays

import LocationBackground
import Models.Level
import Models.ScriptType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import moe.tlaster.precompose.navigation.Navigator

enum class GameSituation {
    GREETINGDIALOGUE,
    TASKEXPLANATION,
    TASKVIEW,
    INSPECTIONMODE,
    LOOKHEREDIALOGUE,
    POSITIVEFEEDBACK,
    NEGATIVEFEEDBACK
}

@Composable
fun LevelView(navigator: Navigator, level : Level, levelStateManager : LevelStateManager) {
    var numberOfTries by remember { mutableStateOf(0) }

    var currentRoomIndex by remember { mutableStateOf(0) }
    var dialogueIsActive by remember { mutableStateOf(true) }
    var currentSituation by remember { mutableStateOf(GameSituation.GREETINGDIALOGUE) }

    if (currentSituation != GameSituation.TASKEXPLANATION && currentSituation != GameSituation.TASKVIEW) {
        LocationBackground(level.location, dialogueIsActive, currentRoomIndex)
    }

    when(currentSituation) {
        GameSituation.GREETINGDIALOGUE -> DialogueOverlay(level.scripts.first{ it.scriptType == ScriptType.GREETING }) {
            currentSituation = GameSituation.TASKEXPLANATION
        }

        GameSituation.TASKEXPLANATION -> {
            TestTaskView(
                { currentSituation = GameSituation.INSPECTIONMODE },
                { currentSituation = GameSituation.POSITIVEFEEDBACK },
                {
                    numberOfTries++
                    currentSituation = GameSituation.NEGATIVEFEEDBACK
                },
                numberOfTries
            )

            DialogueOverlay(level.scripts.first{ it.scriptType == ScriptType.TASKEXPLANATION }) {
                currentSituation = GameSituation.TASKVIEW
                dialogueIsActive = false
            }
        }

        GameSituation.TASKVIEW -> {
            TestTaskView(
                { currentSituation = GameSituation.INSPECTIONMODE },
                { currentSituation = GameSituation.POSITIVEFEEDBACK },
                {
                    numberOfTries++
                    currentSituation = GameSituation.NEGATIVEFEEDBACK
                },
                numberOfTries
            )
        }

        GameSituation.INSPECTIONMODE -> {
            dialogueIsActive = false
            InspectionOverlay(
                level.location,
                { if(currentRoomIndex > 0) {currentRoomIndex--} },
                { if(currentRoomIndex < level.location.getRoomList().size - 1) { currentRoomIndex++ } },
                currentRoomIndex,
                levelStateManager,
                { currentSituation = GameSituation.LOOKHEREDIALOGUE },
                { currentSituation = GameSituation.TASKVIEW }
            )
        }

        GameSituation.LOOKHEREDIALOGUE -> {
            val onlyLookHereScripts = level.scripts.filter{it.scriptType == ScriptType.LOOKHERE }
            DialogueOverlay(onlyLookHereScripts[levelStateManager.currentLookHere]) {
                currentSituation = GameSituation.INSPECTIONMODE
            }
        }

        GameSituation.POSITIVEFEEDBACK -> {
            DialogueOverlay(level.scripts.first{ it.scriptType == ScriptType.POSITIVEFEEDBACK}) {
                navigator.navigate("/worldmap")
            }
        }

        GameSituation.NEGATIVEFEEDBACK -> {
            DialogueOverlay(level.scripts.first{ it.scriptType == ScriptType.NEGATIVEFEEDBACK}) {
                currentSituation = GameSituation.TASKVIEW
            }
        }
    }

    val currentHelpContent = level.helpContents.first { it.situation == currentSituation }
    SettingsOverlay(navigator, level, levelStateManager.currentRoomIndex, currentHelpContent)
}
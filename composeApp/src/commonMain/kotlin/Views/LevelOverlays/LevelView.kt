package Views.LevelOverlays

import LocationBackground
import Models.Level
import Views.LevelOverlays.DialogueOverlay
import Views.LevelOverlays.SettingsOverlay
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun LevelView(navigator: Navigator, level : Level) {
    val dialogueIsActive by remember { mutableStateOf(true) }

    LocationBackground(level.location, dialogueIsActive)
    DialogueOverlay(navigator, level)
    SettingsOverlay(navigator, level)
}
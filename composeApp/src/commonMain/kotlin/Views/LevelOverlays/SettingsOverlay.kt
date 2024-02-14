package Views.LevelOverlays

import Models.HelpContent
import Models.Level
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun SettingsOverlay(navigator: Navigator, level : Level, currentRoomIndex : Int, helpContent : HelpContent) {
    var isHelpOverlayVisible by remember { mutableStateOf(false) }
    val rooms = level.location.getRoomList()

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // Icon Bar oben mit Location Titel
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navigator.navigate("/worldmap") }) {
                Icon(Icons.Filled.Home, contentDescription = "Back To Worldview")
            }

            Text(
                modifier = Modifier,
                text = rooms[currentRoomIndex].getRoomToString(),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            IconButton(onClick = { isHelpOverlayVisible = true }) {
                Icon(Icons.Filled.Info, contentDescription = "Aufgabenerklärung")
            }

            if (isHelpOverlayVisible) {
                HelpOverlay(
                    onConfirm = { isHelpOverlayVisible = false },
                    helpContent.title,
                    helpContent.content
                )
            }
        }
    }
}
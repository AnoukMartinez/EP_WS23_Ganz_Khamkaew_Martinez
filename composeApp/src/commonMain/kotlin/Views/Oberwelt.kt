package Views

import LookHereImage
import Models.Level
import Models.levels
import Views.LevelOverlays.HelpOverlay
import WorldMapImage
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun Oberwelt(
    navigator : Navigator
) {
    var isHelpOverlayVisible by remember { mutableStateOf(false) }
    WorldMapImage()
    Column (
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navigator.navigate("/studenthome") }) {
                Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "Back to Home")
            }

            Text(
                modifier = Modifier,
                text = "Oberwelt",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            IconButton(onClick = { isHelpOverlayVisible = true }) {
                Icon(Icons.Filled.Info, contentDescription = "Aufgabenerklärung")
            }

            if (isHelpOverlayVisible) {
                HelpOverlay(
                    onConfirm = { isHelpOverlayVisible = false },
                    "Was kann ich hier tun?",
                    "Du befindest dich in der Worldmap. Klicke auf ein Label um den Ort zu besuchen."
                )
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Box (modifier = Modifier.offset(160.dp, 75.dp)){
            Row (modifier = Modifier, horizontalArrangement = Arrangement.Start) {
                TextButton({ navigator.navigate("/level/OMASHAUS") }, modifier = Modifier){
                    Text(modifier = Modifier, text = "Oma", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }

                if(!levels[1].discovered) {
                    LookHereImage()
                } else if(!levels[1].cleared) {
                    Icon(modifier = Modifier.size(30.dp).clip(CircleShape).background(Color.Red), imageVector = Icons.Filled.Clear, contentDescription = "Not Clear")
                } else {
                    Icon(modifier = Modifier.size(30.dp).clip(CircleShape).background(Color.Green), imageVector = Icons.Filled.Clear, contentDescription = "Cleared")
                }
            }
        }

        Box (modifier = Modifier.offset(75.dp, 430.dp)) {
            Row {
                TextButton({ navigator.navigate("/level/JUSTINSHAUS") }, modifier = Modifier){
                    Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally){
                        Text(modifier = Modifier, text = "Nach", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                        Text(modifier = Modifier, text = "Hause", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    }
                }

                if(!levels[3].discovered) {
                    LookHereImage()
                } else if(!levels[3].cleared) {
                    Icon(modifier = Modifier.size(30.dp).clip(CircleShape).background(Color.Red), imageVector = Icons.Filled.Clear, contentDescription = "Not Clear")
                } else {
                    Icon(modifier = Modifier.size(30.dp).clip(CircleShape).background(Color.Green), imageVector = Icons.Filled.Clear, contentDescription = "Cleared")
                }
            }
        }

        Box (modifier = Modifier.offset(755.dp, 115.dp)) {
            Row {
                TextButton({ navigator.navigate("/level/KEVINSHAUS") }, modifier = Modifier){
                    Text(modifier = Modifier, text = "Kevin", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }

                if(!levels[0].discovered) {
                    LookHereImage()
                } else if(!levels[0].cleared) {
                    Icon(modifier = Modifier.size(30.dp).clip(CircleShape).background(Color.Red), imageVector = Icons.Filled.Clear, contentDescription = "Not Clear")
                } else {
                    Icon(modifier = Modifier.size(30.dp).clip(CircleShape).background(Color.Green), imageVector = Icons.Filled.Clear, contentDescription = "Cleared")
                }
            }
        }

        Box (modifier = Modifier.offset(905.dp, 505.dp)) {
            Row {
                TextButton({ navigator.navigate("/level/SCHULE") }, modifier = Modifier){
                    Text(modifier = Modifier, text = "Schule", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }

                if(!levels[2].discovered) {
                    LookHereImage()
                } else if(!levels[2].cleared) {
                    Icon(modifier = Modifier.size(30.dp).clip(CircleShape).background(Color.Red), imageVector = Icons.Filled.Clear, contentDescription = "Not Clear")
                } else {
                    Icon(modifier = Modifier.size(30.dp).clip(CircleShape).background(Color.Green), imageVector = Icons.Filled.Clear, contentDescription = "Cleared")
                }
            }
        }
    }
}
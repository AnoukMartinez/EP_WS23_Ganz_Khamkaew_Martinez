package Views.LevelOverlays

import Location
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun InspectionOverlay(location : Location, onMoveLeft : () -> Unit, onMoveRight : () -> Unit, currentRoomIndex : Int) {
    Row (
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            if(currentRoomIndex != 0) {
                IconButton(onClick = { onMoveLeft() }) {
                    Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "Left")
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            if(currentRoomIndex < location.getRoomList().size - 1) {
                IconButton(onClick = { onMoveRight() }) {
                    Icon(Icons.Filled.KeyboardArrowRight, contentDescription = "Right")
                }
            }
        }
    }
}
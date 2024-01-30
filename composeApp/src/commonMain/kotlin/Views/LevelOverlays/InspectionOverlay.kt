package Views.LevelOverlays

import Location
import LookHereImage
import Models.Script
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp


@Composable
fun InspectionOverlay(location : Location, onMoveLeft : () -> Unit, onMoveRight : () -> Unit, currentRoomIndex : Int) {
    val rooms = location.getRoomList()
    val lookheres = rooms[currentRoomIndex].getRoomLookHeres()

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

    Box (
        modifier = Modifier.fillMaxSize()
    ) {
        for(lookhere in lookheres) {
            LookHereButton(lookhere)
        }
    }
}

@Composable
fun LookHereButton(lookhere : LookHere) {
    Button (
        onClick = { /* Dialogue Overlay wird mit dem entsprechendem Skript aufgerufen (TODO) */ },
        elevation = null,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        modifier = Modifier
            .offset(lookhere.x, lookhere.y)
    ) {
        LookHereImage()
    }
}

data class LookHere(val x : Dp, val y : Dp, val id : Int)
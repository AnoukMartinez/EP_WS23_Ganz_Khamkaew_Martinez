package Views.LevelOverlays

import Location
import LookHereImage
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class LookHere(val x : Dp, val y : Dp, val id : Int)

@Composable
fun InspectionOverlay(
    location : Location,
    onMoveLeft : () -> Unit,
    onMoveRight : () -> Unit,
    currentRoomIndex : Int,
    levelStateManager : LevelStateManager,
    onTest : () -> Unit,
    onFirstLookHere : () -> Unit
) {
    val rooms = location.getRoomList()
    val lookHeres = rooms[currentRoomIndex].getRoomLookHeres()

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            if (currentRoomIndex != 0) {
                IconButton(onClick = { onMoveLeft() }) {
                    Icon(modifier = Modifier.size(50.dp), imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "Left")
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            if (currentRoomIndex < location.getRoomList().size - 1) {
                IconButton(onClick = { onMoveRight() }) {
                    Icon(modifier = Modifier.size(50.dp), imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "Right")
                }
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        for (lookHere in lookHeres) {
            val currentId = lookHere.id

            Button(
                onClick = {
                    println("LOOKHERE with ID $currentId got called")
                    levelStateManager.currentLookHere = currentId
                    if(currentId == 0){
                        onFirstLookHere()
                    } else {
                        onTest()
                    }
                },
                elevation = null,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent
                ),
                modifier = Modifier
                    .offset(lookHere.x, lookHere.y)
            ) {
                LookHereImage()
            }
        }
    }
}
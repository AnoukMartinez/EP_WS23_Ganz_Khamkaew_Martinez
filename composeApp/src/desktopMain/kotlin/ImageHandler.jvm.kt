import Models.DialogueLine
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import Models.GameCharacter
import Models.Mood
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.unit.dp

@Composable
actual fun LocationBackground(location : Location, dialogueIsActive : Boolean, currentRoomIndex : Int){
    val rooms = location.getRoomList()

    var blurIntensity = 0.dp
    if(dialogueIsActive) {
        blurIntensity = 5.dp
    }

    Image(
        painterResource(rooms[currentRoomIndex].getDesktopPath()),
        modifier = Modifier
            .fillMaxSize()
            .blur(
                radiusX = blurIntensity,
                radiusY = blurIntensity
            ),
        contentDescription = location.toString()
    )
}

@Composable
actual fun CharacterSprite(character : GameCharacter, mood : Mood, isActive : Boolean){
    var filter = 1f
    if(!isActive) {
        filter = 0f
    }
    Image(
        painterResource("${character.toString().lowercase()}${mood.toString().lowercase()}.png"),
        modifier = Modifier,
        contentDescription = "$character$mood",
        colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(filter) })
    )
}

@Composable
actual fun LookHereImage() {
    Image (
        painterResource("lookhere.png"),
        modifier = Modifier,
        contentDescription = "Look Here Button"
    )
}
import Models.DialogueLine
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import Models.GameCharacter
import Models.Mood
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
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
        contentDescription = location.toString(),
        contentScale = ContentScale.Crop,
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

@Composable
actual fun DesktopBackground() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painterResource("desktopbackground.png"),
            modifier = Modifier,
            contentDescription = "Windows XP Background",
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
actual fun DesktopProfilePicture(){
    Image(
        painterResource("kevinhappy.png"),
        contentDescription = "Kevin Profilbild",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
            .background(Color.White)
    )
}

@Composable
actual fun WorldMapImage(){
    Image(
        painterResource("worldmap.png"),
        contentDescription = "Oberwelt Hintergrund",
        contentScale = ContentScale.Crop
    )
}
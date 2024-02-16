import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import org.example.project.R
import Models.GameCharacter
import Models.Mood
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
        painterResource(getResourceFromRoom(rooms[currentRoomIndex])),
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

fun getResourceFromLocation(location : Location) : Int {
    return when(location){
        Location.OMASHAUS -> R.drawable.omakueche
        Location.KEVINSHAUS -> R.drawable.kevinszimmer
        Location.SCHULE -> R.drawable.schulflur
        Location.JUSTINSHAUS -> R.drawable.justinzimmer
        else -> throw Exception("Location not implemented yet")
    }
}

fun getResourceFromRoom(room : Room) : Int {
    return when(room) {
        Room.KEVINSZIMMER -> R.drawable.kevinszimmer
        Room.RIASZIMMER -> R.drawable.riaszimmer
        Room.JUSTINFLUR -> R.drawable.justinflur
        Room.JUSTINZIMMER -> R.drawable.justinzimmer
        Room.JUSTINKUECHE -> R.drawable.justinkueche
        Room.OMAKUECHE -> R.drawable.omakueche
        Room.OMAWOHNZIMMER -> R.drawable.omawohnzimmer
        Room.SCHULFLUR -> R.drawable.schulflur
        Room.SCHULLABOR -> R.drawable.schullabor
        else -> throw Exception("Room not implemented yet")
    }
}

@Composable
actual fun CharacterSprite(character : GameCharacter, mood : Mood, isActive : Boolean) {
    var filter = 1f
    if(!isActive) {
        filter = 0f
    }
    Image(
        painterResource(getResourceFromSprite(character, mood)),
        modifier = Modifier,
        contentDescription = "$character$mood",
        colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(filter) })
    )
}

fun getResourceFromSprite(character : GameCharacter, mood : Mood) : Int {
    return when(character){
        GameCharacter.KEVIN -> when(mood) {
            Mood.NEUTRAL -> R.drawable.kevinneutral
            Mood.HAPPY -> R.drawable.kevinhappy
            Mood.ANGRY -> R.drawable.kevinangry
            Mood.SAD -> R.drawable.kevinsad
            else -> throw Exception("Character doesnt have that mood yet")
        }
        GameCharacter.OMA -> when(mood) {
            Mood.NEUTRAL -> R.drawable.omaneutral
            Mood.HAPPY -> R.drawable.omahappy
            Mood.ANGRY -> R.drawable.omaangry
            Mood.SAD -> R.drawable.omasad
            else -> throw Exception("Character doesnt have that mood yet")
        }

        GameCharacter.JUSTIN -> when(mood) {
            Mood.NEUTRAL -> R.drawable.justinneutral
            Mood.HAPPY -> R.drawable.justinhappy
            Mood.ANGRY -> R.drawable.justinangry
            Mood.SAD -> R.drawable.justinsad
            else -> throw Exception("Character doesnt have that mood yet")
        }
        else -> throw Exception("Character does not exist yet")
    }
}

@Composable
actual fun LookHereImage() {
    Image (
        painterResource(R.drawable.lookhere),
        modifier = Modifier,
        contentDescription = "Look Here Button"
    )
}

@Composable
actual fun DesktopBackground() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image (
            painterResource(R.drawable.desktopbackground),
            modifier = Modifier,
            contentDescription = "Windows XP Background",
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
actual fun DesktopProfilePicture() {
    Image(
        painter = painterResource(id = R.drawable.kevinhappy),
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
        painterResource(R.drawable.worldmap),
        contentDescription = "Oberwelt Hintergrund",
        contentScale = ContentScale.Crop
    )
}
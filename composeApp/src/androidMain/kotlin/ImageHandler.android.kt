import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import org.example.project.R
import Models.GameCharacter
import Models.Mood
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix

@Composable
actual fun LocationBackground(location : Location){
    Image(
        painterResource(getResourceFromLocation(location)),
        modifier = Modifier.fillMaxSize(),
        contentDescription = location.toString()
    )
}

fun getResourceFromLocation(location : Location) : Int {
    return when(location){
        Location.OMASHAUS -> R.drawable.omashaus
        Location.KEVINSHAUS -> R.drawable.kevinshaus
        Location.SCHULE -> R.drawable.schule
        Location.JUSTINSHAUS -> R.drawable.justinshaus
        else -> throw Exception("Location not implemented yet")
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
        modifier = Modifier.fillMaxSize(),
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
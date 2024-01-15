import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import Models.GameCharacter
import Models.Mood
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix

@Composable
actual fun LocationBackground(location : Location){
    Image(
        painterResource(location.getDesktopPath()),
        modifier = Modifier.fillMaxSize(),
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
import Models.GameCharacter
import Models.Mood
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun LocationBackground(location : Location)

@Composable
expect fun CharacterSprite(character : GameCharacter, mood : Mood, isActive : Boolean)
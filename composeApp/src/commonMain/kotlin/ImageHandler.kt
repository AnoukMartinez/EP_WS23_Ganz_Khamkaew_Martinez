import Models.GameCharacter
import Models.Mood
import androidx.compose.runtime.Composable
@Composable
expect fun LocationBackground(location : Location)

@Composable
expect fun CharacterSprite(character : GameCharacter, mood : Mood, isActive : Boolean)
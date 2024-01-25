import Models.GameCharacter
import Models.Mood
import androidx.compose.runtime.Composable
@Composable
expect fun LocationBackground(location : Location, dialogueIsActive : Boolean)

@Composable
expect fun CharacterSprite(character : GameCharacter, mood : Mood, isActive : Boolean)
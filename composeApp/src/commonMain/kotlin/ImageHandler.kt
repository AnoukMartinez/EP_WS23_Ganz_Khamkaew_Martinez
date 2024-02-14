import Models.GameCharacter
import Models.Mood
import androidx.compose.runtime.Composable
@Composable
expect fun LocationBackground(location : Location, dialogueIsActive : Boolean, currentRoomIndex : Int)

@Composable
expect fun CharacterSprite(character : GameCharacter, mood : Mood, isActive : Boolean)

@Composable
expect fun LookHereImage()

@Composable
expect fun DesktopBackground()

@Composable
expect fun DesktopProfilePicture()
import Models.Level
import androidx.compose.runtime.Composable

public enum class Location {
    OMA,
    KEVIN,
    SCHULE,
    JUSTIN;

    fun getDesktopPath() : String {
        return this.toString().lowercase() + ".png";
    }
}

@Composable
expect fun LevelButton(location: Location, level :  Level, onClick: () -> Unit)
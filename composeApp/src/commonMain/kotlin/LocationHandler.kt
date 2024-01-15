import Models.Level
import androidx.compose.runtime.Composable

public enum class Location {
    OMASHAUS,
    KEVINSHAUS,
    SCHULE,
    JUSTINSHAUS;

    fun getDesktopPath() : String {
        return this.toString().lowercase() + ".png";
    }

    fun getLocationToString() : String {
        return when(this) {
            OMASHAUS -> "Oma's Haus"
            KEVINSHAUS -> "Kevin's Haus"
            SCHULE -> "Schule"
            JUSTINSHAUS -> "Justin's Zuhause"
        }
    }
}

@Composable
expect fun LevelButton(location: Location, level :  Level, onClick: () -> Unit)
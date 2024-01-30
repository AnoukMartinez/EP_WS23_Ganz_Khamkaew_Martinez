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

    fun getRoomList() : List<Room> {
        return when(this) {
            KEVINSHAUS -> listOf(Room.KEVINSZIMMER, Room.RIASZIMMER)
            OMASHAUS -> listOf(Room.OMAKUECHE, Room.OMAWOHNZIMMER)
            JUSTINSHAUS -> listOf(Room.JUSTINFLUR, Room.JUSTINKUECHE, Room.JUSTINZIMMER)
            SCHULE -> listOf(Room.SCHULFLUR, Room.SCHULLABOR)
            else -> throw Exception("Location noch nicht fertig")
        }
    }
}

public enum class Room {
    KEVINSZIMMER,
    RIASZIMMER,
    OMAKUECHE,
    OMAWOHNZIMMER,
    JUSTINFLUR,
    JUSTINKUECHE,
    JUSTINZIMMER,
    SCHULFLUR,
    SCHULLABOR;

    fun getDesktopPath() : String {
        return this.toString().lowercase() + ".png";
    }

    fun getRoomToString() : String {
        return when(this) {
            KEVINSZIMMER -> "Kevin's Zimmer"
            RIASZIMMER -> "Ria's Zimmer"
            OMAKUECHE -> "Oma's Küche"
            OMAWOHNZIMMER -> "Oma's Wohnzimmer"
            JUSTINFLUR -> "Justin's Flur"
            JUSTINKUECHE -> "Justin's Küche"
            JUSTINZIMMER -> "Justin's Zimmer"
            SCHULFLUR -> "Schule Flur"
            SCHULLABOR -> "Computerraum"
            else -> throw Exception("Location noch nicht fertig")
        }
    }
}

@Composable
expect fun LevelButton(location: Location, level :  Level, onClick: () -> Unit)
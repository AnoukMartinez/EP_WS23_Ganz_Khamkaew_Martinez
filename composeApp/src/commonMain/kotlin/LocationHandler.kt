import Models.Level
import Views.LevelOverlays.LookHere
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

enum class Location {
    OMASHAUS,
    KEVINSHAUS,
    SCHULE,
    JUSTINSHAUS;

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
        }
    }
}

enum class Room {
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
        return this.toString().lowercase() + ".png"
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
        }
    }

    fun getRoomLookHeres() : List<LookHere> {
        return when(this) {
            KEVINSZIMMER -> listOf(
                LookHere(350.dp, 140.dp, 0),
                LookHere(900.dp, 100.dp, 1)
            )
            RIASZIMMER -> listOf(
                LookHere(350.dp, 550.dp, 2),
                LookHere(1050.dp, 340.dp, 3),
                LookHere(320.dp, 280.dp, 4),
                LookHere(300.dp, 100.dp, 5)
            )
            OMAKUECHE -> listOf()
            OMAWOHNZIMMER -> listOf()
            JUSTINFLUR -> listOf()
            JUSTINKUECHE -> listOf()
            JUSTINZIMMER -> listOf()
            SCHULFLUR -> listOf()
            SCHULLABOR -> listOf()
        }
    }
}
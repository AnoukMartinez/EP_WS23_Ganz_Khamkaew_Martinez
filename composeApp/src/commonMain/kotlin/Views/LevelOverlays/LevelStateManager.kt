package Views.LevelOverlays

class LevelStateManager(
    var currentRoomIndex : Int = 0,
    var dialogueIsActive : Boolean = true,
    var currentSituation : GameSituation = GameSituation.GREETINGDIALOGUE,
    var currentLookHere : Int = 0
)
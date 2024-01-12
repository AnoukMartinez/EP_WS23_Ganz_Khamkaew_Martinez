package Models

import Location

// WORK IN PROGRESS...
// Vielleicht kann man hier eine Datei mit dem Script durchlaufen?
class Script(val test : DialogueLine) {
    fun getDialogue() {
        // WORK IN PROGRESS...
    }
}

class DialogueLine(val testline : String) {

}

data class Level (
    val location : Location,
    var discovered : Boolean = false,
    var cleared : Boolean = false,
    var script : Script
)

var kevinTestLine = DialogueLine("Oh hey Justin, wie geht's? Ich spiele gerade Fortnite...")
var omaTestLine = DialogueLine("Hallo Justin! Willst du ein paar selbstgemachte Kekse?")
var schuleTestLine = DialogueLine("Hey Mann, du hast doch in Informatik aufgepasst, oder?")
var justinTestLine = DialogueLine("Home Sweet Home... Zeit selber nach Hinweisen zu suchen.")

var kevinScript = Script(kevinTestLine)
var omaScript = Script(omaTestLine)
var schuleScript = Script(schuleTestLine)
var justinScript = Script(justinTestLine)

var kevin = Level(Location.KEVIN, script = kevinScript)
var oma = Level(Location.OMA, script = omaScript)
var schule = Level(Location.SCHULE, script = schuleScript)
var justin = Level(Location.JUSTIN, script = justinScript)

val levels = listOf(kevin, oma, schule, justin)
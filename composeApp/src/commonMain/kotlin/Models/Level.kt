package Models

import Location
import Models.Scripts.justinScript
import Models.Scripts.kevinScript
import Models.Scripts.omaScript
import Models.Scripts.schuleScript
data class Level (
    val location : Location,
    var discovered : Boolean = false,
    var cleared : Boolean = false,
    var script : Script
)

var levels = mutableListOf<Level>()

// ganz grausiger code bitte nochmal drübergehen wenn wir zeit haben aua aua
suspend fun buildScripts() : MutableList<Level> {
    val levels = mutableListOf<Level>()

    var kevinProcessedScript : Script
    var omaProcessedScript : Script
    var schuleProcessedScript : Script
    var justinProcessedScript : Script

    try {
        kevinProcessedScript = buildScript(getLocationScriptFromServer(Location.KEVINSHAUS))
        omaProcessedScript = buildScript(getLocationScriptFromServer(Location.OMASHAUS))
        schuleProcessedScript = buildScript(getLocationScriptFromServer(Location.SCHULE))
        justinProcessedScript = buildScript(getLocationScriptFromServer(Location.JUSTINSHAUS))

    } catch (e : Exception){
        // Wenn Server Verbindung fehlschlägt, nehme stattdessen die lokalen Scripts
        kevinProcessedScript = buildScript(kevinScript)
        omaProcessedScript = buildScript(omaScript)
        schuleProcessedScript = buildScript(schuleScript)
        justinProcessedScript = buildScript(justinScript)
    }

    val kevin = Level(Location.KEVINSHAUS, script = kevinProcessedScript)
    val oma = Level(Location.OMASHAUS, script = omaProcessedScript)
    val schule = Level(Location.SCHULE, script = schuleProcessedScript)
    val justin = Level(Location.JUSTINSHAUS, script = justinProcessedScript)

    levels.add(kevin)
    levels.add(oma)
    levels.add(schule)
    levels.add(justin)
    return levels
}

fun buildScriptsLocal() : MutableList<Level> {
    val kevin = Level(Location.KEVINSHAUS, script = buildScript(kevinScript))
    val oma = Level(Location.OMASHAUS, script = buildScript(omaScript))
    val schule = Level(Location.SCHULE, script = buildScript(schuleScript))
    val justin = Level(Location.JUSTINSHAUS, script = buildScript(justinScript))

    levels.add(kevin)
    levels.add(oma)
    levels.add(schule)
    levels.add(justin)
    return levels
}
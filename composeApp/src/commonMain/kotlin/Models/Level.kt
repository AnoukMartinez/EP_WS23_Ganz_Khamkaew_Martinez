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

var kevinProcessedScript = buildScript(kevinScript)
var omaProcessedScript = buildScript(omaScript)
var schuleProcessedScript = buildScript(schuleScript)
var justinProcessedScript = buildScript(justinScript)

var kevin = Level(Location.KEVINSHAUS, script = kevinProcessedScript)
var oma = Level(Location.OMASHAUS, script = omaProcessedScript)
var schule = Level(Location.SCHULE, script = schuleProcessedScript)
var justin = Level(Location.JUSTINSHAUS, script = justinProcessedScript)

val levels = listOf(kevin, oma, schule, justin)
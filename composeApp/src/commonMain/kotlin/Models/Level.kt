package Models

import Location
import Models.Scripts.justinScript
import Models.Scripts.kevinScript
import Models.Scripts.omaScript
import Models.Scripts.schuleScript
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.launch

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

// Funktioniert erst einmal nur auf mobile!
private val client = HttpClient()
suspend fun getLocationScriptFromServer(location : Location) : String {
    // Hier ip addresse von dem gerät wo der server drauf läuft :)
    val ip = "00.0.000.000:3000"
    val response = client.get("http://$ip/script/${location.toString().lowercase()}")
    return response.bodyAsText()
}
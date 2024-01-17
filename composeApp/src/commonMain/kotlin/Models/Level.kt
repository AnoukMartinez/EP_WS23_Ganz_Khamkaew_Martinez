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

var kevinProcessedScript = buildScript(kevinScript)
var omaProcessedScript = buildScript(omaScript)
var schuleProcessedScript = buildScript(schuleScript)
var justinProcessedScript = buildScript(justinScript)

var kevin = Level(Location.KEVINSHAUS, script = kevinProcessedScript)
var oma = Level(Location.OMASHAUS, script = omaProcessedScript)
var schule = Level(Location.SCHULE, script = schuleProcessedScript)
var justin = Level(Location.JUSTINSHAUS, script = justinProcessedScript)

val levels = listOf(kevin, oma, schule, justin)

// Funktioniert erst einmal nur auf mobile!
private val client = HttpClient()

suspend fun test() : String {
    // Hier IP Adresse von dem Gerät wo der Server drauf läuft
    // Habs erst mal wieder rausgenommen weil unser github repo public ist usw.
    val ip = "000.000.0.000"
    val response = client.get("http://$ip:3000/")
    return response.bodyAsText()
}
@Composable
fun httpTestScreen(){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val scope = rememberCoroutineScope()
        var text by remember { mutableStateOf("Loading") }
        LaunchedEffect(true) {
            scope.launch {
                text = try {
                    test()
                } catch (e: Exception) {
                    e.localizedMessage ?: "error"
                }
            }
        }
        Text(text)
    }
}

package Models
import Location
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.engine.java.*

private val client = HttpClient(Java)

actual suspend fun getLocationScriptFromServer(scriptName : String) : String {
    // Hier ip addresse von dem gerät wo der server drauf läuft :)
    val ip = "192.168.178.112:3000"
    val response = client.get("http://$ip/script/$scriptName")
    return response.bodyAsText()
}
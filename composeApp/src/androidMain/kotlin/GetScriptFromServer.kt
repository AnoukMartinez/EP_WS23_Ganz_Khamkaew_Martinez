package Models
import Location
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

private val client = HttpClient()

actual suspend fun getLocationScriptFromServer(scriptName : String) : String {
    // Hier ip addresse von dem gerät wo der server drauf läuft :)
    val ip = "000.000.000.000:3000"
    val response = client.get("http://$ip/script/$scriptName")
    return response.bodyAsText()
}
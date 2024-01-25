package Models
import Location
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

private val client = HttpClient()

actual suspend fun getLocationScriptFromServer(location : Location) : String {
    // Hier ip addresse von dem gerät wo der server drauf läuft :)
    val ip = "00.00.00.00:3000"
    val response = client.get("http://$ip/script/${location.toString().lowercase()}")
    return response.bodyAsText()
}
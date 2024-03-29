package Models
import Location
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.engine.java.*

private val client = HttpClient(Java)
val ip = "000.000.000.000:3000"

actual suspend fun getLocationScriptFromServer(scriptName : String) : String {
    val response = client.get("http://$ip/script/$scriptName")
    return response.bodyAsText()
}

actual suspend fun getClassListFromServer() : String {
    val response = client.get("http://$ip/classes")
    return response.bodyAsText()
}

actual suspend fun getStudentListFromServer() : String {
    val response = client.get("http://$ip/students")
    return response.bodyAsText()
}

actual suspend fun getTeacherListFromServer() : String {
    val response = client.get("http://$ip/teachers")
    return response.bodyAsText()
}
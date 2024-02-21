package Models
import Location

expect suspend fun getLocationScriptFromServer(scriptName : String) : String

expect suspend fun getClassListFromServer() : String

expect suspend fun getStudentListFromServer() : String

expect suspend fun getTeacherListFromServer() : String
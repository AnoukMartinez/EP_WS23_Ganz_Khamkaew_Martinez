package Models.Profiles

import Location
import Models.mapper
import com.fasterxml.jackson.module.kotlin.readValue

data class LevelProgress (
    val aufgabe : Location,
    val ersterscore : Int,
    val besterscore : Int,
    val fertig : Boolean
)

data class StudentProfile (
    val vorname : String,
    val nachname : String,
    val password : String,
    val email : String,
    val schule : String,
    val klasse : String,
    val progress : List<LevelProgress>
)

fun parseStudentList(rawStudentProfiles: String): List<StudentProfile> {
    return mapper.readValue<List<StudentProfile>>(rawStudentProfiles)
}

val processedStudentProfiles = parseStudentList(studentProfiles)
package Models.Profiles

import Location
import Models.mapper
import com.fasterxml.jackson.module.kotlin.readValue

// Reminder: Fertig sollte schon in den jeweiligen Levels getrackt werden (discovered/completed)
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

data class TeacherProfile (
    val vorname : String,
    val nachname : String,
    val password : String,
    val email : String,
    val schule : String,
    val klassen : List<String>
    // Liste der Klassen IDs, Klassen werden seperat gespeichert um Dopplungen zu vermeiden
)

fun parseStudentList(rawStudentProfiles: String): List<StudentProfile> {
    return mapper.readValue<List<StudentProfile>>(rawStudentProfiles)
}

fun parseTeacherList(rawTeacherProfiles: String): List<TeacherProfile> {
    return mapper.readValue<List<TeacherProfile>>(rawTeacherProfiles)
}

val processedStudentProfiles = parseStudentList(studentProfiles)
val processedTeacherProfiles = parseTeacherList(teacherProfiles)
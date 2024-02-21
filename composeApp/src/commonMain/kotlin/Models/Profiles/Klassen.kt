package Models.Profiles

import Models.mapper
import com.fasterxml.jackson.module.kotlin.readValue

data class Klasse(
    val id : String,
    val students : MutableList<StudentProfile>
)

val testclass1 = Klasse(
    "5a",
    mutableListOf (
        StudentProfile (
            vorname = "Jan",
            nachname = "Müller",
            password = "hi",
            email = "student",
            schule = "Test Gymnasium",
            klasse = "5a",
            progress = listOf (
                LevelProgress (
                    Location.OMASHAUS,
                    0,
                    0,
                    false
                ),
                LevelProgress (
                    Location.KEVINSHAUS,
                    0,
                    0,
                    false
                ),
                LevelProgress (
                    Location.SCHULE,
                    0,
                    0,
                    false
                ),
                LevelProgress (
                    Location.JUSTINSHAUS,
                    0,
                    0,
                    false
                )
            )
        ),
        StudentProfile (
            vorname = "Susi",
            nachname = "Mongus",
            password = "hi",
            email = "student2",
            schule = "Test Gymnasium",
            klasse = "5a",
            progress = listOf (
                LevelProgress (
                    Location.OMASHAUS,
                    5,
                    5,
                    true
                ),
                LevelProgress (
                    Location.KEVINSHAUS,
                    2,
                    5,
                    true
                ),
                LevelProgress (
                    Location.SCHULE,
                    5,
                    5,
                    true
                ),
                LevelProgress (
                    Location.JUSTINSHAUS,
                    5,
                    5,
                    true
                )
            )
        )
    )
)

val testclass2 = Klasse (
    "5b",
    mutableListOf(
        StudentProfile (
            vorname = "Frank",
            nachname = "Ozean",
            password = "hi",
            email = "student3",
            schule = "Test Gymnasium",
            klasse = "5b",
            progress = listOf (
            LevelProgress (
                Location.OMASHAUS,
                0,
                0,
                false
            ),
            LevelProgress (
                Location.KEVINSHAUS,
                0,
                0,
                false
            ),
            LevelProgress (
                Location.SCHULE,
                0,
                0,
                false
            ),
            LevelProgress (
                Location.JUSTINSHAUS,
                0,
                0,
                false
                )
            )
        )
    )
)

val testclass3 = Klasse("5c", mutableListOf())

val testclass4 = Klasse("6c", mutableListOf())
val testclass5 = Klasse("7a", mutableListOf())

val klassen = mutableListOf(testclass1, testclass2, testclass3, testclass4, testclass5, testclass5, testclass5)

fun buildClassList(rawClassData : String) : MutableList<Klasse> {
    return mapper.readValue(rawClassData)
}
package Models.Profiles

// Diese Variable sollte später noch von einer externen Datenbank gezogen werden
// und modifiziert werden, wenn eine verifizierte Lehrkraft eine neue Klasse hinzufügt
// val klassen = listOf("5a", "5b", "5c")

data class Klasse(val id : String, val students : MutableList<StudentProfile>)

val testclass1 = Klasse("5a", mutableListOf(processedStudentProfiles[0], processedStudentProfiles[1]))
val testclass2 = Klasse("5b", mutableListOf(processedStudentProfiles[2]))
val testclass3 = Klasse("5c", mutableListOf())

val testclass4 = Klasse("6c", mutableListOf())
val testclass5 = Klasse("7a", mutableListOf())

val klassen = listOf(testclass1, testclass2, testclass3, testclass4, testclass5, testclass5, testclass5)
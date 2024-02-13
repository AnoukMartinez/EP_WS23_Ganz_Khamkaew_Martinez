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

val klassen = mutableListOf(testclass1, testclass2, testclass3, testclass4, testclass5, testclass5, testclass5)

/*
// Ich denke es würde mehr Sinn machen, die Klassen als Map zu halten . Allerdings müsste ich dafür
// ein paar Sachen im Class Edit View ändern. so ist das erst mal nicht ganz so wichtig.
// Es würde aber einiges einfacher machen, z.B Aufruf der jeweiligen Klasse onClick.

val klassen2 = mutableMapOf<String, MutableList<StudentProfile>>()

klassen2["5a"] = mutableListOf(processedStudentProfiles[0], processedStudentProfiles[1])
klassen2["5b"] = mutableListOf(processedStudentProfiles[2])
klassen2["5c"] = mutableListOf()
klassen2["6c"] = mutableListOf()
klassen2["7a"] = mutableListOf()
*/
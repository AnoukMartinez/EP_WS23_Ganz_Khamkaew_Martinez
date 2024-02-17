package Models.Profiles
data class Klasse(
    val id : String,
    val students : MutableList<StudentProfile>
)

val testclass1 = Klasse("5a", mutableListOf(processedStudentProfiles[0], processedStudentProfiles[1]))
val testclass2 = Klasse("5b", mutableListOf(processedStudentProfiles[2]))
val testclass3 = Klasse("5c", mutableListOf())

val testclass4 = Klasse("6c", mutableListOf())
val testclass5 = Klasse("7a", mutableListOf())

val klassen = mutableListOf(testclass1, testclass2, testclass3, testclass4, testclass5, testclass5, testclass5)
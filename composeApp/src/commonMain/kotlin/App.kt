import Models.Profiles.StudentProfile
import Models.Profiles.klassen
import Models.Profiles.processedStudentProfiles
import Models.levels
import Views.ClassEditView
import Views.ClassProgressView
import Views.LevelOverlays.LevelView
import Views.LoginRegister.LoginScreen
import Views.Oberwelt
import Views.LoginRegister.RegisterChoice
import Views.StudentProgressView
import Views.LoginRegister.StudentRegisterScreen
import Views.LoginRegister.TeacherRegisterScreen
import Views.LevelOverlays.TestTaskView
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition

@Composable
fun App() {
    PreComposeApp {
        MaterialTheme {
            val navigator = rememberNavigator()
            NavHost (
                navigator = navigator,
                navTransition = NavTransition(),
                initialRoute = "/classedit",
            ) {
                // LOGIN SCREEN
                scene (
                    route = "/login",
                    navTransition = NavTransition(),
                ) {
                    LoginScreen(navigator)
                }

                // REGISTRIERUNGS SCREEN
                scene (
                    route = "/register",
                    navTransition = NavTransition(),
                ) {
                    RegisterChoice(navigator)
                }

                // STUDENT REGISTER
                scene (
                    route = "/studentregister",
                    navTransition = NavTransition()
                ) {
                    StudentRegisterScreen(navigator)
                }

                // TEACHER REGISTER
                scene (
                    route = "/teacherregister",
                    navTransition = NavTransition()
                ) {
                    TeacherRegisterScreen(navigator)
                }

                // HOME SCREEN SCHÜLERINNEN
                scene (
                    route = "/studenthome",
                    navTransition = NavTransition(),
                ) {
                    StudentHomeScreen(navigator)
                }
                // HOME SCREEN LEHRERINNEN
                scene (
                    route = "/teacherhome",
                    navTransition = NavTransition(),
                ) {
                    TeacherHomeScreen(navigator)
                }

                // OBERWELT
                scene (
                    route = "/worldmap",
                    navTransition = NavTransition(),
                ) {
                    Oberwelt(levels, navigator)
                }

                // LEVEL AUFRUF
                scene (
                    route = "/level/{locationname}",
                    navTransition = NavTransition()
                ) { backStackEntry ->
                    val locationname : String? = backStackEntry.path<String>("locationname")
                    val queriedLevel = levels.first { it.location.toString() == locationname}
                    LevelView(navigator, queriedLevel)
                }

                // TEST TASK (Kommt später wieder weg)
                scene (
                    route = "/testtask",
                    navTransition = NavTransition()
                ) {
                    TestTaskView(navigator)
                }

                // LOADING SCREEN FÜR SCRIPTS
                scene(
                    route = "/gameloadingscreen",
                    navTransition = NavTransition()
                ) {
                    GameLoadingScreen(navigator)
                }

                scene(
                    route = "/classedit",
                    navTransition = NavTransition()
                ){
                    ClassEditView(navigator)
                }

                scene(
                    route = "/classprogress/{classid}",
                    navTransition = NavTransition()
                ) { backStackEntry ->
                    val classid : String? = backStackEntry.path<String>("classid")
                    ClassProgressView(classid, navigator)
                }

                scene (
                    route = "/studentprogress/{studentmail}",
                    navTransition = NavTransition()
                ) { backStackEntry ->
                    val studentmail : String? = backStackEntry.path<String>("studentmail")
                    val queriedProfile = processedStudentProfiles.first { it.email == studentmail }
                    StudentProgressView(queriedProfile, navigator)
                }
            }
        }
    }
}
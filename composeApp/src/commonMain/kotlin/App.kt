import Models.Profiles.processedStudentProfiles
import Models.levels
import Views.ClassEditView
import Views.ClassProgressView
import Views.LevelOverlays.LevelStateManager
import Views.LevelOverlays.LevelView
import Views.LoginRegister.LoginScreen
import Views.Oberwelt
import Views.LoginRegister.RegisterChoice
import Views.StudentProgressView
import Views.LoginRegister.StudentRegisterScreen
import Views.LoginRegister.TeacherRegisterScreen
import Views.LevelOverlays.TestTaskView
import Views.LoginRegister.currentProfileMail
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
            val levelStateManager = LevelStateManager()
            val navigator = rememberNavigator()
            NavHost (
                navigator = navigator,
                navTransition = NavTransition(),
                initialRoute = "/login",
            ) {
                scene (
                    route = "/login",
                    navTransition = NavTransition(),
                ) {
                    LoginScreen(navigator)
                }

                scene (
                    route = "/register",
                    navTransition = NavTransition(),
                ) {
                    RegisterChoice(navigator)
                }

                scene (
                    route = "/studentregister",
                    navTransition = NavTransition()
                ) {
                    StudentRegisterScreen(navigator)
                }

                scene (
                    route = "/teacherregister",
                    navTransition = NavTransition()
                ) {
                    TeacherRegisterScreen(navigator)
                }

                scene (
                    route = "/studenthome",
                    navTransition = NavTransition(),
                ) {
                    StudentHomeScreen(navigator)
                }

                scene (
                    route = "/teacherhome",
                    navTransition = NavTransition(),
                ) {
                    TeacherHomeScreen(navigator)
                }

                scene (
                    route = "/worldmap",
                    navTransition = NavTransition(),
                ) {
                    Oberwelt(navigator)
                }

                scene (
                    route = "/level/{locationname}",
                    navTransition = NavTransition()
                ) { backStackEntry ->
                    val locationname : String? = backStackEntry.path<String>("locationname")
                    val queriedLevel = levels.first { it.location.toString() == locationname}
                    queriedLevel.discovered = true
                    LevelView(navigator, queriedLevel, levelStateManager)
                }

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
                    // Ich schätze die Schüler Mail sollte eindeutig genug sein
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
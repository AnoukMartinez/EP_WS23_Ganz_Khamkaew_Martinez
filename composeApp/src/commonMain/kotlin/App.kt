import Models.levels
import Views.LevelView
import Views.Oberwelt
import Views.RegisterScreen
import Views.TestTaskView
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
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
                initialRoute = "/register",
            ) {
                // LOGIN SCREEN
                scene (
                    route = "/login",
                    navTransition = NavTransition(),
                ) {
                    // TODO!!!
                }

                // REGISTRIERUNGS SCREEN
                scene (
                    route = "/register",
                    navTransition = NavTransition(),
                ) {
                    RegisterScreen(navigator)
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

                // KEVINS HAUS
                scene (
                    route = "/kevinshaus",
                    navTransition = NavTransition(),
                ) {
                    LevelView(navigator, levels.first { it.location == Location.KEVINSHAUS })
                }

                // OMAS HAUS
                scene (
                    route = "/omashaus",
                    navTransition = NavTransition(),
                ) {
                    LevelView(navigator, levels.first { it.location == Location.OMASHAUS })
                }

                // SCHULE
                scene (
                    route = "/schule",
                    navTransition = NavTransition(),
                ) {
                    LevelView(navigator, levels.first { it.location == Location.SCHULE })
                }

                // JUSTIN
                scene (
                    route = "/justinshaus",
                    navTransition = NavTransition(),
                ) {
                    LevelView(navigator, levels.first { it.location == Location.JUSTINSHAUS })
                }

                scene (
                    route = "/testtask",
                    navTransition = NavTransition()
                ) {
                    TestTaskView(navigator)
                }

                scene(
                    route = "/gameloadingscreen",
                    navTransition = NavTransition()
                ) {
                    GameLoadingScreen(navigator)
                }
            }
        }
    }
}
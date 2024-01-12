import Models.justin
import Models.kevin
import Models.levels
import Models.oma
import Models.schule
import Views.LevelView
import Views.Oberwelt
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
                initialRoute = "/home",
            ) {
                // HOME SCREEN
                scene (
                    route = "/home",
                    navTransition = NavTransition(),
                ) {
                    HomeScreen(navigator)
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
                    route = "/kevin",
                    navTransition = NavTransition(),
                ) {
                    LevelView(navigator, kevin)
                }

                // OMAS HAUS
                scene (
                    route = "/oma",
                    navTransition = NavTransition(),
                ) {
                    LevelView(navigator, oma)
                }

                // SCHULE
                scene (
                    route = "/schule",
                    navTransition = NavTransition(),
                ) {
                    LevelView(navigator, schule)
                }

                // JUSTIN
                scene (
                    route = "/justin",
                    navTransition = NavTransition(),
                ) {
                    LevelView(navigator, justin)
                }
            }
        }
    }
}
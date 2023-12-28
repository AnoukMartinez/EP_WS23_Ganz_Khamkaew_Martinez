import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import callImage

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KidSecure") {
        App()
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}

@Composable
actual fun callImage(location : Location){
    Image(
        painterResource("${location.toString().lowercase()}.png"),
        modifier = Modifier.fillMaxSize(),
        contentDescription = location.toString()
    )
}
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
actual fun LocationImage(location : Location){
    Image(
        painterResource(location.getDesktopPath()),
        modifier = Modifier.fillMaxSize(),
        contentDescription = location.toString()
    )
}


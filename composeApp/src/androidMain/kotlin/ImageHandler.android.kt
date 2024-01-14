import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import org.example.project.R

@Composable
actual fun LocationBackground(location : Location){
    Image(
        painterResource(getResourceFromLocation(location)),
        modifier = Modifier.fillMaxSize(),
        contentDescription = location.toString()
    )
}

fun getResourceFromLocation(location : Location) : Int {
    return when(location){
        Location.OMASHAUS -> R.drawable.omashaus
        Location.KEVINSHAUS -> R.drawable.kevinshaus
        Location.SCHULE -> R.drawable.schule
        Location.JUSTINSHAUS -> R.drawable.justinshaus
        else -> throw Exception("Location not implemented yet")
    }
}
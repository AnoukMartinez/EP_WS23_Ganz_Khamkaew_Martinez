import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import org.example.project.R

@Composable
actual fun LocationImage(location : Location){
    Image(
        painterResource(getResourceFromLocation(location)),
        modifier = Modifier.fillMaxSize(),
        contentDescription = location.toString()
    )
}

fun getResourceFromLocation(location : Location) : Int {
    return when(location){
        Location.OMA -> R.drawable.oma
        Location.KEVIN -> R.drawable.kevin
        Location.SCHULE -> R.drawable.schule
        Location.JUSTIN -> R.drawable.justin
        else -> throw Exception("Location not implemented yet")
    }
}
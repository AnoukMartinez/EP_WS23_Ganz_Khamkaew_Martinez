
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mvvm.views.KevinsHaus
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@Composable
fun App() {



    MaterialTheme {
        var currentLocation by remember { mutableStateOf<Location?>(null) }

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

           /* locationButton("OMA") { currentLocation = Location.OMA }
            locationButton("KEVIN") { currentLocation = Location.KEVIN }
            locationButton("SCHULE") { currentLocation = Location.SCHULE }*/

            //HomeScreen(onClickPlay = {})

            //Oberwelt()
            KevinsHaus()

            currentLocation?.let { location ->
                locationTest(location)
            }
        }
    }
}
data class Welt(val name: String)

@Composable
fun LocationInfo(level:Welt) {
    Text(text = level.name, fontSize = 24.sp,
        modifier = Modifier
            .padding(10.dp)
    )

}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LevelButton(name:String, onClick:()-> Unit) {
    Column(modifier = Modifier.wrapContentSize(Alignment.Center)) {
        Image(
            painterResource("haus1.png"), null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
        )
        TextButton(
            onClick = { onClick() })
        {
            Text(name)
        }
    }
}


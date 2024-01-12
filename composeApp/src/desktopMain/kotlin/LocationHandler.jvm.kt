import Models.Level
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
actual fun LevelButton(location: Location, level: Level, onClick: () -> Unit) {
    var discoveredColor = Color.Red
    var discoveredIcon = Icons.Default.Clear

    if(level.discovered) {
        discoveredColor = Color.Green
        discoveredIcon = Icons.Default.Check
    }

    Row {
        Icon(
            imageVector = discoveredIcon,
            "Discovered",
            modifier = Modifier
                .size(15.dp)
                .background(color = discoveredColor)
        )

        if(level.cleared) {
            Image(
                painterResource("cleared.png"), "Wenn komplett bearbeitet",
                modifier = Modifier
                    .size(15.dp)
            )
        }
    }

    Column(modifier = Modifier.wrapContentSize(Alignment.Center)) {
        Image (
            painterResource("haus1.png"), "Haus der jeweiligen Location",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
        )
        TextButton (
            onClick = { onClick() }
        )
        {
            Text(location.toString())
        }
    }
}
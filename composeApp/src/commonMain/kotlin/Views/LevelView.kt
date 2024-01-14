package Views

import LocationBackground
import Models.Level
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.navigation.Navigator
import org.jetbrains.compose.resources.painterResource

@Composable
fun LevelView(navigator: Navigator, level : Level) {
    var isHelpOverlayVisible by remember { mutableStateOf(false) }

    Box (
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // Wird später zu Image Sequence mit Script usw.
        LocationBackground(level.location)

        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { navigator.goBack() }) {
                Icon(Icons.Filled.Home, contentDescription = "Back To Worldview")
            }
            IconButton(onClick = { isHelpOverlayVisible = true }) {
                Icon(Icons.Filled.Info, contentDescription = "Aufgabenerklärung")
            }

            if (isHelpOverlayVisible) {
                HelpOverlay(onConfirm = { isHelpOverlayVisible = false })
            }
        }
    }
}

@Composable
fun TestTaskView(){
    Box (
        modifier = Modifier
            .fillMaxWidth()
    ) {
        var text by remember { mutableStateOf("") }

        Row() {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Eingabe Test") }
            )
            Button(
                onClick = {
                    if(text == "Hello World") {
                        println("It works")
                    } else {
                        println("Wrong input")
                    }
                },
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(text = "Login")
            }
        }
    }
}

@Composable
fun TestTaskButton(onClick : () -> Unit){
    Column(modifier = Modifier.wrapContentSize(Alignment.Center)) {
        TextButton (
            onClick = { onClick() }
        )
        {
            Text("Test Task")
        }
    }
}
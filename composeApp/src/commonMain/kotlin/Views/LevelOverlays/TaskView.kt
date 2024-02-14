package Views.LevelOverlays

import DesktopBackground
import DesktopProfilePicture
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun LoginTaskView() {
    Box (
        modifier = Modifier
            .fillMaxWidth()
    ) {
        var text by remember { mutableStateOf("") }
        var submitted by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField (
                modifier = Modifier.padding(20.dp),
                value = text,
                onValueChange = {
                    if(!submitted) { text = it }
                },
                label = { Text("Eingabe Test") }
            )

            Button(
                onClick = { submitted = true },
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(text = "Lösung Prüfen")
            }

            if(submitted) {
                Box(modifier = Modifier.padding(10.dp)) {
                    if(text == "Hello World") {
                        Text("Die Eingabe war richtig")
                    } else {
                        Text("Leider nicht. Die richtige Eingabe wäre gewesen: Hello World. " +
                                "[Hier eine Erklärung]. Weil in der Info stand man sollte das so machen.")
                    }
                }
            }
        }
    }
}

@Composable
fun EmailTaskView() {
    // TODO
}

@Composable
fun CrosswordTaskView() {
    // TODO
}

@Composable
fun TestTaskView(navigator : Navigator, onMove : () -> Unit){
    Box (modifier = Modifier.fillMaxWidth()) {
        DesktopBackground()
        Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
            IconButton(onClick = { onMove() }) {
                Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "Left")
            }
        }

        Column(modifier = Modifier.fillMaxHeight()){
            var text by remember { mutableStateOf("") }
            var submitted by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                DesktopProfilePicture()

                Text(text = "kevin123", fontSize = 24.sp, modifier = Modifier.padding(10.dp))

                Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                    TextField (
                        modifier = Modifier,
                        // modifier = Modifier.padding(20.dp),
                        value = text,
                        onValueChange = {
                            if(!submitted) {
                                text = it
                            }
                        },
                        label = { Text("Kennwort") }
                    )

                    Button(
                        modifier = Modifier.height(50.dp).width(50.dp),
                        onClick = {
                            submitted = true
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                    ) {
                        Icon(
                            Icons.Filled.KeyboardArrowRight,
                            "Submit",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }


                Column(modifier = Modifier.padding(10.dp)){
                    Text("Hinweis: süßundgelb22")

                    if(submitted){
                        if(text == "Hello World") {
                            Text("Die Eingabe war richtig")
                        } else {
                            Text("Das Passwort ist falsch. Bitte noch einmal versuchen.")
                        }
                    }
                }
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
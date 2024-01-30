package Views.LevelOverlays

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun TestTaskView(navigator : Navigator){
    var isHelpOverlayVisible by remember { mutableStateOf(false) }

    Box (
        modifier = Modifier
            .fillMaxWidth()
    ) {
        var text by remember { mutableStateOf("") }
        var submitted by remember { mutableStateOf(false) }

        // Icon Bar oben mit Location Titel
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navigator.goBack() }) {
                Icon(Icons.Filled.Home, contentDescription = "Back To Worldview")
            }

            IconButton(onClick = { isHelpOverlayVisible = true }) {
                Icon(Icons.Filled.Info, contentDescription = "Aufgabenerklärung")
            }

            if (isHelpOverlayVisible) {
                // Platzhalter!!
                val helperTitlePlaceholder = "Was jetzt?"
                val helperTextPlaceholder = "Bitte tippe folgendes ein: Hello World"
                HelpOverlay(
                    onConfirm = { isHelpOverlayVisible = false },
                    helperTitlePlaceholder,
                    helperTextPlaceholder
                )
            }
        }

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
                    if(!submitted) {
                        text = it
                    }
                },
                label = { Text("Eingabe Test") }
            )

            Button(
                onClick = {
                    submitted = true
                },
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
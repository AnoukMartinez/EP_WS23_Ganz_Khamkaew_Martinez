package Views

import CharacterSprite
import LocationBackground
import Models.GameCharacter
import Models.Level
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun LevelView(navigator: Navigator, level : Level) {
    var isHelpOverlayVisible by remember { mutableStateOf(false) }
    var scriptLineNumber by remember { mutableStateOf(1) }

    Box (
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // Wird später zu Image Sequence mit Script usw.
        LocationBackground(level.location)

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

            Text(
                text = level.location.getLocationToString(),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            IconButton(onClick = { isHelpOverlayVisible = true }) {
                Icon(Icons.Filled.Info, contentDescription = "Aufgabenerklärung")
            }

            if (isHelpOverlayVisible) {
                // Platzhalter!!
                val helperTitlePlaceholder = "Was soll ich jetzt machen?"
                val helperTextPlaceholder = "Im Moment befindest du dich noch im Story Modus. " +
                        "Das bedeutet du kannst einfach auf die Textbox unten klicken, um " +
                        "die Handlung voranzutreiben. Lies dir hierbei den Dialog " +
                        "genau durch, um Hinweise auf die Aufgabe zu erhalten die " +
                        "in jeder Welt drankommt."
                HelpOverlay(
                    onConfirm = { isHelpOverlayVisible = false },
                    helperTitlePlaceholder,
                    helperTextPlaceholder
                )
            }
        }


        Box (
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(70.dp)
                .align(Alignment.BottomCenter)
                .background(Color.White.copy(alpha = 0.8f))
                .clickable {
                    if(scriptLineNumber < level.script.getScriptSize()) {
                        scriptLineNumber++
                    }
                }
                .padding(24.dp),
        ) {
            Column (
                modifier = Modifier.fillMaxWidth(0.5f).align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(
                    text = level.script[scriptLineNumber - 1].speaker.toString() + ":",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                if(level.script[scriptLineNumber - 1].dialogueLine.isEmpty()){
                    FalseLoad(
                        "Das Skript wurde nicht richtig geladen.",
                        "Versuche deine App neu zu laden.",
                        "/home",
                        navigator
                    )
                } else {
                    Text(
                        text = level.script[scriptLineNumber - 1].dialogueLine,
                        fontSize = 20.sp,
                    )
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(Icons.Filled.KeyboardArrowDown, contentDescription = "Weiter")
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    val activeLine = level.script[scriptLineNumber - 1]

                    val speakers = listOf(
                        Triple (activeLine.speaker, activeLine.speakermood, true),
                        Triple (activeLine.listener, activeLine.listenermood, false)
                    )

                    val sortedSpeakers = speakers.sortedByDescending { it.first == GameCharacter.JUSTIN }

                    sortedSpeakers.forEach { (speaker, mood, isSpeakerActive) ->
                        if(speaker == GameCharacter.NOBODY) {
                            // DO nothing
                        } else {
                            CharacterSprite(speaker, mood, isSpeakerActive)
                        }
                    }
                }
            }
        }
    }
}

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
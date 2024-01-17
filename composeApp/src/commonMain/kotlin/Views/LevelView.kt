package Views

import CharacterSprite
import LocationBackground
import Models.GameCharacter
import Models.Level
import Models.Mood
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator
import org.jetbrains.compose.resources.painterResource

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
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            IconButton(onClick = { isHelpOverlayVisible = true }) {
                Icon(Icons.Filled.Info, contentDescription = "Aufgabenerklärung")
            }

            if (isHelpOverlayVisible) {
                HelpOverlay(onConfirm = { isHelpOverlayVisible = false })
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
                    text = level.script[scriptLineNumber - 1].speaker.toString() + " :",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = level.script[scriptLineNumber - 1].dialogueLine,
                    fontSize = 18.sp,
                )
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
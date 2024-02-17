package Views.LevelOverlays

import DesktopBackground
import DesktopProfilePicture
import Models.levels
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
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TestTaskView(onMove : () -> Unit, onFinishCorrect : () -> Unit, onFinishFalse : () -> Unit){
    Box (modifier = Modifier.fillMaxWidth()) {
        DesktopBackground()
        Row {
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                IconButton(onClick = { onMove() }) {
                    Icon(modifier = Modifier.size(50.dp), imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "Left")
                }
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

                Text(text = "kevin123", fontSize = 24.sp, modifier = Modifier.padding(10.dp), fontWeight = FontWeight.Bold)

                Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                    TextField (
                        modifier = Modifier,
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
                    Text(modifier = Modifier, text = "Hinweis: süßundgelb22", fontWeight = FontWeight.Bold)

                    if(submitted){
                        if(text == "teddy22") {
                            onFinishCorrect()
                            levels[0].cleared = true
                        } else {
                            onFinishFalse()
                        }
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
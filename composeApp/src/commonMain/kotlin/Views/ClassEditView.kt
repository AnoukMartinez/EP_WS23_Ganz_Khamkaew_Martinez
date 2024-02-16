package Views

import Models.Profiles.Klasse
import Models.Profiles.klassen
import Models.Profiles.processedTeacherProfiles
import Views.LoginRegister.currentProfileMail
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun ClassEditView(navigator : Navigator){
    var currentLastClass = 0
    var lastClassReached = false
    var isAddOverlayVisible by remember { mutableStateOf(false) }

    var classesToShow = processedTeacherProfiles.first{it.email == currentProfileMail}.klassen

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth().weight(0.1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { navigator.goBack() }) {
                Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "Back To Worldview")
            }
            Text(modifier = Modifier, text = "Klassen verwalten", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Info, contentDescription = "Placeholder for Spacer")
            }
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color(64, 95, 255))
            .weight(0.9f),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                for(i in 0..4){
                    if(currentLastClass < classesToShow.size){
                        val currentClassId = classesToShow[currentLastClass]
                        Column(modifier = Modifier
                            .padding(10.dp)
                            .clickable { navigator.navigate("/classprogress/${currentClassId}") }
                            .fillMaxSize()
                            .clip(shape = RoundedCornerShape(20.dp))
                            .background(Color.Black)
                            .weight(0.2f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = classesToShow[currentLastClass], fontSize = 50.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                        }
                        currentLastClass++
                    } else {
                        if(!lastClassReached){
                            Column(modifier = Modifier
                                .padding(10.dp)
                                .clip(shape = RoundedCornerShape(25.dp))
                                .background(Color.White)
                                .weight(0.2f)
                                .fillMaxHeight(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Column(modifier = Modifier
                                    .padding(10.dp)
                                    .clickable { isAddOverlayVisible = true }
                                    .fillMaxSize()
                                    .clip(shape = RoundedCornerShape(20.dp))
                                    .background(Color(255, 122, 0)),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(text = "+", fontSize = 50.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                                }
                            }
                            lastClassReached = true
                        } else {
                            Column(modifier = Modifier
                                .padding(10.dp)
                                .clip(shape = RoundedCornerShape(25.dp))
                                .background(Color.White)
                                .weight(0.2f)
                                .fillMaxHeight()
                            ) {
                                Text("")
                            }
                        }
                    }
                }
            }

            Row(modifier = Modifier.fillMaxWidth().weight(1f), horizontalArrangement = Arrangement.Center) {
                for(i in 0..4){
                    if(currentLastClass < classesToShow.size){
                        val currentClassId = classesToShow[currentLastClass]
                        Column(modifier = Modifier
                            .padding(10.dp)
                            .clickable { navigator.navigate("/classprogress/${currentClassId}") }
                            .fillMaxSize()
                            .clip(shape = RoundedCornerShape(20.dp))
                            .background(Color.Black)
                            .weight(0.2f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = classesToShow[currentLastClass], fontSize = 50.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                        }
                        currentLastClass++
                    } else {
                        if(!lastClassReached){
                            Column(modifier = Modifier
                                .padding(10.dp)
                                .clip(shape = RoundedCornerShape(25.dp))
                                .background(Color.White)
                                .weight(0.2f)
                                .fillMaxHeight(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Column(modifier = Modifier
                                    .padding(10.dp)
                                    .clickable { isAddOverlayVisible = true }
                                    .fillMaxSize()
                                    .clip(shape = RoundedCornerShape(20.dp))
                                    .background(Color(255, 122, 0)),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(text = "+", fontSize = 50.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                                }
                            }
                            lastClassReached = true
                        } else {
                            Box(modifier = Modifier
                                .padding(10.dp)
                                .clip(shape = RoundedCornerShape(25.dp))
                                .background(Color.White)
                                .weight(0.2f)
                                .fillMaxHeight()
                            ) {
                                Text("")
                            }
                        }
                    }
                }
            }

            Row(modifier = Modifier.fillMaxWidth().weight(1f), horizontalArrangement = Arrangement.Center) {
                for(i in 0..4){
                    if(currentLastClass < classesToShow.size){
                        val currentClassId = classesToShow[currentLastClass]
                        Column(modifier = Modifier
                            .padding(10.dp)
                            .clickable { navigator.navigate("/classprogress/${currentClassId}") }
                            .fillMaxSize()
                            .clip(shape = RoundedCornerShape(20.dp))
                            .background(Color.Black)
                            .weight(0.2f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = classesToShow[currentLastClass], fontSize = 50.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                        }
                        currentLastClass++
                    } else {
                        if(!lastClassReached){
                            Column(modifier = Modifier
                                .padding(10.dp)
                                .clip(shape = RoundedCornerShape(25.dp))
                                .background(Color.White)
                                .weight(0.2f)
                                .fillMaxHeight(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Column(modifier = Modifier
                                    .padding(10.dp)
                                    .clickable { isAddOverlayVisible = true }
                                    .fillMaxSize()
                                    .clip(shape = RoundedCornerShape(20.dp))
                                    .background(Color(255, 122, 0)),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(text = "+", fontSize = 50.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                                }
                            }
                            lastClassReached = true
                        } else {
                            Box(modifier = Modifier
                                .padding(10.dp)
                                .clip(shape = RoundedCornerShape(25.dp))
                                .background(Color.White)
                                .weight(0.2f)
                                .fillMaxHeight()
                            ) {
                                Text("")
                            }
                        }
                    }
                }
            }
        }
        if(isAddOverlayVisible){
            ClassAddOverlay { isAddOverlayVisible = false }
        }
    }
}

@Composable
fun ClassAddOverlay(onDismiss : () -> Unit) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(
                    text = "Bitte geben Sie einen Klassen Namen ein.",
                    textAlign = TextAlign.Center,
                )

                var text by remember { mutableStateOf("") }
                var submitted by remember { mutableStateOf(false) }

                TextField (
                    modifier = Modifier.padding(20.dp),
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Klassen Name") }
                )

                Button(onClick = { submitted = true }){
                    Text("Abschicken")
                }

                if(submitted) {
                    Box(modifier = Modifier.padding(10.dp)) {
                        if(text.isEmpty()) {
                            Text("Das Textfeld darf nicht leer sein.")
                        } else {
                            processedTeacherProfiles.first{it.email == currentProfileMail}.klassen.add(text)
                            klassen.add(Klasse(text, mutableListOf()))
                            onDismiss()
                        }
                    }
                }
            }
        }
    }
}
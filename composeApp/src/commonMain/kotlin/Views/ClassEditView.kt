package Views

import Models.Profiles.klassen
import Models.buildScriptsLocal
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun ClassEditView2(navigator: Navigator){

    Column {

        IconButton(onClick = { navigator.goBack() }) {
            Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "Back To Worldview")
        }

        for(klasse in klassen){
            Button(
                modifier = Modifier.padding(5.dp),
                onClick = {
                    buildScriptsLocal()
                    navigator.navigate("/classprogress/${klasse.id}")
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
            )

            {
                Text(
                    text = klasse.id,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            }
        }
    }
}

@Composable
fun ClassEditView(navigator : Navigator){
    var currentLastClass = 0
    var lastClassReached = false
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
                Icon(Icons.Filled.Settings, contentDescription = "Placeholder for Settings")
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
                    if(currentLastClass < klassen.size){
                        val currentClassId = klassen[currentLastClass].id
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
                            Text(text = klassen[currentLastClass].id, fontSize = 50.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
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
                                    .clickable {  }
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
                    if(currentLastClass < klassen.size){
                        val currentClassId = klassen[currentLastClass].id
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
                            Text(text = klassen[currentLastClass].id, fontSize = 50.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
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
                                    .clickable {  }
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
                    if(currentLastClass < klassen.size){
                        val currentClassId = klassen[currentLastClass].id
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
                            Text(text = klassen[currentLastClass].id, fontSize = 50.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
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
                                    .clickable {  }
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
    }
}
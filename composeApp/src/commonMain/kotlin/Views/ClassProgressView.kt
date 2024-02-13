package Views

import Models.Profiles.StudentProfile
import Models.Profiles.klassen
import Models.Profiles.processedStudentProfiles
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
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star
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
fun ClassProgressView2(classId : String?, navigator: Navigator){
    Column {
        IconButton(onClick = { navigator.goBack() }) {
            Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "Back To Worldview")
        }

        for(student in klassen.first{ it.id == classId }.students){
            if(student.klasse == classId){
                Button(
                    modifier = Modifier.padding(5.dp),
                    onClick = {
                        // WARUM IST DAS HIER ICH TRAU MICH NICHT DAS RAUSZUNEHMEN HILFE???
                        buildScriptsLocal()
                        navigator.navigate("/studentprogress/${student.email}")
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
                ) {
                    Text(
                        text = student.vorname + " " + student.nachname,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ClassProgressView(classId : String?, navigator : Navigator) {
    Box(modifier = Modifier.fillMaxSize().background(Color(64, 95, 255)))
    Column {
        val queriedClass = klassen.first{it.id == classId}

        // Title Bar mit Zurück Button und Titel
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { navigator.goBack() }) {
                Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "Back To Worldview")
            }

            // Student Titel
            if (classId != null) {
                Text(
                    text = classId,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            IconButton(onClick = {}) {
                Icon(Icons.Filled.Info, contentDescription = "Spacer")
            }
        }

        Row (modifier = Modifier, horizontalArrangement = Arrangement.SpaceAround) {
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(0.5f)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(modifier = Modifier.padding(10.dp), text = "Name", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(0.5f)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(modifier = Modifier.padding(10.dp), text = "Anmeldung", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(0.5f)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(modifier = Modifier.padding(10.dp), text = "Fortschritt", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(0.5f)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(modifier = Modifier.padding(10.dp), text = "Fertig", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }

        // Tabelle mit allen Statistiken
        Row (modifier = Modifier, horizontalArrangement = Arrangement.SpaceAround) {
            // Diese Columns könnten auch eigene Composables sein denke ich
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(0.5f)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .fillMaxHeight()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(5.dp))
                for(student in queriedClass.students){
                    Text (
                        modifier = Modifier
                            .padding(5.dp)
                            .clickable { navigator.navigate("/studentprogress/${student.email}") },
                        text = student.vorname + " " + student.nachname,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }

            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(0.5f)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .fillMaxHeight()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(5.dp))
                for(student in queriedClass.students){
                    // Platzhalter
                    Text(modifier = Modifier.padding(5.dp), text = "13.02.2024")
                }
            }

            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(0.5f)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .fillMaxHeight()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(5.dp))
                for(student in queriedClass.students){
                    var finishedTasks = 0
                    for(task in student.progress){
                        if(task.fertig){
                            finishedTasks++
                        }
                    }
                    Text(modifier = Modifier.padding(5.dp), text = "${finishedTasks}/${student.progress.size}")
                }
            }

            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(0.5f)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .fillMaxHeight()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(5.dp))
                for(student in queriedClass.students){
                    var finishedTasks = 0
                    for(task in student.progress){
                        if(task.fertig){
                            finishedTasks++
                        }
                    }
                    Row(modifier = Modifier.padding(5.dp)) {
                        if(finishedTasks == student.progress.size){
                            Icon(Icons.Filled.Star, "Fertig", tint = Color.Blue)
                        } else {
                            Icon(Icons.Filled.Star, "Fertig", tint = Color.LightGray)
                        }
                    }
                }
            }
        }
    }
}
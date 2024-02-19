package Views

import Models.Profiles.StudentProfile
import androidx.compose.foundation.background
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
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
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
fun StudentProgressView(student : StudentProfile, navigator : Navigator) {
    Box(modifier = Modifier.fillMaxSize().background(Color(64, 95, 255)))
    Column {
        // Title Bar mit Zurück Button und Titel
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { navigator.goBack() }) {
                Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "Back To Worldview")
            }

            // Student Titel
            Text(
                text = student.vorname + " " + student.nachname,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

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
                Text(modifier = Modifier.padding(10.dp), text = "Aufgabe", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(0.5f)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(modifier = Modifier.padding(10.dp), text = "Erster Score", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(0.5f)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(modifier = Modifier.padding(10.dp), text = "Bester Score", fontSize = 18.sp, fontWeight = FontWeight.Bold)
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
                for(level in student.progress) {
                    Text(modifier = Modifier.padding(5.dp), text = level.aufgabe.getLocationToString(), fontWeight = FontWeight.ExtraBold)
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
                for(level in student.progress) {
                    Text(modifier = Modifier.padding(5.dp), text = level.ersterscore.toString() + "/5")
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
                for(level in student.progress) {
                    Text(modifier = Modifier.padding(5.dp), text = level.besterscore.toString() + "/5")
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
                for(level in student.progress) {
                    Row(modifier = Modifier.padding(5.dp)) {
                        if (level.fertig) {
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
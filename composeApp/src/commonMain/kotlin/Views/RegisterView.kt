package Views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
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
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun RegisterChoice(navigator : Navigator) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier
                    .clickable { navigator.navigate("/studentregister") }
                    .size(300.dp, 400.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Color(64, 95, 255)),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Als Schüler*in Registrieren",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier
                    .clickable { navigator.navigate("/teacherregister") }
                    .size(300.dp, 400.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Color.LightGray),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Als Lehrkraft Registrieren",
                    color = Color(64, 95, 255),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun StudentRegisterScreen(navigator : Navigator) {
    Box (
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(20.dp).fillMaxSize(),
        ) {
            Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceEvenly) {
                InputField("Vorname")
                InputField("Nachname")
            }
            Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceEvenly) {
                InputField("Email")
                InputField("Passwort")
            }
            Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceEvenly) {
                InputField("Schule")
                InputField("Klasse")
            }
            Row() {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navigator.navigate("/studenthome")
                    }
                ) {
                    Text("LOGIN")
                }
            }
        }
    }
}

@Composable
fun TeacherRegisterScreen(navigator : Navigator) {
    Box (
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(20.dp).fillMaxSize(),
        ) {
            Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceEvenly) {
                InputField("Vorname")
                InputField("Nachname")
            }
            Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceEvenly) {
                InputField("Email")
                InputField("Passwort")
            }
            Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceEvenly) {
                InputField("Schule")
                InputField("Klasse")
            }
            Row() {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navigator.navigate("/teacherhome")
                    }
                ) {
                    Text("LOGIN")
                }
            }
        }
    }
}
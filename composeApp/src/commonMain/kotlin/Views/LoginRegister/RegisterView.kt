package Views.LoginRegister

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
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
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column (
                modifier = Modifier
                    .padding(40.dp)
                    .clickable { navigator.navigate("/studentregister") }
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Color(64, 95, 255))
                    .weight(0.5f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
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
                    .padding(40.dp)
                    .clickable { navigator.navigate("/teacherregister") }
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Color.LightGray)
                    .weight(0.5f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
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
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .width(580.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier.padding(0.dp, 30.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Row(modifier = Modifier) {
                    Text(
                        "Re",
                        style = TextStyle(
                            color = Color(64, 95, 255),
                            fontSize = 84.sp,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center
                        )
                    )
                    Text(
                        "gistrieren",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 84.sp,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center
                        )
                    )
                }

                Text(text = "Als Schüler*in", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                InputField("Vorname")
                InputField("Nachname")
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                InputField("Email")
                InputField("Passwort")
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                InputField("Schule")
                InputField("Klasse")
            }

            Column(modifier = Modifier.fillMaxWidth().padding(0.dp, 30.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navigator.navigate("/studenthome")
                    },
                    colors = ButtonDefaults.buttonColors(Color(64, 95, 255))
                ) {
                    Text("REGISTRIEREN")
                }

                TextButton (
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navigator.navigate("/login")
                    }
                ) {
                    Text("ZURÜCK ZUM LOGIN")
                }
            }
        }
    }
}

@Composable
fun TeacherRegisterScreen(navigator : Navigator) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .width(580.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier.padding(0.dp, 30.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Row(modifier = Modifier) {
                    Text(
                        "Re",
                        style = TextStyle(
                            color = Color(64, 95, 255),
                            fontSize = 84.sp,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center
                        )
                    )
                    Text(
                        "gistrieren",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 84.sp,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center
                        )
                    )
                }

                Text(text = "Als Lehrkraft", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            }


            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                InputField("Vorname")
                InputField("Nachname")
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                InputField("Email")
                InputField("Passwort")
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                InputField("Schule")
                InputField("Klasse")
            }

            Column(modifier = Modifier.fillMaxWidth().padding(0.dp, 30.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navigator.navigate("/teacherhome")
                    },
                    colors = ButtonDefaults.buttonColors(Color(64, 95, 255))
                ) {
                    Text("REGISTRIEREN")
                }

                TextButton (
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navigator.navigate("/login")
                    }
                ) {
                    Text("ZURÜCK ZUM LOGIN")
                }
            }
        }
    }
}
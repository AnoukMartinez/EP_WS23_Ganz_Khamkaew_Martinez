import Models.buildScripts
import Models.levels
import Views.FalseLoad
import Views.LoginRegister.currentProfileMail
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun StudentHomeScreen(navigator : Navigator) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TitleText()
        Row(
            modifier = Modifier
                .padding(50.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    modifier = Modifier.padding(5.dp).width(300.dp),
                    onClick = {
                        navigator.navigate("/gameloadingscreen")
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {
                    Text(
                        text = "SPIELEN",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                }

                Button(
                    modifier = Modifier.padding(5.dp).width(300.dp),
                    onClick = {
                        // PLATZHALTER
                        navigator.navigate("/studentprogress/$currentProfileMail")
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black))
                {
                    Text(
                        text = "FORTSCHRITT",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                }

                Button(
                    modifier = Modifier.padding(5.dp).width(300.dp),
                    onClick = {
                        currentProfileMail = ""
                        navigator.navigate("/login")
                    },
                    colors = ButtonDefaults.buttonColors(Color(64, 95, 255)))
                {
                    Text(
                        text = "LOGOUT",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                }
            }
        }
    }
}

@Composable
fun GameLoadingScreen(navigator : Navigator) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val scope = rememberCoroutineScope()
        var localScripts by remember { mutableStateOf(false) }

        LaunchedEffect(true) {
            scope.launch {
                levels = buildScripts()
                // Dieser Check ist nicht sehr gut und sollte später noch ersetzt werden.
                // Wir checken einfach ob das Skript das lokale ist, oder mit dem richtigem Satz anfängt.
                // Oh Gott ja der Check ist schrecklich aber ich hab den ganz vergessen oh nein
                if(levels[0].scripts[0][0].dialogueLine == "Hey Mann, wie geht's? Cool dass du nach der Schule vorbeischaust."){
                    localScripts = true
                } else {
                    navigator.navigate("/worldmap")
                }
            }
        }
        CircularProgressIndicator(
            modifier = Modifier.width(30.dp),
            color = Color.Blue,
            backgroundColor = Color.White,
        )

        Text(
            modifier = Modifier.padding(10.dp),
            text = "Lade Gespräche...",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )

        if(localScripts){
            Box {
                FalseLoad (
                    "Es konnte keine Verbindung zum Server aufgebaut werden. " +
                            "Das bedeutet deine Skripts sind möglicherweise veraltet.",
                    "Du kannst versuchen die App neu zu laden, oder mit alten Dialogen spielen.",
                    "/worldmap",
                    navigator
                )
            }
        }
    }
}

@Composable
fun TitleText() {
    Row {
        Text(
            "Kid",
            style = TextStyle(
                color = Color(64, 95, 255),
                fontSize = 84.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )
        )

        Text(
            "Secure",
            style = TextStyle(
                color = Color.Black,
                fontSize = 84.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun TeacherHomeScreen(navigator : Navigator){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TitleText()
        Row(
            modifier = Modifier
                .padding(50.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    modifier = Modifier.padding(5.dp).width(300.dp),
                    onClick = {
                        navigator.navigate("/gameloadingscreen")
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {
                    Text(
                        text = "LEVELS",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                }

                Button(
                    modifier = Modifier.padding(5.dp).width(300.dp),
                    onClick = {
                        navigator.navigate("/classedit")
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black))
                {
                    Text(
                        text = "KLASSEN",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                }

                Button(
                    modifier = Modifier.padding(5.dp).width(300.dp),
                    onClick = {
                        currentProfileMail = ""
                        navigator.navigate("/login")
                    },
                    colors = ButtonDefaults.buttonColors(Color(64, 95, 255)))
                {
                    Text(
                        text = "LOGOUT",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                }
            }
        }
    }
}
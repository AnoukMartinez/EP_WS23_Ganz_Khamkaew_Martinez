package Views.LevelOverlays

import DesktopBackground
import DesktopProfilePicture
import Models.Profiles.processedStudentProfiles
import Models.levels
import Views.LoginRegister.currentProfileMail
import androidx.compose.foundation.background
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
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MailOutline
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
fun TestTaskView(onMove : () -> Unit, onFinishCorrect : () -> Unit, onFinishFalse : () -> Unit, numberOfTries : Int){
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

                            val currentStudentProgress = processedStudentProfiles.first{ it.email == currentProfileMail }.progress[1]
                            val currentScore = 5 - numberOfTries

                            if(currentStudentProgress.ersterscore == 0){
                                currentStudentProgress.ersterscore = currentScore
                                currentStudentProgress.besterscore = currentScore
                                currentStudentProgress.fertig = true
                            } else if(currentScore > currentStudentProgress.besterscore) {
                                currentStudentProgress.besterscore = currentScore
                            }

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
fun EmailTaskView(onMove : () -> Unit, onFinishCorrect : () -> Unit, onFinishFalse : () -> Unit, numberOfTries : Int) {
    var checkedMails by remember { mutableStateOf(mutableListOf(false, false, false, false, false)) }
    var submitted by remember { mutableStateOf(false) }

    Box (modifier = Modifier.fillMaxWidth()) {
        Row {
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start) {
                IconButton(onClick = { onMove() }) {
                    Icon(modifier = Modifier.size(50.dp), imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "Left")
                }
            }

            Row (modifier = Modifier.padding(20.dp, 50.dp, 0.dp, 0.dp)) {
                Column(
                    modifier = Modifier
                        .fillMaxSize().background(Color.LightGray).weight(1f),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    Row(modifier = Modifier.fillMaxWidth().background(Color.Red), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Filled.Email, "Inbox")
                        Text(modifier = Modifier.padding(5.dp), text = "Inbox")
                    }
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                        Icon(Icons.Filled.List, "Notizen")
                        Text(modifier = Modifier.padding(5.dp), text = "Notizen")
                    }
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                        Icon(Icons.Filled.DateRange, "Kalendar")
                        Text(modifier = Modifier.padding(5.dp), text = "Kalendar")
                    }
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                        Icon(Icons.Filled.MailOutline, "Alles")
                        Text(modifier = Modifier.padding(5.dp), text = "Alles")
                    }
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                        Icon(Icons.Filled.Delete, "Papierkorb")
                        Text(modifier = Modifier.padding(5.dp), text = "Papierkorb")
                    }
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                        Icon(Icons.Filled.KeyboardArrowUp, "Weniger")
                        Text(modifier = Modifier.padding(5.dp), text = "Weniger")
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize().weight(3f),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ){
                    Text (
                        modifier = Modifier.padding(20.dp),
                        text = "Inbox",
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Column(modifier = Modifier.padding(10.dp)){
                        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                            MailCheckBox(0, checkedMails)
                            Text(
                                modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp),
                                text = "Günther Vertrauenswürdig",
                                fontWeight = FontWeight.Bold
                            )
                            Text("Hier eine relativ seriöse Nachricht.")
                        }

                        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                            MailCheckBox(1, checkedMails)
                            Text(
                                modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp),
                                text = "Komischer Typ",
                                fontWeight = FontWeight.Bold
                            )
                            Text("Hey, ich hab eine super Gelegenheit! Schnell eine Million Euro gewinnen!")
                        }

                        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                            MailCheckBox(2, checkedMails)
                            Text(
                                modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp),
                                text = "Definitiv Amazon",
                                fontWeight = FontWeight.Bold
                            )
                            Text("Bitte gib mir sofort dein Passwort!!!")
                        }

                        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                            MailCheckBox(3, checkedMails)
                            Text(
                                modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp),
                                text = "Anna Engel",
                                fontWeight = FontWeight.Bold
                            )
                            Text("Seniorentreff Newsletter vom 19.02.2024")
                        }

                        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                            MailCheckBox(4, checkedMails)
                            Text(
                                modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp),
                                text = "deinenkel.ru@hotmail.com",
                                fontWeight = FontWeight.Bold
                            )
                            Text("Bitte schick mir mal deine Kreditkarten Infos.")
                        }

                        Button(onClick = { submitted = true }) {
                            Text("Löschen")
                        }
                    }
                }
            }
        }
    }

    if(submitted){
        if(checkedMails == listOf(false, true, true, false, true)) {
            onFinishCorrect()

            val currentStudentProgress = processedStudentProfiles.first{ it.email == currentProfileMail }.progress[0]
            val currentScore = 5 - numberOfTries

            if(currentStudentProgress.ersterscore == 0){
                currentStudentProgress.ersterscore = currentScore
                currentStudentProgress.besterscore = currentScore
                currentStudentProgress.fertig = true
            } else if(currentScore > currentStudentProgress.besterscore) {
                currentStudentProgress.besterscore = currentScore
            }

            levels[1].cleared = true
        } else {
            onFinishFalse()
        }
    }
}

@Composable
fun MailCheckBox(id : Int, mailList : MutableList<Boolean>) {
    var checkedState by remember { mutableStateOf(false) }
    Checkbox (
        checked = checkedState,
        onCheckedChange = {
            checkedState = it
            mailList[id] = checkedState
        }
    )
}

@Composable
fun CrosswordTaskView(onMove : () -> Unit, onFinishCorrect : () -> Unit, onFinishFalse : () -> Unit, numberOfTries : Int) {
    Box (modifier = Modifier.fillMaxWidth()) {
        Row {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                IconButton(onClick = { onMove() }) {
                    Icon(
                        modifier = Modifier.size(50.dp),
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "Left"
                    )
                }
            }

            // Hier der Rest
            Column (modifier = Modifier.fillMaxSize().padding(0.dp, 50.dp, 0.dp, 0.dp).background(Color.LightGray)) {
                Text("Platzhalter")
            }
        }
    }
}

@Composable
fun DownloadsTaskView(onMove : () -> Unit, onFinishCorrect : () -> Unit, onFinishFalse : () -> Unit, numberOfTries : Int) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                IconButton(onClick = { onMove() }) {
                    Icon(
                        modifier = Modifier.size(50.dp),
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "Left"
                    )
                }
            }

            // Hier der Rest
            Column(
                modifier = Modifier.fillMaxSize().padding(0.dp, 50.dp, 0.dp, 0.dp)
                    .background(Color.LightGray)
            ) {
                Text("Platzhalter")
            }
        }
    }
}
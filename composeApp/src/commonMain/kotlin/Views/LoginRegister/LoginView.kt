package Views.LoginRegister

import Models.Profiles.processedStudentProfiles
import Models.Profiles.processedTeacherProfiles
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator

var currentProfileMail = ""

    @Composable
fun LoginScreen(navigator : Navigator) {
    var password by remember { mutableStateOf("") }
    var mail by remember { mutableStateOf("") }
    var mailNotFound by remember { mutableStateOf(false) }
    var loginAsStudent by remember { mutableStateOf(false) }
    var attemptedOnce by remember { mutableStateOf(false) }

    Box (
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(20.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(modifier = Modifier.padding(30.dp)) {
                Text(
                    "Log",
                    style = TextStyle(
                        color = Color(64, 95, 255),
                        fontSize = 84.sp,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center
                    )
                )
                Text(
                    "in",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 84.sp,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center
                    )
                )
            }

            Column {
                OutlinedTextField (
                    modifier = Modifier.padding(1.dp).width(400.dp),
                    value = mail,
                    onValueChange = { mail = it },
                    label = { Text("E-Mail") }
                )

                OutlinedTextField (
                    modifier = Modifier.padding(1.dp).width(400.dp),
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") }
                )

                Button (
                    modifier = Modifier.width(400.dp),
                    onClick = {
                        mailNotFound = true

                        for(student in processedStudentProfiles){
                            if(student.email == mail && student.password == password){
                                loginAsStudent = true
                                mailNotFound = false
                                currentProfileMail = mail
                                attemptedOnce = true
                            } else {
                                for(teacher in processedTeacherProfiles){
                                    if(teacher.email == mail && teacher.password == password) {
                                        mailNotFound = false
                                        currentProfileMail = mail
                                        attemptedOnce = true
                                    }
                                }
                            }
                        }
                        attemptedOnce = true

                        if(loginAsStudent && currentProfileMail != "") {
                            navigator.navigate("/studenthome")
                        } else if (!loginAsStudent && currentProfileMail != "") {
                            navigator.navigate("/teacherhome")
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color(64, 95, 255))

                ) {
                    Text("LOGIN")
                }

                TextButton (
                    modifier = Modifier.width(400.dp),
                    onClick = {
                        currentProfileMail = mail
                        navigator.navigate("/register")
                    }
                ) {
                    Text("NEU REGISTRIEREN")
                }
            }

            Row {
                if(mailNotFound && attemptedOnce) {
                    Text(text = "Die Mail oder das Passwort ist falsch.", color = Color.Red)
                }
            }
        }
    }
}

@Composable
fun InputField(label : String) : String {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(label) }
    )
    return text
}
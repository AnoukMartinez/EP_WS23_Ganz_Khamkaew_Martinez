package Views.LoginRegister

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun LoginScreen(navigator : Navigator) {
    var password by remember { mutableStateOf("") }
    var mail by remember { mutableStateOf("") }

    Box (
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(20.dp).fillMaxSize(),
        ) {
            Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceEvenly) {
                OutlinedTextField(
                    value = mail,
                    onValueChange = { mail = it },
                    label = { Text("E-Mail") }
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") }
                )
            }
            Row {
                Button (
                    onClick = {
                        if(mail == "student" && password == "hi") {
                            navigator.navigate("/studenthome")
                        } else if (mail == "teacher" && password == "hi") {
                            navigator.navigate("/teacherhome")
                        }
                    }
                ) {
                    Text("LOGIN")
                }
                Button (
                    onClick = {
                        navigator.navigate("/register")
                    }
                ) {
                    Text("NEU REGISTRIEREN")
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
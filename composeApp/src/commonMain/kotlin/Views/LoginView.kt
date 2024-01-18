package Views

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

@Composable
fun LoginScreen() {
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
                    onClick = {}
                ) {
                    Text("LOGIN")
                }
            }
        }
    }
}

@Composable
fun InputField(label : String) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(label) }
    )
}
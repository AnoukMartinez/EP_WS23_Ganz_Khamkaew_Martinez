package Views

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

// WIP, hier muss noch der Text und der Titel als Argument übergeben werden.
@Composable
fun HelpOverlay(onConfirm : () -> Unit, title : String, content : String) {
    AlertDialog (
        title = {
            // PLATZHALTER
            Text(title)
        },
        text = {
            if(content.isEmpty()){
                Text("Leider konnte hier keine Hilfe abgerufen werden. " +
                        "Bitte versuche doch einmal die App neu zu starten!")
            } else {
                Text(content)
            }
        },
        onDismissRequest = { },
        confirmButton = {
            Button (
                onClick = { onConfirm() }
            ) {
                Text("Weiter geht's!")
            }
        }
    )
}

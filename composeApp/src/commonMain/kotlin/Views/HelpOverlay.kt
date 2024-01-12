package Views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.Icon
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// WIP, hier muss noch der Text und der Titel als Argument übergeben werden.
@Composable
fun HelpOverlay(onConfirm : () -> Unit) {
    AlertDialog (
        title = {
            Text(text = "Wie bediene ich KidSecure?")
        },
        text = {
            Text(text = "Hallo! Du hast die Aufgabenstellung also nicht ganz verstanden? " +
            "Hier ist nochmal eine bisschen detailliertere Erklärung. Hoffentlich haben " +
                    "wir dir weitergeholfen. Sonst kannst du bestimmt noch einmal bei deinem " +
                    "Lehrer oder deiner Lehrerin nachfragen!")
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

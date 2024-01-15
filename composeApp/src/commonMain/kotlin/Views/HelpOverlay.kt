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
            // PLATZHALTER
            Text(text = "Was soll ich jetzt machen?")
        },
        text = {
            // Platzhalterrrrrrrrrrrrrrrrrrrrrrrrrrrrr
            Text(text = "Im Moment befindest du dich noch im Story Modus. " +
                "Das bedeutet du kannst einfach auf die Textbox unten klicken, um " +
                "die Handlung voranzutreiben. Lies dir hierbei den Dialog " +
                "genau durch, um Hinweise auf die Aufgabe zu erhalten die " +
                "in jeder Welt drankommt.")
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

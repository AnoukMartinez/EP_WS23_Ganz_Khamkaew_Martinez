package Views

import Models.Level
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun SettingsOverlay(navigator: Navigator,level : Level) {
    var isHelpOverlayVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // Wird später zu Image Sequence mit Script usw.


        // Icon Bar oben mit Location Titel
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navigator.goBack() }) {
                Icon(Icons.Filled.Home, contentDescription = "Back To Worldview")
            }

            Text(
                text = level.location.getLocationToString(),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            IconButton(onClick = { isHelpOverlayVisible = true }) {
                Icon(Icons.Filled.Info, contentDescription = "Aufgabenerklärung")
            }

            if (isHelpOverlayVisible) {
                // Platzhalter!!
                val helperTitlePlaceholder = "Was soll ich jetzt machen?"
                val helperTextPlaceholder = "Im Moment befindest du dich noch im Story Modus. " +
                        "Das bedeutet du kannst einfach auf die Textbox unten klicken, um " +
                        "die Handlung voranzutreiben. Lies dir hierbei den Dialog " +
                        "genau durch, um Hinweise auf die Aufgabe zu erhalten die " +
                        "in jeder Welt drankommt."
                HelpOverlay(
                    onConfirm = { isHelpOverlayVisible = false },
                    helperTitlePlaceholder,
                    helperTextPlaceholder
                )
            }
        }
    }
}

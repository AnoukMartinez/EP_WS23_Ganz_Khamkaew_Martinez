package Views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.FlowPreview
import moe.tlaster.precompose.navigation.Navigator


@Composable
fun StudentProgressView(navigator : Navigator) {


    Column {

        IconButton(onClick = { navigator.goBack() }) {
            Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "Back To Worldview")
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceAround

        ){
            Column {
                Text("Aufgabe")
            }
            Column {
                Text("Erster Score")
            }
            Column {
                Text("Bester Score")
            }
            Column {
                Text("Abgeschlossen")
            }

        }
    }

}
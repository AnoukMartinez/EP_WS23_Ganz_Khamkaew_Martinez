package Views

import Models.Profiles.klassen
import Models.buildScriptsLocal
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun ClassEditView(navigator: Navigator){

    Column {

        IconButton(onClick = { navigator.goBack() }) {
            Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "Back To Worldview")
        }

        for(klasse in klassen){
            Button(
                modifier = Modifier.padding(5.dp),
                onClick = {
                    buildScriptsLocal()
                    navigator.navigate("/classprogress")
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
            )

            {
                Text(
                    text = klasse,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            }
        }
    }
}
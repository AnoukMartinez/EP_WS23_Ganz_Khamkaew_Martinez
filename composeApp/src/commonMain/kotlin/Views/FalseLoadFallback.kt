package Views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun FalseLoad(whatsTheProblem : String, possibleSolution : String, onClickReturn : String, navigator : Navigator) {
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        AlertDialog (
            title = { Text("Achtung!") },
            text = {
                Text(whatsTheProblem + " " + possibleSolution)
            },
            onDismissRequest = { },
            confirmButton = {
                Button (
                    onClick = { navigator.navigate(onClickReturn) }
                ) {
                    Text("Verstanden!")
                }
            }
        )
    }
}
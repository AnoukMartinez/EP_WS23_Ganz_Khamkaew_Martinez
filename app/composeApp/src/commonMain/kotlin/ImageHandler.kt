import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

enum class Location{
    OMA,
    KEVIN,
    SCHULE
}

@Composable
fun locationButton(label : String, onClick : () -> Unit) {
    TextButton(onClick = onClick ) {
        Text(label)
    }
}

@Composable
fun locationTest(location : Location) {
    Card(modifier = Modifier) {
        callImage(location)
    }
}
/* -------------------------------------------------------------------
    +-- Kommentar hierzu --+
    Hier aufpassen, das ist nur für die ersten Tests.
    In der Praxis muss die callImage() Methode wahrscheinlich eher
    so was wie callTaskSequence oder so heißen.
    Es wird nicht nur ein Bild angezeigt, sondern eine Sequenz von
    Bildern durchgehen, z.B in einer for Schleife (for image in
    folder called Oma) Um den "Visual Novel" Effekt zu erhalten (?)
  -------------------------------------------------------------------- */

@Composable
expect fun callImage(location : Location)
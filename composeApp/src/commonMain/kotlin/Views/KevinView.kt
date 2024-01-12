package mvvm.views

// import LocationInfo
// import Welt
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun KevinsHaus(){
    Column{
        // Musste ich erst mal auskommentieren weil ich die LocationInfo fürs erste rausgenommen habe
        // Aber kannst du später wieder reinnehmen bzw wir arbeiten noch dran
        // LocationInfo(level = Welt("Kevins Haus"))
        FilledButtonExample {  }
    }

}

@Composable
fun Dialog(){
    Card {
        Text(text = "Hello, world!")
    }

}
@Composable
fun Kevin(){

}

@Composable
fun FilledButtonExample(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text("Reden")
    }
}
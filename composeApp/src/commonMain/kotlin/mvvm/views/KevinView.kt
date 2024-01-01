package mvvm.views

import LocationInfo
import Welt
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun KevinsHaus(){
    Column{
        LocationInfo(level = Welt("Kevins Haus"))
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
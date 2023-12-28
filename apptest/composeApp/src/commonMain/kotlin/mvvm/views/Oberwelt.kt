package mvvm.views

import LevelButton
import LocationInfo
import Welt
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Oberwelt() {
    Column{
        LocationInfo(level = Welt("Oberwelt"))
        Row (modifier = Modifier.padding(all =20.dp)){
            //Button(btn = Button("Oma"))
            LevelButton("Oma", onClick = { })
            Spacer(modifier = Modifier.width(100.dp))
            //Button(btn = Button("Kevin"))
            LevelButton("Kevin", onClick = { })
            Spacer(modifier = Modifier.width(20.dp))
            //Button(btn = Button("Justin"))
            LevelButton("Justin", onClick = { })
        }
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            //Button(btn = Button("Schule"))
            LevelButton("Schule", onClick = { })
        }
    }
}

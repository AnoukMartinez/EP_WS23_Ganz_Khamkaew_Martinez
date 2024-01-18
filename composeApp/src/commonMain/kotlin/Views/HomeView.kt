import Models.Level
import Models.buildScripts
import Models.levels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun HomeScreen(navigator : Navigator) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TitleText(title = "KidSecure")
        Row(
            modifier = Modifier
                .padding(50.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            TextButton(onClick = {
                navigator.navigate("/gameloadingscreen")
            }) {
                Text(
                    text = "PLAY",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            }
        }
    }
}

@Composable
fun GameLoadingScreen(navigator : Navigator) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val scope = rememberCoroutineScope()

        LaunchedEffect(true) {
            scope.launch {
                levels = buildScripts()
                navigator.navigate("/worldmap")
            }
        }
        CircularProgressIndicator(
            modifier = Modifier.width(30.dp),
            color = Color.Blue,
            backgroundColor = Color.White,
        )

        Text(
            modifier = Modifier.padding(10.dp),
            text = "Lade Gespräche...",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )
    }
}

@Composable
fun TitleText(title : String) {
    Box(
        modifier = Modifier
            .background(Color.Black, RoundedCornerShape(10.dp))
            .padding(50.dp, 10.dp)
    ) {
        Text(
            title,
            style = TextStyle(
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                letterSpacing = 5.sp,
            )
        )
    }
}
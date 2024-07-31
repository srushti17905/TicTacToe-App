package com.example.tictactoe.android

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.ConnectivityManagerCompat.RestrictBackgroundStatus
import com.example.tictactoe.Greeting
import org.w3c.dom.Text
import sky
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            tictactoe()
        }
    }
}

fun wincondition(i: Int, i1: Int, i2: Int) {
    if (list[i] != "") {
        if (list[i] == "X" && list[i1] == "X" && list[i2] == "X") {
            if (list[i] == list[i1] && list[i] == list[i2]) {
                star.value = "X is win!..."
            }
        }

        if (list[i] == "0" && list[i1] == "0" && list[i2] == "0") {
            if (list[i] == list[i1] && list[i] == list[i2]) {
                star.value = "0 is win!..."
            }
        }

        if (star.value != "X is win!..." && star.value != "0 is win!..." && list[0] != "" && list[1] != "" && list[2] != "" && list[3] != "" && list[4] != "" && list[5] != "" && list[6] != "" && list[7] != "" && list[8] != "") {
            star.value = " it's tie!..."
        }
    }
}

@Composable
fun button(text: String) {
    Button(
        onClick = {
            Log.d("==>", "Button : ")
            if (text == "Restart") {
                list[0] = ""
                list[1] = ""
                list[2] = ""
                list[3] = ""
                list[4] = ""
                list[5] = ""
                list[6] = ""
                list[7] = ""
                list[8] = ""

                star.value = ""
            }
        },
        enabled = true,
        colors = ButtonDefaults.buttonColors(Color.White),
        shape = RoundedCornerShape(50),
        border = BorderStroke(3.dp, sky.pink)
    ) {
        Text(
            text = text, fontSize = 30.sp, fontStyle = FontStyle.Italic, color = Color.Black
        )
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

var list = mutableStateListOf<String>("", "", "", "", "", "", "", "", "")
var temp = 1
var star = mutableStateOf("")

@Composable
fun square(rowScope: RowScope, i: Int) {
    rowScope.apply {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(sky.pink)
                .clickable {

                    if (list[i] == "" && star.value == "") {
                        if (temp == 1) {
                            list[i] = "X"
                            temp = 0
                        } else {
                            list[i] = "0"
                            temp = 1
                        }
                    }

                    wincondition(i = 0, i1 = 1, i2 = 2)
                    wincondition(i = 3, i1 = 4, i2 = 5)
                    wincondition(i = 6, i1 = 7, i2 = 8)
                    wincondition(i = 0, i1 = 3, i2 = 6)
                    wincondition(i = 1, i1 = 4, i2 = 7)
                    wincondition(i = 2, i1 = 5, i2 = 8)
                    wincondition(i = 0, i1 = 4, i2 = 8)
                    wincondition(i = 2, i1 = 4, i2 = 6)

                }
                .weight(1f)
                .border(BorderStroke(2.dp, Color.White))) {

            Text(
                text = list[i], fontSize = 70.sp, textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun tictactoe() {
    Column(
        modifier = Modifier.fillMaxSize()

    ) {
        var cn = 0
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1.5f), contentAlignment = Alignment.Center
        ) {
            Text(
                text = star.value, fontSize = 60.sp, color = Color.White
            )
        }
        for (i in 1..3) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                for (ii in 1..3) {
                    square(rowScope = this, cn)
                    cn++
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1.5f), contentAlignment = Alignment.Center
        )
        {
            button(text = "Restart")
        }
    }
}

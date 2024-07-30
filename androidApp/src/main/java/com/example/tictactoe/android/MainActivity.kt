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
import com.example.tictactoe.Greeting
import org.w3c.dom.Text
import sky
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }
}

// git

fun wincondition(i: Int, i1: Int, i2: Int) {
    if (list[i] != "") {
        if (list[i] == list[i1] && list[i] == list[i2])
        {
            star.value = "win"
        }
    }
}

@Composable
fun button(text: String)
{
    Button(onClick = { Log.d("==>" , "Button : ")
        if(text == "Restart")
        {
            list.clear()
        }
    },
        enabled = true,
        colors = ButtonDefaults.buttonColors(Color.White),
        shape = RoundedCornerShape(50)
    )
    {
        Text(text = text,
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            color = Color.Black
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
fun surface(rowScope: RowScope, i: Int) {
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
fun DefaultPreview() {
    Column(
        modifier = Modifier.fillMaxSize()

    ) {
        var cn = 0
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(1.5f)
        ) {}
        for (i in 1..3) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                for (ii in 1..3) {
                    surface(rowScope = this, cn)
                    cn++
                }

            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1.5f), contentAlignment = Alignment.Center

        ) {
            button("Restart" )

            Text(
                text = star.value, fontSize = 50.sp
            )
            }
        }
    }

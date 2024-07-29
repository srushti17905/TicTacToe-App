package com.example.tictactoe.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tictactoe.Greeting
import sky

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingView(Greeting().greet())
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Composable

fun surface(rowScope: RowScope) {
    rowScope.apply {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f), color = sky.pink, border = BorderStroke(3.dp, Color.White)
        ) {

        }
    }
}

@Composable
fun round(rowScope: RowScope) {
    rowScope.apply {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f), shape = RoundedCornerShape(50)
                , color = Color.White
        )
        {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(10.dp), shape = RoundedCornerShape(50)
                ,color = Color.White
            )
            {
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()

    )
    {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(1.5f)
        )
        {
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        )
        {
          for (i in 1..3) {
              surface(rowScope = this)
          }

        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        )
        {
            for (i in 1..3) {
                surface(rowScope = this)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        )
        {
            for (i in 1..3) {
                surface(rowScope = this)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(1.5f)
        ) {

        }
    }
}


/* Surface(modifier = Modifier.fillMaxSize())
    {
        Image(
            painter = painterResource(
                id = R.drawable.wooden
            ), contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
    }
*/
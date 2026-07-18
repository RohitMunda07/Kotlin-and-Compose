package com.example.jetpackcomposs_text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposs_text.ui.theme.JetpackCompossTextTheme
import jetpackcomposs.NestedRowsAndColumn
import jetpackcomposs.TypesOfItems
import navigatonExample.LoginScreenUI
import navigatonExample.NavGraph
import scaffold.MyScren

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackCompossTextTheme {
                MyScren()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackCompossTextTheme {
        Greeting("Android data")
    }
}
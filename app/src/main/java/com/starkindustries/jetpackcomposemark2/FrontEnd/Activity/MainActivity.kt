package com.starkindustries.jetpackcomposemark2.FrontEnd.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.starkindustries.jetpackcomposemark2.ui.theme.JetPackComposeMark2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeMark2Theme {

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeMark2Theme {
    }
}
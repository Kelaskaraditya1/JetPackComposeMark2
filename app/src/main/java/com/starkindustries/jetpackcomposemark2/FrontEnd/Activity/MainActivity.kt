package com.starkindustries.jetpackcomposemark2.FrontEnd.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.widget.ListPopupWindowCompat
import com.starkindustries.jetpackcomposemark2.FrontEnd.Component.LazyColumn
import com.starkindustries.jetpackcomposemark2.FrontEnd.Component.ListColumn
import com.starkindustries.jetpackcomposemark2.Utility.UtillityClass
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
        var userList= UtillityClass.getData()
        LazyColumn(userList)
    }
}
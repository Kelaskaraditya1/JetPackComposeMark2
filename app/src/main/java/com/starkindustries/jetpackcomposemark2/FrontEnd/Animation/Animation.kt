package com.starkindustries.jetpackcomposemark2.FrontEnd.Animation

import android.graphics.Paint.Align
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun animationCompose(){
    var state = remember {
        mutableStateOf(300.dp)
    }
    val animate = animateDpAsState(targetValue = state.value,
        tween(
            3000,
            100,
            easing = LinearOutSlowInEasing
        )
    )
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Box(modifier = Modifier
            .size(animate.value)
            .background(Color.Red)
            .fillMaxSize(),
            contentAlignment = Alignment.Center){
            Button(onClick = { state.value+=50.dp }) {
                Text(text = "Click Me",
                    modifier = Modifier.width(100.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp)
                
            }
        }
    }




}
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun previewFunction(){
    animationCompose()
}
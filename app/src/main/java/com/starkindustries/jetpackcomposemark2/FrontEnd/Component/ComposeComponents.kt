package com.starkindustries.jetpackcomposemark2.FrontEnd.Component

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.starkindustries.jetpackcomposemark2.R

@Composable
fun ProfilePicCompose(imageId:Int){
    Row {
        Image(painter = painterResource(id = imageId), contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .border(1.dp, Color.Black, CircleShape),
            contentScale = ContentScale.Crop)
        Image(painter = painterResource(id = R.drawable.plus), contentDescription = null,
            modifier = Modifier
                .clickable { }
                .size(40.dp)
                .offset(-50.dp, 150.dp))
    }
}

@Composable
fun ColumnCompose(){
Column (modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally){
    ProfilePicCompose(imageId = R.drawable.casual_pic)
    ProfilePicCompose(imageId = R.drawable.casual_pic)
}
}

@Composable
fun RowCompose(){
    Row(modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        ProfilePicCompose(imageId = R.drawable.casual_pic)
        ProfilePicCompose(imageId = R.drawable.casual_pic)
    }
}

@Composable
fun BoxCompose(){
Box{
Image(painter = painterResource(id = R.drawable.casual_pic), contentDescription = null,
    modifier = Modifier
        .size(200.dp)
        .clip(CircleShape),
    contentScale = ContentScale.Crop)
    Box(contentAlignment = Alignment.BottomEnd,
        modifier = Modifier.size(200.dp).
    offset(-10.dp,-10.dp)){
        Image(painter = painterResource(id = R.drawable.plus), contentDescription = null,
            modifier = Modifier.size(40.dp))
    }

}
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewFunction(){
BoxCompose()
}
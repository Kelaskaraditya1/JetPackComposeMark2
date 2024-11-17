package com.starkindustries.jetpackcomposemark2.FrontEnd.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.starkindustries.jetpackcomposemark2.R

@Composable
fun ProfilePicCompose(imageId:Int){
    Row {
        Image(painter = painterResource(id = imageId), contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape).
        background(Color.Gray),
            contentScale = ContentScale.Crop)
        Image(painter = painterResource(id = R.drawable.plus), contentDescription = null,
            modifier = Modifier.clickable {  }.size(40.dp).
        offset(-50.dp,150.dp))
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewFunction(){
    ProfilePicCompose(R.drawable.casual_pic)

}
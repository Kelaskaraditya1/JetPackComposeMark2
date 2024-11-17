package com.starkindustries.jetpackcomposemark2.FrontEnd.Component

import android.graphics.Paint.Align
import android.graphics.Paint.Style
import android.service.autofill.UserData
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.starkindustries.jetpackcomposemark2.Data.ProfileData
import com.starkindustries.jetpackcomposemark2.R
import com.starkindustries.jetpackcomposemark2.Utility.UtillityClass

@Composable
fun ProfilePicCompose(imageId:Int,modifier: Modifier){
    Row {
        Image(painter = painterResource(id = imageId), contentDescription = null,
            modifier = modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(1.dp, Color.Black, CircleShape),
            contentScale = ContentScale.Crop)
        Image(painter = painterResource(id = R.drawable.plus), contentDescription = null,
            modifier = Modifier
                .clickable { }
                .size(20.dp)
                .offset(-20.dp, 70.dp))
    }
}

@Composable
fun ColumnCompose(){
Column (modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally){
    ProfilePicCompose(imageId = R.drawable.casual_pic,Modifier)
    ProfilePicCompose(imageId = R.drawable.casual_pic,Modifier)
}
}

@Composable
fun RowCompose(){
    Row(modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        ProfilePicCompose(imageId = R.drawable.casual_pic,Modifier)
        ProfilePicCompose(imageId = R.drawable.casual_pic,Modifier)
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
        modifier = Modifier
            .size(200.dp)
            .offset(-10.dp, -10.dp)){
        Image(painter = painterResource(id = R.drawable.plus), contentDescription = null,
            modifier = Modifier.size(40.dp))
    }

}
}

@Composable
fun UserProfileCompose(userItem:ProfileData){
    Card(shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        ),
        elevation = CardDefaults.cardElevation(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(10.dp)) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically){
            ProfilePicCompose(imageId = userItem.imageId,Modifier)
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .offset(-10.dp),
                verticalArrangement = Arrangement.Center) {
                Text(text = userItem.name,
                    fontSize = 30.sp,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold
                )
                Text(text = userItem.description,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500)
            }
        }
    }
}

@Composable
fun ListColumn(userList:ArrayList<ProfileData>){
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        for(user in userList)
            UserProfileCompose(userItem = user)
    }

}

@Composable
fun LazyColumn(userList:ArrayList<ProfileData>){
    androidx.compose.foundation.lazy.LazyColumn(content = {
        items(userList){
            UserProfileCompose(userItem = it)
        }
    })
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewFunction(){

}
package com.starkindustries.jetpackcomposemark2.FrontEnd.Component

import android.graphics.Paint.Align
import android.graphics.Paint.Style
import android.service.autofill.UserData
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.DragInteraction
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
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.RelativePosition.Companion.Parent
import com.starkindustries.jetpackcomposemark2.Data.ProfileData
import com.starkindustries.jetpackcomposemark2.R
import com.starkindustries.jetpackcomposemark2.Utility.UtillityClass
import kotlin.random.Random

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
fun HoistingFunction(){
    var count= rememberSaveable{
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center) {
        Text(text = "The value of count is: ${count.value}",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 18.sp)
        Button(onClick = { count.value++},
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(0.dp, 10.dp, 0.dp, 0.dp),
            shape = RoundedCornerShape(12.dp),
            elevation =ButtonDefaults.buttonElevation()
        ) {
            Text(text = "Increment")
        }

    }
}

@Composable
fun StateFunction(count:Int,onClick:()->Unit){
    Column(
        verticalArrangement = Arrangement.Center) {
        Text(text = "The value of count is: ${count}",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp)
        Button(onClick = {onClick() },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(0.dp, 10.dp, 0.dp, 0.dp)) {
            Text(text = "Increment",
                fontSize = 20.sp)
        }
    }
}

@Composable
fun NotificationCardCompose(count:Int){
    Card(shape= RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .size(60.dp)
            .padding(40.dp, 10.dp, 40.dp, 0.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )) {
        Row (modifier = Modifier.fillMaxSize()){
            Image(imageVector = Icons.Outlined.Favorite, contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(40.dp, 0.dp, 0.dp, 0.dp)
                    .size(35.dp))
            Text(text = "Message sent so far:$count",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(10.dp, 0.dp, 0.dp, 0.dp),
                fontSize = 18.sp,)
        }
    }
}

@Composable
fun TextDisplayCompose(){
    val state = rememberSaveable{
        mutableStateOf("")
    }
    val displayText = rememberSaveable{
        mutableStateOf("")
    }
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center) {
            Text(text = displayText.value,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.W600,
                textAlign = TextAlign.Center)
        TextField(value = state.value, onValueChange = {
            state.value=it
        },
            label = {
                Text(text = "Name")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp))
            Button(onClick = {  displayText.value=state.value },
                modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(text = "Submit",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }

//@Composable
//@Preview(showBackground = true, showSystemUi = true, name = "PreviewMark1")
//fun PreviewFunctionStateHoisting(){
//    var count = rememberSaveable {
//        mutableStateOf(0)
//    }
//    Column (modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center){
//        StateFunction(count.value,{count.value++})
//        NotificationCardCompose(count.value)
//    }
//}


@Composable
fun RoundedCardImage(imageId:Int,text:String){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)){
        Card(modifier = Modifier
            .size(200.dp)
            .fillMaxSize(),
            shape = RoundedCornerShape(18.dp),
            elevation = CardDefaults.cardElevation(12.dp)
        ) {
            Box() {
                Image(painter = painterResource(id = imageId), contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop)
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
                )
                Text(text = text,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.W500,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(0.dp, 0.dp, 0.dp, 10.dp),
                    textDecoration = TextDecoration.Underline)
            }
        }
    }

}

@Composable
fun StateExample(modifier: Modifier,updateColor:(Color)->Unit){

    Box(modifier = modifier
        .fillMaxSize()
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        })

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewFunction(){
    val color = remember {
        mutableStateOf(Color.Blue)
    }
    Column(modifier = Modifier.padding(10.dp)) {
        StateExample(
            Modifier
                .fillMaxSize()
                .weight(1f)){
            color.value=it
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .weight(1f)
            .background(color.value)){

        }
    }
}

@Composable
fun ConstraintLayoutCompose(){
    val constraintSet = ConstraintSet {
        val greenBox = createRefFor("GREEN")
        val redBox = createRefFor("RED")
        constrain(greenBox){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width=Dimension.value(150.dp)
            height=Dimension.value(150.dp)
        }
        constrain(redBox){
            top.linkTo(parent.top)
            start.linkTo(greenBox.end)
            width=Dimension.value(150.dp)
            height=Dimension.value(150.dp)
        }

    }
    ConstraintLayout(constraintSet, modifier = Modifier
        .fillMaxSize()) {

        Box(modifier = Modifier
            .background(Color.Green)
            .layoutId("GREEN")
            .size(120.dp),
            contentAlignment = Alignment.Center){
            Text(text = "I am Green Box")
        }
        Box(modifier = Modifier
            .background(Color.Red)
            .size(120.dp)
            .layoutId("RED"),
            contentAlignment = Alignment.Center){
            Text(text = "I am Red Box")
        }
    }

}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewFunctionMark2(){
    ConstraintLayoutCompose()
}
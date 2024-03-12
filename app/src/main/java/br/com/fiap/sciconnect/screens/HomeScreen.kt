package br.com.fiap.sciconnect.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.sciconnect.methods.LetterAvatar

@Composable
fun HomeScreen(navController: NavController){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(255, 255, 255))){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ){
            Box(
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)){
                    mockImage()
                Row(
                    modifier= Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    mockImage()
                    Spacer(modifier = Modifier.width(20.dp))
                    mockImage()
                }
            }
        }
        val scroll = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(vertical = 100.dp)
                .fillMaxSize()
                .background(Color.LightGray)
                .verticalScroll(scroll)
        ){
            Post(user = "gabriel", title = "teste do post",time = "Ter 15:08")
            Post(user = "matheus", title = "olha lá",time = "Qua 15:08")
            Post(user = "RAFA",title = "pull request",time = "Sex 13:00")
            Post(user = "gabriel", title = "teste do post",time = "Ter 15:08")
            Post(user = "matheus", title = "olha lá",time = "Qua 15:08")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .align(alignment = Alignment.BottomStart),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.LightGray)
                    .clickable {}
            ) {
                mockImage()
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.LightGray)
                    .clickable {}
            ) {
                mockImage()
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.LightGray)
                    .clickable {
                        navController.navigate("post")
                    }
            ) {
                mockImage()
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.LightGray)
                    .clickable {}
            ) {
                mockImage()
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.LightGray)
                    .clickable {}
            ) {
                mockImage()
            }
        }
    }
}

@Composable
fun mockImage(){
    Box(
        modifier = Modifier
            .width(40.dp)
            .height(40.dp)
            .background(Color(0, 0, 0))
    )
}

@Composable
fun Post(user:String,title:String,time:String,Description:String? = null,arquive:String? = null){
    Box(
        modifier = Modifier
            .padding(bottom = 5.dp)
            .fillMaxWidth()
            .height(150.dp)
            .background(Color(255, 255, 255))
    ){
        Box(modifier = Modifier.padding(10.dp)){
            Column() {
                Row() {
                    LetterAvatar(name = user)
                    Spacer(modifier = Modifier.width(10.dp))
                    Column() {
                        Text(
                            text = user,
                            color = Color(0,0,0),
                            fontSize = 16.sp
                        )
                        Text(
                            text = time,
                            color = Color(0,0,0),
                            fontSize = 8.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0,0,0)
                )
            }
        }
    }
}
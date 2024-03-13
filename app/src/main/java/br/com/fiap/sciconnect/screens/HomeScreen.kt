package br.com.fiap.sciconnect.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.sciconnect.database.repository.PostRepository
import br.com.fiap.sciconnect.methods.LetterAvatar
import br.com.fiap.sciconnect.model.Post
import br.com.fiap.sciconnect.components.Header
import br.com.fiap.sciconnect.components.Navigation

@Composable
fun HomeScreen(navController: NavController,darkmode: MutableState<Boolean>){
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Header(darkmode = darkmode)
        //val scroll = rememberScrollState()
        val context = LocalContext.current
        val postRepository = PostRepository(context)
        var listaPosts = remember {
            mutableStateOf(postRepository.listarPosts())
        }
        Column(
            modifier = Modifier
                .padding(vertical = 100.dp)
                .fillMaxSize()
                .background(
                    Color.LightGray
                )
                //.verticalScroll(scroll)
        ){
            PostLazyList(listaPosts.value, darkmode)
        }
        Navigation(navController,darkmode = darkmode)
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

//@Composable
//fun Post(
//    user: String,
//    title: String,
//    time: String,
//    Description: String? = null,
//    arquive: String? = null
//) {
//    Box(
//        modifier = Modifier
//            .padding(bottom = 5.dp)
//            .fillMaxWidth()
//            .height(150.dp)
//            .background(Color(255, 255, 255))
//    ) {
//        Box(modifier = Modifier.padding(10.dp)) {
//            Column() {
//                Row() {
//                    LetterAvatar(name = user)
//                    Spacer(modifier = Modifier.width(10.dp))
//                    Column() {
//                        Text(
//                            text = user,
//                            color = Color(0, 0, 0),
//                            fontSize = 16.sp
//                        )
//                        Text(
//                            text = time,
//                            color = Color(0, 0, 0),
//                            fontSize = 8.sp
//                        )
//                    }
//                }
//                Spacer(modifier = Modifier.height(20.dp))
//                Text(
//                    text = title,
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 14.sp,
//                    color = Color(0, 0, 0)
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun PostList(posts: List<Post>) {
//    for (post in posts) {
//        Box(
//            modifier = Modifier
//                .padding(bottom = 5.dp)
//                .fillMaxWidth()
//                .height(150.dp)
//                .background(Color(255, 255, 255))
//        ) {
//            Box(modifier = Modifier.padding(10.dp)) {
//                Column() {
//                    Row() {
//                        LetterAvatar(name = post.user)
//                        Spacer(modifier = Modifier.width(10.dp))
//                        Column() {
//                            Text(
//                                text = post.user,
//                                color = Color(0, 0, 0),
//                                fontSize = 16.sp
//                            )
//                            Text(
//                                text = post.data,
//                                color = Color(0, 0, 0),
//                                fontSize = 10.sp
//                            )
//                        }
//                    }
//                    Spacer(modifier = Modifier.height(20.dp))
//                    Text(
//                        text = post.titulo,
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 14.sp,
//                        color = Color(0, 0, 0)
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    Text(
//                        text = post.descricao,
//                        fontWeight = FontWeight.Medium,
//                        fontSize = 12.sp,
//                        color = Color(0, 0, 0)
//                    )
//                }
//            }
//        }
//    }
//}
@Composable
fun PostLazyList(posts: List<Post>, darkmode: MutableState<Boolean>) {
    LazyColumn() {
        items(posts){post ->
            Box(
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(if(darkmode.value) Color(49,52,57) else Color(255, 255, 255))
            ) {
                Box(modifier = Modifier.padding(10.dp)) {
                    Column() {
                        Row() {
                            LetterAvatar(name = post.user, darkmode)
                            Spacer(modifier = Modifier.width(10.dp))
                            Column() {
                                Text(
                                    text = post.user,
                                    color = if(darkmode.value) Color(49,52,57) else Color(255, 255, 255),
                                    fontSize = 16.sp
                                )
                                Text(
                                    text = post.data,
                                    color = if(darkmode.value) Color(49,52,57) else Color(255, 255, 255),
                                    fontSize = 10.sp
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = post.titulo,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = if(darkmode.value) Color(49,52,57) else Color(255, 255, 255)
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = post.descricao,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            color = if(darkmode.value) Color(49,52,57) else Color(255, 255, 255)
                        )
                    }
                }
            }
        }
    }
}
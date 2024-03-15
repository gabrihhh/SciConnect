package br.com.fiap.sciconnect.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.sciconnect.database.repository.PostRepository
import br.com.fiap.sciconnect.components.Header
import br.com.fiap.sciconnect.components.Navigation

@Composable
fun AwaitScreen(navController: NavController,darkmode: MutableState<Boolean>, admin: MutableState<Boolean>){
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Header(darkmode = darkmode, admin= admin)
        //val scroll = rememberScrollState()
        val context = LocalContext.current
        val postRepository = PostRepository(context)
        var listaAwaitingPosts = remember {
           if (admin.value == true){
               mutableStateOf(postRepository.listarAwaitingPosts())
           }else{
               mutableStateOf(postRepository.listarPosts())
           }
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
            PostLazyList(listaAwaitingPosts.value, darkmode, postRepository, navController)
        }
        Navigation(navController,darkmode = darkmode, admin= admin)
    }
}

//@Composable
//fun mockImage(){
//    Box(
//        modifier = Modifier
//            .width(40.dp)
//            .height(40.dp)
//            .background(Color(0, 0, 0))
//    )
//}

//@Composable
//fun PostLazyList(posts: List<Post>, darkmode: MutableState<Boolean>) {
//    LazyColumn() {
//        items(posts){post ->
//            Box(
//                modifier = Modifier
//                    .padding(bottom = 5.dp)
//                    .fillMaxWidth()
//                    .height(150.dp)
//                    .background(if(darkmode.value) Color(49,52,57) else Color(255, 255, 255))
//            ) {
//                Box(modifier = Modifier.padding(10.dp)) {
//                    Column() {
//                        Row() {
//                            LetterAvatar(name = post.user, darkmode)
//                            Spacer(modifier = Modifier.width(10.dp))
//                            Column() {
//                                Text(
//                                    text = post.user,
//                                    color = if(!darkmode.value) Color(49,52,57) else Color(255, 255, 255),
//                                    fontSize = 16.sp
//                                )
//                                Text(
//                                    text = post.data,
//                                    color = if(!darkmode.value) Color(49,52,57) else Color(255, 255, 255),
//                                    fontSize = 10.sp
//                                )
//                            }
//                        }
//                        Spacer(modifier = Modifier.height(20.dp))
//                        Text(
//                            text = post.titulo,
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 14.sp,
//                            color = if(!darkmode.value) Color(49,52,57) else Color(255, 255, 255)
//                        )
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Text(
//                            text = post.descricao,
//                            fontWeight = FontWeight.Medium,
//                            fontSize = 12.sp,
//                            color = if(!darkmode.value) Color(49,52,57) else Color(255, 255, 255)
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
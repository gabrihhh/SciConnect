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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
//import br.com.fiap.sciconnect.database.repository.PostRepository
import br.com.fiap.sciconnect.model.Documento
import br.com.fiap.sciconnect.components.Header
import br.com.fiap.sciconnect.components.LetterAvatar
import br.com.fiap.sciconnect.components.Navigation
import br.com.fiap.sciconnect.model.User

@Composable
fun HomeScreen(
    navController: NavController,
    darkmode: MutableState<Boolean>,
    admin: MutableState<Boolean>,
    user: MutableState<User?>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Header(darkmode = darkmode, admin = admin)
        //val scroll = rememberScrollState()
        val context = LocalContext.current
        //val postRepository = PostRepository(context)
//        var listaPosts = remember {
//            mutableStateOf(postRepository.listarPosts())
//        }
        Column(
            modifier = Modifier
                .padding(vertical = 100.dp)
                .fillMaxSize()
                .background(
                    Color.LightGray
                )
            //.verticalScroll(scroll)
        ) {
            //PostLazyList(listaPosts.value, darkmode, postRepository, navController)
        }
        Navigation(navController, darkmode = darkmode, admin = admin)
    }
}

@Composable
fun mockImage() {
    Box(
        modifier = Modifier
            .width(40.dp)
            .height(40.dp)
            .background(Color(0, 0, 0))
    )
}

@Composable
fun PostLazyList(
    posts: List<Documento>,
    darkmode: MutableState<Boolean>,
    //postRepository: PostRepository,
    navController: NavController
) {
    LazyColumn() {
        items(posts) { post ->
            Box(
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(if (darkmode.value) Color(49, 52, 57) else Color(255, 255, 255))
            ) {
                Box(modifier = Modifier.padding(10.dp)) {
                    Column() {
//                        Row {
//                            LetterAvatar(name = post.user, darkmode)
//                            Spacer(modifier = Modifier.width(10.dp))
//                            Column() {
//                                Text(
//                                    text = post.user,
//                                    color = if (!darkmode.value) Color(49, 52, 57) else Color(
//                                        255,
//                                        255,
//                                        255
//                                    ),
//                                    fontSize = 16.sp
//                                )
//                                Text(
//                                    text = post.data,
//                                    color = if (!darkmode.value) Color(49, 52, 57) else Color(
//                                        255,
//                                        255,
//                                        255
//                                    ),
//                                    fontSize = 10.sp
//                                )
//                            }
//                            if (post.verified == false) {
//                            Row(
//                                horizontalArrangement = Arrangement.End,
//                                modifier = Modifier.fillMaxWidth()
//                            ) {
//                                Box(
//                                    contentAlignment = Alignment.Center,
//                                    modifier = Modifier
//                                        //.size(40.dp)
//                                        .clickable {
//                                            val postToUpdate = Documento(
//                                                id = post.id,
//                                                titulo = post.titulo,
//                                                data = post.data,
//                                                descricao = post.descricao,
//                                                disciplina = post.disciplina,
//                                                user = post.user,
//                                                verified = true
//                                            )
//                                            postRepository.atualizarPost(postToUpdate)
//                                            navController.navigate("await")
//                                        }
//                                ) {
//                                    Text(text = "Aprovar")
//                                }
//                                Spacer(modifier = Modifier.width(10.dp))
//                                Text(text = "|")
//                                Spacer(modifier = Modifier.width(10.dp))
//                                Box(
//                                    contentAlignment = Alignment.Center,
//                                    modifier = Modifier
//                                        //.size(40.dp)
//                                        .clickable {
//                                            val postToDelete = Documento(
//                                                id = post.id,
//                                                titulo = post.titulo,
//                                                data = post.data,
//                                                descricao = post.descricao,
//                                                disciplina = post.disciplina,
//                                                user = post.user,
//                                                verified = false
//                                            )
//                                            postRepository.excluirPost(postToDelete)
//                                            navController.navigate("await")
//                                        }
//                                ) {
//                                    Text(text = "Reprovar")
//                                }
//                            }
//                        }
//
//                        }
//                        Spacer(modifier = Modifier.height(20.dp))
//                        Text(
//                            text = post.titulo,
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 14.sp,
//                            color = if (!darkmode.value) Color(49, 52, 57) else Color(255, 255, 255)
//                        )
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Text(
//                            text = post.descricao,
//                            fontWeight = FontWeight.Medium,
//                            fontSize = 12.sp,
//                            color = if (!darkmode.value) Color(49, 52, 57) else Color(255, 255, 255)
//                        )
                    }
                }
            }
        }
    }
}
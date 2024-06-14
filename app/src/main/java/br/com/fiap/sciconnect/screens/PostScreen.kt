package br.com.fiap.sciconnect.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.sciconnect.R
import br.com.fiap.sciconnect.components.Navigation

@Composable
fun PostScreen(
    navController: NavController,
    darkmode: MutableState<Boolean>,
    admin: MutableState<Boolean>,
    user: MutableState<String>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(255, 255, 255))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.minilogo),
                    contentDescription = "Logo",
                    Modifier.size(20.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.help),
                        contentDescription = "Help",
                        Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Image(
                        painter = painterResource(id = R.drawable.alarm),
                        contentDescription = "Alarm",
                        Modifier.size(20.dp)
                    )
                }
            }
        }
        val scroll = rememberScrollState()
        var titulo = remember {
            mutableStateOf("")
        }
        var disciplina = remember {
            mutableStateOf("")
        }
        var descricao = remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier
                .padding(vertical = 100.dp)
                .fillMaxSize()
                .background(Color.LightGray)
                .verticalScroll(scroll)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                color = Color(49, 52, 57),
                text = "Título",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = titulo.value,
                onValueChange = { newValue -> titulo.value = newValue },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color(0, 0, 0),
                    focusedBorderColor = Color(49, 52, 57),
                    unfocusedBorderColor = Color(49, 52, 57)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                color = Color(49, 52, 57),
                text = "Disciplina",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = disciplina.value,
                onValueChange = { newValue -> disciplina.value = newValue },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color(0, 0, 0),
                    focusedBorderColor = Color(49, 52, 57),
                    unfocusedBorderColor = Color(49, 52, 57)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                color = Color(49, 52, 57),
                text = "Descrição",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = descricao.value,
                onValueChange = { newValue -> descricao.value = newValue },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color(0, 0, 0),
                    focusedBorderColor = Color(49, 52, 57),
                    unfocusedBorderColor = Color(49, 52, 57)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ) {
                Column() {
                    Box(
                        modifier = Modifier
                            .border(
                                width = 2.dp,
                                color = Color(49, 52, 57),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .width(150.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(
                                    id = if (darkmode.value) R.drawable.zip else R.drawable.zipdark
                                ),
                                contentDescription = "Add",
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(start = 2.dp, top = 2.dp, bottom = 2.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Adicionar Zip",
                                color = Color(49, 52, 57),
                                fontSize = 12.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Box(
                        modifier = Modifier
                            .border(
                                width = 2.dp,
                                color = Color(49, 52, 57),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .width(150.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(
                                    id = if (darkmode.value) R.drawable.pdf else R.drawable.pdfdark
                                ),
                                contentDescription = "Add",
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(start = 2.dp, top = 2.dp, bottom = 2.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Adicionar PDF",
                                color = Color(49, 52, 57),
                                fontSize = 12.sp
                            )
                        }
                    }
                }
                Column() {
                    Box(
                        modifier = Modifier
                            .border(
                                width = 2.dp,
                                color = Color(49, 52, 57),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .width(150.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(
                                    id = if (darkmode.value) R.drawable.addimg else R.drawable.addimgdark
                                ),
                                contentDescription = "Add",
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(start = 2.dp, top = 2.dp, bottom = 2.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Adicionar Imagem",
                                color = Color(49, 52, 57),
                                fontSize = 12.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Box(
                        modifier = Modifier
                            .border(
                                width = 2.dp,
                                color = Color(49, 52, 57),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .width(150.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(
                                    id = if (darkmode.value) R.drawable.etcdark else R.drawable.etc
                                ),
                                contentDescription = "Add",
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(start = 2.dp, top = 2.dp, bottom = 2.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Adicionar Outros",
                                color = Color(49, 52, 57),
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
            val context = LocalContext.current
            //val postRepository = PostRepository(context)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()

            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        //.fillMaxWidth()
                        .height(50.dp)
                        .width(150.dp)
                ) {
                    Column(
                        //verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .background(
                                color = if (darkmode.value) Color.White else Color(
                                    0xFF313439
                                )
                            )
                    ) {

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                //.size(40.dp)
                                .clickable {
                                    // IMPLEMENTAR AQUI
//                                    if (titulo.value != "" && disciplina.value != "" && descricao.value != "") {
//                                        val post = Post(
//                                            id = 0,
//                                            user = user.value,
//                                            titulo = titulo.value,
//                                            disciplina = disciplina.value,
//                                            descricao = descricao.value
//                                        )
//                                        postRepository.salvar(post)
//                                    }
                                    navController.navigate("home")
                                }
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp),
                                //.align(alignment = Alignment.BottomStart),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {

                                Text(
                                    text = "Postar",
                                    color = Color(0xFFFFFFFF),
                                    fontWeight = FontWeight.Bold

                                )
                                Image(
                                    painter = painterResource(
                                        id = if (darkmode.value) R.drawable.arrowrightdark else R.drawable.arrowright
                                    ),
                                    contentDescription = "Add",
                                    modifier = Modifier
                                        .size(40.dp)
                                        .padding(start = 2.dp, top = 2.dp, bottom = 2.dp)
                                )
                            }
                        }


                    }
                }
            }
        }

//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(100.dp)
//                .align(alignment = Alignment.BottomStart),
//            horizontalArrangement = Arrangement.SpaceAround
//        ) {
//            Box(
//                contentAlignment = Alignment.Center,
//                modifier = Modifier
//                    .size(40.dp)
//                    .clickable {}
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.person),
//                    contentDescription = "Person",
//                    modifier = Modifier
//                        .size(20.dp)
//                )
//            }
//            Box(
//                contentAlignment = Alignment.Center,
//                modifier = Modifier
//                    .size(40.dp)
//                    .clickable {}
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.search),
//                    contentDescription = "Search",
//                    modifier = Modifier
//                        .size(20.dp)
//                )
//            }
//            Box(
//                contentAlignment = Alignment.Center,
//                modifier = Modifier
//                    .size(40.dp)
//                    .clickable {
//                        navController.navigate("post")
//                    }
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.add),
//                    contentDescription = "Add",
//                    modifier = Modifier
//                        .size(20.dp)
//                )
//            }
//            Box(
//                contentAlignment = Alignment.Center,
//                modifier = Modifier
//                    .size(40.dp)
//                    .clickable {}
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.list),
//                    contentDescription = "List",
//                    modifier = Modifier
//                        .size(20.dp)
//                )
//            }
//            Box(
//                contentAlignment = Alignment.Center,
//                modifier = Modifier
//                    .size(40.dp)
//                    .clickable {
//                        navController.navigate("home")
//                    }
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.home),
//                    contentDescription = "Home",
//                    modifier = Modifier
//                        .size(20.dp)
//                )
//            }
//        }
        Navigation(navController = navController, darkmode = darkmode, admin = admin)
    }
}
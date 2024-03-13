package br.com.fiap.sciconnect.screens

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun PostScreen(navController: NavController){

    var titulo = remember {
        mutableStateOf("")
    }
    var disciplina = remember {
        mutableStateOf("")
    }
    var descricao = remember {
        mutableStateOf("")
    }

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
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                color =  Color(49,52,57),
                text="Título",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp))
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = titulo.value,
                onValueChange = {newValue -> titulo.value = newValue},
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
                color =  Color(49,52,57),
                text="Disciplina",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp))
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = disciplina.value,
                onValueChange = {newValue -> disciplina.value = newValue},
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
                color =  Color(49,52,57),
                text="Descrição",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp))
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = descricao.value,
                onValueChange = {newValue -> descricao.value = newValue},
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
                            mockImage()
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(text = "Adicionar Zip", color = Color(49, 52, 57), fontSize = 12.sp)
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
                            mockImage()
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(text = "Adicionar PDF", color = Color(49, 52, 57), fontSize = 12.sp)
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
                            mockImage()
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(text = "Adicionar Imagem", color = Color(49, 52, 57), fontSize = 12.sp)
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
                            mockImage()
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(text = "Adicionar Outros", color = Color(49, 52, 57), fontSize = 12.sp)
                        }
                    }
                }
            }
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
                    .clickable {}
            ) {
                mockImage()
            }
        }
    }
}
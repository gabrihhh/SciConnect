package br.com.fiap.sciconnect.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.sciconnect.R

@Composable

fun LoginScreen(
    navController: NavController,
    darkmode: MutableState<Boolean>,
    admin: MutableState<Boolean>, user: MutableState<String>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0, 0, 0))
            .clickable {
                darkmode.value = !darkmode.value
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Mulher Estudando",
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .matchParentSize()
                .scale(1.1f)

        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                Modifier.scale(3.0f)
            )
            Spacer(modifier = Modifier.height(300.dp))
            var login = remember {
                mutableStateOf("")
            }
            TextField(
                value = login.value,
                onValueChange = { newValue -> login.value = newValue },
                placeholder = { Text(text = "Login", color = Color(128, 128, 128)) },
                shape = RoundedCornerShape(8.dp),
            )
            Spacer(modifier = Modifier.height(30.dp))
            var password = remember {
                mutableStateOf("")
            }
            TextField(
                value = password.value,
                onValueChange = { newValue -> password.value = newValue },
                placeholder = { Text(text = "Senha", color = Color(128, 128, 128)) },
                shape = RoundedCornerShape(8.dp),
//                KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                .background(Color(49,52,57), shape = RoundedCornerShape(10.dp))
                .width(120.dp)
                .height(40.dp)
                .clickable {
                if (login.value == "admin") {
                    admin.value = true
                }
                user.value = login.value
                navController.navigate("home")
            }) {
                Text(
                    text = "Entrar",
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                .background(Color(94,147,89), shape = RoundedCornerShape(10.dp))
                .width(120.dp)
                .height(40.dp)
                .clickable {
                    if (login.value == "admin") {
                        admin.value = true
                    }
                    user.value = login.value
                    navController.navigate("register");
                }) {
                Text(
                    text = "Criar conta",
                    color = Color.White
                )
            }

        }
    }
}

package br.com.fiap.sciconnect.screens

import android.util.Log
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.sciconnect.R
import br.com.fiap.sciconnect.model.User
import br.com.fiap.sciconnect.model.UserLogin
import br.com.fiap.sciconnect.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var ListaUsers by mutableStateOf(listOf<User?>(null))

@Composable

fun LoginScreen(
    navController: NavController,
    darkmode: MutableState<Boolean>,
    admin: MutableState<Boolean>,
    user: MutableState<User?>
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
                    var newUser: UserLogin = UserLogin(
                        login = login.value,
                        senha = password.value
                    )

                    var call = RetrofitFactory()
                        .getLoginService()
                        .postLogin(newUser)

                    call.enqueue(object : Callback<List<User>> {
                        override fun onResponse(
                            call: Call<List<User>>,
                            response: Response<List<User>>
                        ) {
                            Log.i("FIAP", "onResponse: ${response.body()}")
                            ListaUsers = response.body()!!
                            if(ListaUsers[0] !== null){
                                var newUser: User = User(
                                    nomeEstudante = ListaUsers[0]!!.nomeEstudante,
                                    tipoUsuario = ListaUsers[0]!!.tipoUsuario,
                                    areaInteresse = ListaUsers[0]!!.areaInteresse,
                                    senhaEstudante = ListaUsers[0]!!.senhaEstudante,
                                    documentoEstudante = ListaUsers[0]!!.documentoEstudante,
                                    idEstudante = ListaUsers[0]!!.idEstudante,
                                    ultimoLogin = ListaUsers[0]!!.ultimoLogin
                                )
                                user.value = newUser
                                navController.navigate("home")
                            }
                        }

                        override fun onFailure(call: Call<List<User>>, t: Throwable) {
                            Log.i("FIAP", "onResponse: ${t.message}")

                        }

                    })
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
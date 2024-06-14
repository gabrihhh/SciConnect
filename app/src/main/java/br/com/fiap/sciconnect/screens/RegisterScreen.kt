package br.com.fiap.sciconnect.screens

import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.sciconnect.R
import br.com.fiap.sciconnect.model.User
import br.com.fiap.sciconnect.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun RegisterScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(255, 255, 255))
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Mulher Estudando",
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .matchParentSize()
                .scale(1.1f)
                .alpha(0.5f)
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
            Spacer(modifier = Modifier.height(100.dp))
            //nome
            var nome = remember {
                mutableStateOf("")
            }
            TextField(
                value = nome.value,
                onValueChange = { newValue -> nome.value = newValue },
                placeholder = { Text(text = "Nome", color = Color(128, 128, 128)) },
                shape = RoundedCornerShape(8.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))

            //cpf
            var cpf = remember {
                mutableStateOf("")
            }
            TextField(
                value = cpf.value,
                onValueChange = { newValue -> cpf.value = newValue },
                placeholder = { Text(text = "Cpf", color = Color(128, 128, 128)) },
                shape = RoundedCornerShape(8.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))
            //input

            var selectedOption by remember { mutableStateOf(Option.estudante) }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                RadioButton(
                    selected = selectedOption == Option.estudante,
                    onClick = { selectedOption = Option.estudante }
                )
                Text(
                    text = "Estudante",
                    color = Color(49,52,57),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 8.dp)
                )

                RadioButton(
                    selected = selectedOption == Option.colaborador,
                    onClick = { selectedOption = Option.colaborador }
                )
                Text(
                    text = "Colaborador",
                    color = Color(49,52,57),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }
            //Curso
            var curso = remember {
                mutableStateOf("")
            }
            TextField(
                value = curso.value,
                onValueChange = { newValue -> curso.value = newValue },
                placeholder = { Text(text = "Curso", color = Color(128, 128, 128)) },
                shape = RoundedCornerShape(8.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))

            //senha
            var senha = remember {
                mutableStateOf("")
            }
            TextField(
                value = senha.value,
                onValueChange = { newValue -> senha.value = newValue },
                placeholder = { Text(text = "Senha", color = Color(128, 128, 128)) },
                shape = RoundedCornerShape(8.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))

            //senhaNovamente
            var senhaNovamente = remember {
                mutableStateOf("")
            }
            TextField(
                value = senhaNovamente.value,
                onValueChange = { newValue -> senhaNovamente.value = newValue },
                placeholder = { Text(text = "Confirmar senha", color = Color(128, 128, 128)) },
                shape = RoundedCornerShape(8.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))

            //criar conta
            Box(
                modifier = Modifier
                    .background(Color(94,147,89), shape = RoundedCornerShape(10.dp))
                    .height(50.dp)
                    .width(200.dp)
                    .clickable {

                        var newUser:User = User(
                            documentoEstudante = cpf.value,
                            areaInteresse = curso.value,
                            nomeEstudante = nome.value,
                            tipoUsuario = selectedOption.toString(),
                            senhaEstudante = senha.value
                        )

                        var call = RetrofitFactory()
                            .getUsersService()
                            .postUser(newUser)

                        call.enqueue(object : Callback<User> {
                            override fun onResponse(call: Call<User>, response: Response<User>) {
                                Log.i("FIAP", "onResponse: ${response.body()}")
                                navController.navigate("login")
                            }

                            override fun onFailure(call: Call<User>, t: Throwable) {
                                Log.i("FIAP", "onResponse: ${t.message}")
                            }

                        })
                    },
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Criar Conta"
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            //voltar
            Box(
                modifier = Modifier
                    .background(Color(49,52,57), shape = RoundedCornerShape(10.dp))
                    .height(40.dp)
                    .width(120.dp)
                    .clickable {
                               navController.navigate("login");
                    },
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Voltar"
                )
            }

        }
    }
}

enum class Option {
    estudante,
    colaborador
}
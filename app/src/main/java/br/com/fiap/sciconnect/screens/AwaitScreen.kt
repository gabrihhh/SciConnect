package br.com.fiap.sciconnect.screens

import android.util.Log
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import br.com.fiap.sciconnect.components.Header
import br.com.fiap.sciconnect.components.LetterAvatar
import br.com.fiap.sciconnect.components.Navigation
import br.com.fiap.sciconnect.model.Documento
import br.com.fiap.sciconnect.model.User
import br.com.fiap.sciconnect.service.ColaboradorService
import br.com.fiap.sciconnect.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun AwaitScreen(navController: NavController,darkmode: MutableState<Boolean>, admin: MutableState<Boolean>,user:MutableState<User?>){
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Header(darkmode = darkmode, admin= admin)
        val scroll = rememberScrollState()
        val context = LocalContext.current
        var listaAwaitingPosts = remember { mutableStateOf<List<Documento>?>(null)}

        var call = RetrofitFactory()
            .getColaboradorService()
            .getDocumentosPendentes()

        call.enqueue(object : Callback<List<Documento>> {
            override fun onResponse(
                call: Call<List<Documento>>,
                response: Response<List<Documento>>
            ) {
                listaAwaitingPosts.value = response.body()!!
            }

            override fun onFailure(call: Call<List<Documento>>, t: Throwable) {
                Log.i("FIAP", "onResponse: ${t.message}")

            }

        })

        Column(
            modifier = Modifier
                .padding(vertical = 100.dp)
                .fillMaxSize()
                .background(
                    Color.LightGray
                )
                .verticalScroll(scroll)
        ){
            PostLazyList(listaAwaitingPosts.value!!, darkmode)
        }
        Navigation(navController,darkmode = darkmode, admin= admin, user = user)
    }
}
@Composable
fun PostLazyList(posts: List<Documento>, darkmode: MutableState<Boolean>) {
    LazyColumn {
        items(posts) {item ->
            Box(
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(if (darkmode.value) Color(49, 52, 57) else Color(255, 255, 255))
            ) {
                Box(modifier = Modifier.padding(10.dp)) {
                    Column() {
                        Row() {
                            LetterAvatar(name = item.autor, darkmode)
                            Spacer(modifier = Modifier.width(10.dp))
                            Column() {
                                Text(
                                    text = item.autor,
                                    color = if (!darkmode.value) Color(49, 52, 57) else Color(
                                        255,
                                        255,
                                        255
                                    ),
                                    fontSize = 16.sp
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = item.nomeDocumento,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = if (!darkmode.value) Color(49, 52, 57) else Color(255, 255, 255)
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = item.propostaEstudo,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            color = if (!darkmode.value) Color(49, 52, 57) else Color(255, 255, 255)
                        )
                    }
                }
            }
        }

    }
}

package br.com.fiap.sciconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.sciconnect.ui.theme.SciConnectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SciConnectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login()
                }
            }
        }
    }
}

@Composable
fun Login() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0, 0, 0))
    ){
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Mulher Estudando",
            modifier = Modifier
                .align(Alignment.Center)
                .matchParentSize()
                .scale(1.2f)

        )
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
            Spacer(modifier = Modifier.height(60.dp))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
            )
            Spacer(modifier = Modifier.height(350.dp))
            TextField(value = "", onValueChange = {}, placeholder = {Text(text="Login")})
            Spacer(modifier = Modifier.height(30.dp))
            TextField(value = "", onValueChange = {}, placeholder = {Text(text="Senha")})
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = {}) {
                Text(text="Entrar")
            }
            
        }
    }
}
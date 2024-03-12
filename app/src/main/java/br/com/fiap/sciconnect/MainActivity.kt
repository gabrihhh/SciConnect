package br.com.fiap.sciconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sciconnect.screens.LoginScreen
import br.com.fiap.sciconnect.screens.HomeScreen
import br.com.fiap.sciconnect.screens.Post
import br.com.fiap.sciconnect.screens.PostScreen
import br.com.fiap.sciconnect.ui.theme.SciConnectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SciConnectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ){
                        composable(route = "login"){ LoginScreen(navController) }
                        composable(route = "home"){ HomeScreen(navController) }
                        composable(route = "post"){ PostScreen(navController) }
                    }
                }
            }
        }
    }
}
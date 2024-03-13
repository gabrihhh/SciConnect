package br.com.fiap.sciconnect.methods

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.sciconnect.R

@Composable
fun Navigation(navController:NavController){
    Box(modifier = Modifier.fillMaxSize()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .align(alignment = Alignment.BottomStart),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clickable {}
            ) {
                Image(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = "Person",
                    modifier = Modifier
                        .size(20.dp)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clickable {}
            ) {
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search",
                    modifier = Modifier
                        .size(20.dp)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        navController.navigate("post")
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = "Add",
                    modifier = Modifier
                        .size(20.dp)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clickable {}
            ) {
                Image(
                    painter = painterResource(id = R.drawable.list),
                    contentDescription = "List",
                    modifier = Modifier
                        .size(20.dp)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clickable {}
            ) {
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home",
                    modifier = Modifier
                        .size(20.dp)
                )
            }
        }
    }
}
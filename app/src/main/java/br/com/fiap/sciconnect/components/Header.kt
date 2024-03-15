package br.com.fiap.sciconnect.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.sciconnect.R

@Composable
fun Header(darkmode:MutableState<Boolean>, admin: MutableState<Boolean>){
    Box() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(
                    if (darkmode.value) {
                        Color(49, 52, 57)
                    } else {
                        Color(255, 255, 255)
                    }
                )

        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Image(

                    painter = painterResource(
                           id = if (darkmode.value) R.drawable.minilogodark else R.drawable.minilogo
                    ),
                    contentDescription = "Logo",
                    Modifier.size(20.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    // vou mexer aqui
                    
                    Text(text = if (admin.value == true) {"admin"} else {""})
                    Spacer(modifier = Modifier.width(20.dp))
                    // até aqui
                    Image(
                        painter = painterResource(
                            id = if(darkmode.value) R.drawable.helpdark else R.drawable.help
                        ),
                        contentDescription = "Help",
                        Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Image(
                        painter = painterResource(
                            id = if(darkmode.value) R.drawable.alarmdark else R.drawable.alarm
                        ),
                        contentDescription = "Alarm",
                        Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

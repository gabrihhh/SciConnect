package br.com.fiap.sciconnect.methods

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.sciconnect.R

@Composable
fun Header(){
    Box() {
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
    }
}

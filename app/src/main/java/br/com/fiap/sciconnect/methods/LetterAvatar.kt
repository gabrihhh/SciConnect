package br.com.fiap.sciconnect.methods
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LetterAvatar(name:String){
    var letter = name.toCharArray()[0].uppercase()
    Box(
        modifier = Modifier
            .width(40.dp)
            .height(40.dp)
            .background(Color(49,52,57), shape = RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            fontSize = 25.sp,
            color = Color.White,
            text = letter,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }

}


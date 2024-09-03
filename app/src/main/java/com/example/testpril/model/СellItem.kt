package com.example.testpril.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testpril.R

@Composable
fun CellItem(cell: Cell){
    val imageResId = if (cell.IS_Alive) R.drawable.life else R.drawable.icon

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .height(70.dp)
            .background(Color.White)
            .padding(10.dp)
    ) {
        Box(){
            Image( painter = painterResource(id = imageResId), contentDescription = "image" )
        }
        Column {
            Text(
                modifier = Modifier.padding(start = 5.dp),
                text = if(cell.IS_Alive) "Живая клетка" else "Мёртвая клетка",
                fontSize = 20.sp, fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                modifier = Modifier.padding(start = 5.dp),
                text = if(cell.IS_Alive) "И шевелится !" else "Что-то не так",
                fontSize = 10.sp,
                color = Color.Black
            )
        }
    }
}
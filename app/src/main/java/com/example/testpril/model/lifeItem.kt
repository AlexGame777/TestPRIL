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
import androidx.compose.material3.AlertDialogDefaults.shape
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
fun lifeItem(){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .height(70.dp)
            .background(Color.White)
            .padding(8.dp)
    ) {
        Box(){
            Image( painter = painterResource(id = R.drawable.flowers), contentDescription = "image" )
        }
        Column {
            Text(
                modifier = Modifier.padding(start = 5.dp),
                text = "Жизнь",
                color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp
            )
            Text(
                modifier = Modifier.padding(start = 5.dp),
                text = "Выжил как-то",
                color = Color.Black, fontSize = 10.sp
            )
        }

    }
}
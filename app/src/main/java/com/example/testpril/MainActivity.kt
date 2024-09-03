package com.example.testpril

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testpril.back.add
import com.example.testpril.model.Cell
import com.example.testpril.model.CellItem
import com.example.testpril.model.Life
import com.example.testpril.model.lifeItem
import com.example.testpril.ui.theme.TestPRILTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Composable
fun App(){
    val darkMagenta = Color(100, 0, 100)
    val gradientBrush = Brush.linearGradient(
        colors = listOf(darkMagenta, Color.Black),
        start = Offset(500f, 0f),
        end = Offset(1000f, 1000f)
    )

    val cells = remember {
        mutableStateListOf<Any>()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBrush)
    ) {
        Text(text = "Клеточное наполнение", fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 70.dp, bottom = 40.dp), textAlign = TextAlign.Center)
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 20.dp, start = 30.dp, end = 30.dp)
        ) {
            items(cells.size) { index ->
                val item = cells[index]
                if (item is Cell) {
                    CellItem(cell = item)
                } else if (item is Life) {
                    lifeItem()
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Button(
            onClick = { add(cells) },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 80.dp, start = 30.dp, end = 30.dp)
        ) {
            Text("Сотворить", fontSize = 20.sp, )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App()
}
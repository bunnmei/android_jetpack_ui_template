package com.example.android_jetpack_ui_template.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.unit.dp

@Composable
fun Grid() {
    val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ){
        LazyVerticalGrid(
//            columns = GridCells.Adaptive(minSize = 60.dp,),
//            contentPadding = PaddingValues(
//                start = 12.dp,
//                top = 16.dp,
//                end = 12.dp,
//                bottom = 16.dp
//            ),
            columns = GridCells.Fixed(5),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(numbers) { num ->
                TextGrid(str = num)
            }
        }
    }


//    縦並べ
//    LazyColumn {
//        items(numbers) { num ->
//            Text(
//                text = "$num",
//                modifier = Modifier
//                    .size(width = 60.dp, height = 60.dp)
//                    .background(Color.Gray)
//            )
//        }
//    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun TextGrid(str: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
//            .size(width = 60.dp, height = 60.dp)
            .aspectRatio(1f)
            .background(Color.Gray, RoundedCornerShape(20))
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "$str",
        )
        Spacer(modifier = Modifier.weight(1f))
    }

}
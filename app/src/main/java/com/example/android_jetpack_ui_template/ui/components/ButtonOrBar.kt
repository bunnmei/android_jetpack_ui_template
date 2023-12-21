package com.example.android_jetpack_ui_template.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonOrBar() {
    Column() {
        SwitchPanel()
        MySliderDemo()
    }
}

@Composable
fun SwitchPanel() {
    val checkedState = remember {
        mutableStateOf(true)
    }
    Row(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "BTN")
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it }
        )
    }
}

@Composable
fun MySliderDemo() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Text(text = sliderPosition.toString())
    Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
}
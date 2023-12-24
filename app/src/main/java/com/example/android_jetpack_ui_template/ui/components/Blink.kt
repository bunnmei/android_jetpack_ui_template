package com.example.android_jetpack_ui_template.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Blink(modifier: Modifier = Modifier) {
    var state by remember {
        mutableStateOf(true)
    }
    var clic by remember {
        mutableStateOf(true)
    }
    val thread: MutableState<Thread?> = remember { mutableStateOf(null) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(if (state) Color.Red else Color.White)
            .clickable {

                if (clic) {

                    thread.value = Thread{
                        try {
                            while (true){
                                Thread.sleep(50)
                                state = !state
                            }
                        } catch(_:InterruptedException) {
                            println("例外が呼ばれたよ")
                        }
                    }
                    thread.value!!.start()
                    clic = !clic
                } else {
                    if (thread.value != null) {
                        thread.value!!.interrupt()
                        thread.value = null
                        clic = !clic
                    }
                }
            }
    ) {

    }
}


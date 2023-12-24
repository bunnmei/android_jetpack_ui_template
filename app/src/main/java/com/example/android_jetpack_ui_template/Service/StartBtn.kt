package com.example.android_jetpack_ui_template.Service

import android.app.Application
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun StartBtn(modifier: Modifier = Modifier, startService: (inte: Intent) -> Unit) {
    val appCtx = LocalContext.current
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            Intent(appCtx.applicationContext, RunningService::class.java).also {
                it.action = RunningService.Actions.START.toString()
                startService(it)
            }
        }) {
            Text(text = "Start run")
        }

        Button(onClick = {
            Intent(appCtx.applicationContext, RunningService::class.java).also {
                it.action = RunningService.Actions.STOP.toString()
                startService(it)
            }
        }) {
            Text(text = "Stop run")
        }
    }
}
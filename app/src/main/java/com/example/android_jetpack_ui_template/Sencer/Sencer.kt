package com.example.android_jetpack_ui_template.Sencer

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.getSystemService

@Composable
fun Sencer(modifier: Modifier = Modifier) {
    val ctx = LocalContext.current
//    val sencerManager: SensorManager = ctx.getSystemService(Context.SENSOR_SERVICE) as SensorManager
//    val deviceSensor: List<Sensor> = sencerManager.getSensorList(Sensor.TYPE_ALL)

    var sensorData by remember { mutableStateOf(0f) }

    DisposableEffect(Unit) {
        val senMan = ctx.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val lightSensor = senMan.getDefaultSensor(Sensor.TYPE_LIGHT)

        val sensorListener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                event?.let {
                    sensorData = it.values[0]
                }
            }
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
//                TODO("Not yet implemented")
            }
        }

        senMan.registerListener(sensorListener, lightSensor, SensorManager.SENSOR_DELAY_NORMAL)

        onDispose {
            senMan.unregisterListener(sensorListener)
        }
    }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "$sensorData")
        Text(text = if(sensorData < 50) "暗いよ" else "明るいよ")

//        センサー一覧取得
//        deviceSensor.forEach {
//            Text(text = "${it.stringType}---${it.name}")
//        }

    }
}
package com.example.snakesandladders.utils

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import kotlin.math.sqrt

@Composable
fun ShakeRollDetector(enabled: Boolean, onShake: () -> Unit) {
    val context = LocalContext.current

    DisposableEffect(enabled) {
        if (!enabled) {
            onDispose {}
        } else {
            val sensorManager = context.getSystemService(android.content.Context.SENSOR_SERVICE) as SensorManager
            val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
            var lastShakeTime = 0L

            val listener = object : SensorEventListener {
                override fun onSensorChanged(event: SensorEvent?) {
                    if (event == null) return
                    val x = event.values[0]
                    val y = event.values[1]
                    val z = event.values[2]
                    val gForce = sqrt(x * x + y * y + z * z) / SensorManager.GRAVITY_EARTH
                    val currentTime = System.currentTimeMillis()
                    if (gForce > Constants.ShakeThreshold && currentTime - lastShakeTime > Constants.ShakeCooldownMs) {
                        lastShakeTime = currentTime
                        onShake()
                    }
                }

                override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) = Unit
            }

            if (accelerometer != null) {
                sensorManager.registerListener(listener, accelerometer, SensorManager.SENSOR_DELAY_UI)
            }

            onDispose { sensorManager.unregisterListener(listener) }
        }
    }
}

package com.example.snakesandladders.voice

import android.speech.tts.TextToSpeech
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import java.util.Locale

@Composable
fun rememberTextSpeaker(): (String) -> Unit {
    val context = LocalContext.current
    var textToSpeech by remember { mutableStateOf<TextToSpeech?>(null) }
    var isTtsReady by remember { mutableStateOf(false) }
    var pendingText by remember { mutableStateOf<String?>(null) }

    DisposableEffect(Unit) {
        var ttsInstance: TextToSpeech? = null
        ttsInstance = TextToSpeech(context.applicationContext) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = ttsInstance?.setLanguage(Locale.US)
                if (result != TextToSpeech.LANG_MISSING_DATA && result != TextToSpeech.LANG_NOT_SUPPORTED) {
                    textToSpeech = ttsInstance
                    isTtsReady = true
                    pendingText?.let { text ->
                        ttsInstance?.speak(text, TextToSpeech.QUEUE_FLUSH, null, System.currentTimeMillis().toString())
                        pendingText = null
                    }
                }
            }
        }
        onDispose {
            ttsInstance?.stop()
            ttsInstance?.shutdown()
        }
    }

    return { text ->
        if (isTtsReady && textToSpeech != null) {
            textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, System.currentTimeMillis().toString())
        } else {
            pendingText = text
        }
    }
}

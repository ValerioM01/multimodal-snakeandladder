package com.example.snakesandladders.voice

import android.content.Context

class SpeechRecognizerManager {
    fun startListening(
        context: Context,
        onResult: (String) -> Unit,
        onError: (String) -> Unit
    ) {
        onError("Implement SpeechRecognizer logic here")
    }
}

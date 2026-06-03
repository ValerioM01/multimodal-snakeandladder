package com.example.snakesandladders.voice

import android.content.Context
import com.example.snakesandladders.game.commandConfigs

fun loadVoiceCommands(context: Context): Map<String, String> {
    val prefs = context.getSharedPreferences("voice_commands", Context.MODE_PRIVATE)
    return commandConfigs.associate { config ->
        config.key to (prefs.getString(config.key, config.defaultWord) ?: config.defaultWord)
    }
}

fun saveVoiceCommand(context: Context, key: String, value: String) {
    val prefs = context.getSharedPreferences("voice_commands", Context.MODE_PRIVATE)
    prefs.edit().putString(key, value.trim()).apply()
}

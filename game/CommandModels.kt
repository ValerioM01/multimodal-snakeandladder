package com.example.snakesandladders.game

data class CommandConfig(
    val key: String,
    val title: String,
    val defaultWord: String
)

val commandConfigs = listOf(
    CommandConfig("START", "Start", "start"),
    CommandConfig("NEXT", "Next", "next"),
    CommandConfig("BACK", "Back", "back"),
    CommandConfig("ROLL_DICE", "Roll Dice", "roll dice"),
    CommandConfig("RESTART", "Restart", "restart"),
    CommandConfig("BACK_TO_SETUP", "Back To Setup", "setup"),
    CommandConfig("INFO", "Info", "info")
)

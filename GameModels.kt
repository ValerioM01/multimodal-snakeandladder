package com.example.snakesandladders.game

import androidx.compose.ui.graphics.Color

enum class AppScreen {
    HOME,
    SETUP,
    GAME
}

data class Player(
    val name: String,
    val shortName: String,
    val color: Color,
    val position: Int = 0
)

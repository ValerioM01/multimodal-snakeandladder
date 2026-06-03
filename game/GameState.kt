package com.example.snakesandladders.game

import com.example.snakesandladders.utils.AppColors

data class GameState(
    val currentScreen: AppScreen = AppScreen.HOME,
    val player1NameInput: String = "Player1",
    val player2NameInput: String = "Player2",
    val players: List<Player> = listOf(
        Player("Player1", "P1", AppColors.PlayerOne),
        Player("Player2", "P2", AppColors.PlayerTwo)
    ),
    val currentPlayerIndex: Int = 0,
    val diceValue: Int = 1,
    val winnerName: String? = null,
    val isMoving: Boolean = false,
    val isVoiceActive: Boolean = false,
    val voiceStatus: String = "Tap once to enable voice control",
    val lastVoiceCommand: String = "Voice command: none",
    val selectedButton: String? = null,
    val isButtonGuideEnabled: Boolean = true,
    val commandWords: Map<String, String> = emptyMap()
)

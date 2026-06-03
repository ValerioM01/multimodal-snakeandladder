package com.example.snakesandladders.game

import androidx.lifecycle.ViewModel
import com.example.snakesandladders.utils.AppColors
import kotlin.random.Random

class GameController : ViewModel() {
    var state = GameState()
        private set

    fun navigateTo(screen: AppScreen) {
        state = state.copy(currentScreen = screen, selectedButton = null)
    }

    fun updatePlayerName(index: Int, value: String) {
        state = if (index == 0) state.copy(player1NameInput = value) else state.copy(player2NameInput = value)
    }

    fun setCommandWords(commandWords: Map<String, String>) {
        state = state.copy(commandWords = commandWords)
    }

    fun setSelectedButton(value: String?) {
        state = state.copy(selectedButton = value)
    }

    fun toggleButtonGuide() {
        state = state.copy(isButtonGuideEnabled = !state.isButtonGuideEnabled, selectedButton = null)
    }

    fun setVoiceActive(value: Boolean, status: String) {
        state = state.copy(isVoiceActive = value, voiceStatus = status)
    }

    fun setLastVoiceCommand(value: String) {
        state = state.copy(lastVoiceCommand = value)
    }

    fun startGame() {
        val firstName = state.player1NameInput.trim().ifBlank { "Player1" }
        val secondName = state.player2NameInput.trim().ifBlank { "Player2" }
        state = state.copy(
            currentScreen = AppScreen.GAME,
            players = listOf(
                Player(firstName, "P1", AppColors.PlayerOne),
                Player(secondName, "P2", AppColors.PlayerTwo)
            ),
            currentPlayerIndex = 0,
            diceValue = 1,
            winnerName = null,
            isMoving = false
        )
    }

    fun restartGame() {
        state = state.copy(
            players = state.players.map { it.copy(position = 0) },
            currentPlayerIndex = 0,
            diceValue = 1,
            winnerName = null,
            isMoving = false
        )
    }

    fun rollDicePreview(): Int {
        val dice = Random.nextInt(1, 7)
        state = state.copy(diceValue = dice)
        return dice
    }
}

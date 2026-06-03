package com.example.snakesandladders.ui.screens

import androidx.compose.runtime.Composable
import com.example.snakesandladders.game.Player

@Composable
fun GameScreen(
    players: List<Player>,
    currentPlayer: Int,
    diceValue: Int,
    winnerName: String?,
    isMoving: Boolean,
    onRollDice: () -> Unit,
    onRestart: () -> Unit,
    onBackToSetup: () -> Unit
) {
    // Move the original GameScreen UI here.
}

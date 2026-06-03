package com.example.snakesandladders.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.snakesandladders.game.AppScreen
import com.example.snakesandladders.game.GameViewModel
import com.example.snakesandladders.ui.screens.GameScreen
import com.example.snakesandladders.ui.screens.HomeScreen
import com.example.snakesandladders.ui.screens.SetupScreen

@Composable
fun AppRoot(viewModel: GameViewModel = viewModel()) {
    val state = viewModel.state

    when (state.currentScreen) {
        AppScreen.HOME -> HomeScreen(onStartClick = { viewModel.navigateTo(AppScreen.SETUP) })
        AppScreen.SETUP -> SetupScreen(
            player1Name = state.player1NameInput,
            player2Name = state.player2NameInput,
            onPlayer1NameChange = { viewModel.updatePlayerName(0, it) },
            onPlayer2NameChange = { viewModel.updatePlayerName(1, it) },
            onBackClick = { viewModel.navigateTo(AppScreen.HOME) },
            onNextClick = { viewModel.startGame() }
        )
        AppScreen.GAME -> GameScreen(
            players = state.players,
            currentPlayer = state.currentPlayerIndex,
            diceValue = state.diceValue,
            winnerName = state.winnerName,
            isMoving = state.isMoving,
            onRollDice = { viewModel.rollDice() },
            onRestart = { viewModel.restartGame() },
            onBackToSetup = { viewModel.navigateTo(AppScreen.SETUP) }
        )
    }
}

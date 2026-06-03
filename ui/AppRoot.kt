package com.example.snakesandladders.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.snakesandladders.game.AppScreen
import com.example.snakesandladders.game.GameController
import com.example.snakesandladders.ui.screens.CommandSettingsScreen
import com.example.snakesandladders.ui.screens.GameScreen
import com.example.snakesandladders.ui.screens.HomeScreen
import com.example.snakesandladders.ui.screens.SetupScreen

@Composable
fun AppRoot(controller: GameController = viewModel()) {
    val state = controller.state

    when (state.currentScreen) {
        AppScreen.HOME -> HomeScreen(
            isVoiceActive = state.isVoiceActive,
            voiceStatus = state.voiceStatus,
            lastVoiceCommand = state.lastVoiceCommand,
            selectedButton = state.selectedButton,
            isButtonGuideEnabled = state.isButtonGuideEnabled,
            onSelectedButtonChange = controller::setSelectedButton,
            speak = {},
            onStartClick = { controller.navigateTo(AppScreen.SETUP) },
            onCommandSettingsClick = { controller.navigateTo(AppScreen.COMMAND_SETTINGS) },
            onToggleButtonGuide = controller::toggleButtonGuide,
            onToggleVoice = {}
        )
        AppScreen.SETUP -> SetupScreen(
            player1Name = state.player1NameInput,
            player2Name = state.player2NameInput,
            isVoiceActive = state.isVoiceActive,
            voiceStatus = state.voiceStatus,
            lastVoiceCommand = state.lastVoiceCommand,
            selectedButton = state.selectedButton,
            isButtonGuideEnabled = state.isButtonGuideEnabled,
            onSelectedButtonChange = controller::setSelectedButton,
            speak = {},
            onPlayer1NameChange = { controller.updatePlayerName(0, it) },
            onPlayer2NameChange = { controller.updatePlayerName(1, it) },
            onBackClick = { controller.navigateTo(AppScreen.HOME) },
            onNextClick = controller::startGame,
            onToggleVoice = {}
        )
        AppScreen.GAME -> GameScreen(
            players = state.players,
            currentPlayer = state.currentPlayerIndex,
            diceValue = state.diceValue,
            winnerName = state.winnerName,
            isVoiceActive = state.isVoiceActive,
            voiceStatus = state.voiceStatus,
            lastVoiceCommand = state.lastVoiceCommand,
            selectedButton = state.selectedButton,
            isButtonGuideEnabled = state.isButtonGuideEnabled,
            isMoving = state.isMoving,
            onSelectedButtonChange = controller::setSelectedButton,
            speak = {},
            onRollDice = controller::rollDicePreview,
            onInfoClick = {},
            onRestart = controller::restartGame,
            onBackToSetup = { controller.navigateTo(AppScreen.SETUP) },
            onToggleVoice = {}
        )
        AppScreen.COMMAND_SETTINGS -> CommandSettingsScreen(
            commandWords = state.commandWords,
            selectedButton = state.selectedButton,
            isButtonGuideEnabled = state.isButtonGuideEnabled,
            onSelectedButtonChange = controller::setSelectedButton,
            speak = {},
            onSaveCommand = { _, _ -> },
            onBackClick = { controller.navigateTo(AppScreen.HOME) }
        )
    }
}

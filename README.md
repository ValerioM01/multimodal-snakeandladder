# Snakes and Ladders Android Game

Accessible Snakes and Ladders game for Android built with **Jetpack Compose**. The project includes a visual board, turn-based gameplay, voice commands, text-to-speech feedback, and haptic feedback.

## Features

- Jetpack Compose UI with three screens: Home, Setup, and Game.
- Turn-based Snakes and Ladders gameplay with animated token movement.
- Voice control using Android `SpeechRecognizer`.
- Spoken feedback using Android `TextToSpeech`.
- Haptic feedback for dice rolls, movement, ladders, snakes, and win states.
- Accessible interaction model with double-tap style button confirmation.

## Project Structure

```text
app/src/main/java/com/example/snakesandladders/
├── MainActivity.kt
├── game/
│   ├── BoardConfig.kt
│   ├── GameModels.kt
│   ├── GameState.kt
│   └── GameViewModel.kt
├── ui/
│   ├── AppRoot.kt
│   ├── components/
│   │   ├── AccessibleButton.kt
│   │   ├── BoardView.kt
│   │   ├── PlayerInfoCard.kt
│   │   ├── PlayerNameInput.kt
│   │   ├── ScreenBackground.kt
│   │   └── VoiceControlButton.kt
│   └── screens/
│       ├── GameScreen.kt
│       ├── HomeScreen.kt
│       └── SetupScreen.kt
├── voice/
│   ├── SpeechRecognizerManager.kt
│   └── TextSpeaker.kt
└── utils/
    ├── AppColors.kt
    ├── Constants.kt
    └── VibrationUtils.kt
```

## Why this refactor

The original version keeps UI, state, game logic, voice recognition, TTS, vibration, and board math in a single file. Splitting those responsibilities makes the codebase easier to read, test, maintain, and present as a professional GitHub repository.

## Suggested next steps

1. Move data classes and enums into `game/`.
2. Extract board paths and game rules into `BoardConfig` and `GameViewModel`.
3. Keep composables stateless where possible and pass state via parameters.
4. Move TTS and speech recognition into dedicated helpers.
5. Add screenshots and a short demo GIF to the repo.
6. Add unit tests for board movement and voice command parsing.

## GitHub checklist

- Add screenshots in `docs/`.
- Add a short demo video or GIF.
- Add a license file.
- Add issues labels and a simple project board.
- Enable GitHub Actions for Android lint and build.

## Example commit history

- `feat: add home, setup and game flow`
- `feat: add speech recognition and spoken feedback`
- `refactor: move game rules into GameViewModel`
- `docs: add README architecture and screenshots`

## Topics for the GitHub repo

`android` `jetpack-compose` `kotlin` `accessibility` `speech-recognition` `text-to-speech` `board-game`

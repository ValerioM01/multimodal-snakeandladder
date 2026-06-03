# Snakes and Ladders Android Game

A refactored GitHub-ready structure for an Android **Jetpack Compose** Snakes and Ladders game with accessibility-focused interaction. The latest source includes voice control, configurable commands, shake-to-roll, text-to-speech, haptic feedback, and multiple app screens.

## Current app features

- Home, setup, game, and command settings screens.
- Voice control with customizable spoken commands.
- Text-to-speech guidance and game status narration.
- Shake gesture to roll the dice.
- Haptic feedback for gameplay events.
- Dynamic board rendering with token movement.
- Accessibility-oriented button guide mode.

## Why refactor it

The latest version places app navigation, game rules, command matching, speech recognition, sensor handling, persistence, and all Compose screens inside a single file. That makes the app harder to maintain, test, and present cleanly in a public repository.

## Recommended architecture

```text
app/src/main/java/com/example/snakesandladders/
├── MainActivity.kt
├── game/
│   ├── BoardConfig.kt
│   ├── CommandModels.kt
│   ├── GameModels.kt
│   ├── GameState.kt
│   └── GameController.kt
├── ui/
│   ├── AppRoot.kt
│   ├── components/
│   │   ├── AccessibleButton.kt
│   │   ├── BoardView.kt
│   │   ├── ButtonGuideToggle.kt
│   │   ├── CommandSettingRow.kt
│   │   ├── PlayerInfo.kt
│   │   ├── PlayerNameInput.kt
│   │   ├── ScreenBackground.kt
│   │   └── VoiceControlButton.kt
│   └── screens/
│       ├── CommandSettingsScreen.kt
│       ├── GameScreen.kt
│       ├── HomeScreen.kt
│       └── SetupScreen.kt
├── voice/
│   ├── SpeechRecognition.kt
│   ├── TextSpeaker.kt
│   └── VoiceCommandStore.kt
└── utils/
    ├── AppColors.kt
    ├── Constants.kt
    ├── SensorUtils.kt
    └── VibrationUtils.kt
```

## Mapping from the current file

| Current responsibility | New file |
|---|---|
| `AppScreen`, `Player` | `game/GameModels.kt` |
| `CommandConfig`, command list | `game/CommandModels.kt` |
| `loadVoiceCommands`, `saveVoiceCommand` | `voice/VoiceCommandStore.kt` |
| `normalizeCommand`, `similarity`, `levenshteinDistance`, `commandMatches` | `voice/SpeechRecognition.kt` |
| `rememberTextSpeaker` | `voice/TextSpeaker.kt` |
| `vibrateDevice` | `utils/VibrationUtils.kt` |
| `ShakeRollDetector` | `utils/SensorUtils.kt` |
| `BoardView`, `getCellOffset` | `ui/components/BoardView.kt` |
| `AccessibleButton`, `VoiceControlButton`, `ButtonGuideToggle` | `ui/components/` |
| `HomeScreen`, `SetupScreen`, `GameScreen`, `CommandSettingsScreen` | `ui/screens/` |
| central state inside `SnakesAndLaddersApp()` | `game/GameState.kt` + `game/GameController.kt` |

## GitHub polish checklist

- Add screenshots in `docs/`.
- Add a short GIF of gameplay and command settings.
- Add a section about accessibility and voice interaction.
- Add unit tests for command matching and board movement.
- Add instrumentation tests for navigation and screen actions.
- Add a GitHub Actions workflow for build and lint.

## Suggested repository name

`snakes-and-ladders-accessible-android`

## Suggested topics

`android` `kotlin` `jetpack-compose` `accessibility` `speech-recognition` `text-to-speech` `board-game` `mobile-game`

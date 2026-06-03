package com.example.snakesandladders.game

object BoardConfig {
    const val BOARD_SIZE = 100

    val ladderPaths = mapOf(
        4 to listOf(4, 16, 17, 25),
        21 to listOf(21, 39),
        29 to listOf(29, 32, 33, 48, 53, 67, 74),
        43 to listOf(43, 57, 64, 76),
        63 to listOf(63, 62, 79, 80),
        71 to listOf(71, 89)
    )

    val snakePaths = mapOf(
        30 to listOf(30, 12, 13, 7),
        47 to listOf(47, 46, 36, 35, 27, 15),
        56 to listOf(56, 44, 38, 23, 19),
        73 to listOf(73, 69, 51),
        82 to listOf(82, 79, 62, 59, 42),
        92 to listOf(92, 88, 75),
        98 to listOf(98, 97, 83, 84, 85, 77, 64, 76, 65, 55)
    )
}

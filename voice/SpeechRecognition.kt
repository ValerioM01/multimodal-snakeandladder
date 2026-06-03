package com.example.snakesandladders.voice

import java.util.Locale

fun normalizeCommand(value: String): String {
    return value
        .lowercase(Locale.getDefault())
        .trim()
        .replace("ı", "i")
        .replace("ğ", "g")
        .replace("ü", "u")
        .replace("ş", "s")
        .replace("ö", "o")
        .replace("ç", "c")
        .replace(Regex("[^a-z0-9 ]"), "")
        .replace(Regex("\\s+"), " ")
}

fun consonantSkeleton(value: String): String {
    return normalizeCommand(value).replace(Regex("[aeiou ]"), "")
}

fun levenshteinDistance(first: String, second: String): Int {
    val dp = Array(first.length + 1) { IntArray(second.length + 1) }
    for (i in 0..first.length) dp[i][0] = i
    for (j in 0..second.length) dp[0][j] = j
    for (i in 1..first.length) {
        for (j in 1..second.length) {
            val cost = if (first[i - 1] == second[j - 1]) 0 else 1
            dp[i][j] = minOf(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + cost)
        }
    }
    return dp[first.length][second.length]
}

fun similarity(first: String, second: String): Double {
    if (first.isEmpty() || second.isEmpty()) return 0.0
    val distance = levenshteinDistance(first, second)
    val maxLength = maxOf(first.length, second.length)
    return 1.0 - distance.toDouble() / maxLength.toDouble()
}

fun commandMatches(spokenCommand: String, savedCommand: String, aliases: List<String> = emptyList()): Boolean {
    val spoken = normalizeCommand(spokenCommand)
    val spokenSkeleton = consonantSkeleton(spoken)
    val savedCommands = savedCommand.split("|").map { it.trim() }.filter { it.isNotEmpty() }
    val allCommands = savedCommands + aliases
    return allCommands.any { command ->
        val saved = normalizeCommand(command)
        val savedSkeleton = consonantSkeleton(saved)
        if (saved.isEmpty()) false else {
            spoken.contains(saved) ||
            (saved.contains(spoken) && spoken.length >= 2) ||
            similarity(spoken, saved) >= 0.55 ||
            (spokenSkeleton.length >= 2 && savedSkeleton.length >= 2 && spokenSkeleton == savedSkeleton)
        }
    }
}

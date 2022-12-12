package com.adoc.adoc2022.ch2

import com.adoc.getInputAsArray

val handTranslations = mapOf(
    "A" to "ROCK", "X" to "ROCK",
    "B" to "PAPER", "Y" to "PAPER",
    "C" to "SCISSOR", "Z" to "SCISSOR"
)

val scores = mapOf("ROCK" to 1, "PAPER" to 2, "SCISSOR" to 3)

fun outcome(elf: String, player: String): Int {
    val playerHand = handTranslations[player]
    val winScore = when (handTranslations[elf]) {
        "ROCK" -> when (playerHand) {
            "ROCK" -> 3
            "PAPER" -> 6
            "SCISSOR" -> 0
            else -> throw Exception("invalid hand")
        }
        "PAPER" -> when (playerHand) {
            "ROCK" -> 0
            "PAPER" -> 3
            "SCISSOR" -> 6
            else -> throw Exception("invalid hand")
        }
        "SCISSOR" -> when (playerHand) {
            "ROCK" -> 6
            "PAPER" -> 0
            "SCISSOR" -> 3
            else -> throw Exception("invalid hand")
        }
        else -> throw Exception("invalid data")
    }

    return winScore + (scores[playerHand] ?: throw Exception("invalid data"))
}

fun main() = println(getInputAsArray(2022, 2).sumOf {
    with(it.split(" ")) {
        outcome(this[0], this[1])
    }
})

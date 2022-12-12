package com.adoc.adoc2022.ch1

fun main() {
    println(getElves().map {
        it.map { s ->
            s.toInt()
        }
    }.sortedBy { it.sum()
    }.reversed().subList(0, 3).sumOf { it.sum() })
}
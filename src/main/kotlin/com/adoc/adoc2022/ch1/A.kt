package com.adoc.adoc2022.ch1

import com.adoc.*

fun getElves() = getInputAsString(2022, 1)
    .split("\n\n")
    .map {
        it.split("\n").filter { s -> s != "" }
    }

fun main() {
    println(getElves().maxOf { l -> l.sumOf { v -> v.toInt() } })
}
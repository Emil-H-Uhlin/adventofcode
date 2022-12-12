package com.adoc

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.net.URL

fun getInput(year: Int, day: Int): BufferedReader {
    // open file with format 'YYYY-dayXX.txt
    val file = File("./${year}-day${if (day < 10 ) "0${day}" else day}.txt")

    return if (file.isFile) file.bufferedReader()
    else {
        val conn = URL("https://adventofcode.com/${year}/day/${day}/input")
            .openConnection().apply {
                setRequestProperty("method", "GET")
                setRequestProperty(
                    "Cookie", "session=" + System.getenv("adoc_session_token")
                )
            }

        file.writeText(BufferedReader(InputStreamReader(conn.getInputStream())).readText())
        return file.bufferedReader()
    }
}

fun getInputAsArray(year: Int, day: Int): List<String> = getInput(year, day).readLines()
fun getInputAsString(year: Int, day: Int): String = getInput(year, day).readText()

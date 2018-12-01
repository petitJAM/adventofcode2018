@file:JvmName("Main")

import days.day1

fun main(args: Array<String>) {
    println("Advent of Code 2018")
    io()
}

private val days = (1..25).map(Int::toString)

private fun io() {
    printWelcome()

    ioLoop@ while (true) {
        val input = readLine() ?: break
        when (input) {
            "q", "quit" -> {
                break@ioLoop
            }
            "\n" -> {
                printWelcome()
            }
            in days -> run(input)
            else -> println("Unknown input D: <$input>")
        }
        println()
    }

    println("Bye!")
}

private fun printWelcome() {
    println("Enter day number of 'q' to quit: ")
}

private fun run(day: String) {
    when (day) {
        "1" -> day1()
        else -> println("Day incomplete")
    }
}

package days

import readInputFile

fun day1() {
    val input = readInputFile("inputs/day1.txt")
    println(day1part1(input))
    println(day1part2(input))
}

fun day1part1(input: String): Int {
    return parseInput(input).sum()
}

fun day1part2(input: String): Int {
    var currentFrequency = 0
    val seenFrequencies = mutableSetOf(currentFrequency)

    parseInput(input).asRepeatedSequence().forEach { change ->
        currentFrequency += change
        if (!seenFrequencies.add(currentFrequency)) return currentFrequency
    }
    throw Error("how did we get here?")
}

private fun parseInput(input: String): List<Int> {
    return input.split("\n").map(String::toInt)
}

private fun <T> List<T>.asRepeatedSequence() =
    generateSequence(0) {
        (it + 1) % this.size
    }.map(::get)

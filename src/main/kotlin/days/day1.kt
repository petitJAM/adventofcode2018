package days

import readInputFile

fun day1() {
    val input = readInputFile("inputs/day1.txt")
    println(solve1(input))
    println(solve2(input))
}

fun solve1(input: String): Int {
    return parseInput(input).sum()
}

fun solve2(input: String): Int {
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

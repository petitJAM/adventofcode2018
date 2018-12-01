package days

import readInputFile

fun day1() {
    val input = readInputFile("inputs/day1.txt")
    val answer = solve(input)
    println(answer)
}

fun solve(input: String): Int {
    return parseInput(input).sum()
}

private fun parseInput(input: String): List<Int> {
    return input.split("\n").map(String::toInt)
}
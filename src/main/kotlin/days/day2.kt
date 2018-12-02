package days

import readInputFile

fun day2() {
    val input = readInputFile("inputs/day2.txt")
    println(day2part1(input))
}

fun day2part1(input: String): Int {
    return parseInput(input)
        .map(String::toCharArray)
        .map { chars -> chars.groupBy { it } }
        .map { map -> map.mapValues { (_, v) -> v.size } }
        .map { it.values.toList() }
        .map { list ->
            list.filter { it == 2 || it == 3 }
                .distinct()
                .groupBy { it }
        }
        .flatMap { map ->
            map.keys
        }
        .groupBy { it }
        .mapValues { (_, v) -> v.size }
        .values
        .reduce { acc, i -> acc * i }
}

fun day2part2(input: String): Any {
    TODO()
}

private fun parseInput(input: String): List<String> {
    return input.split("\n")
}

//private fun day2part1alt(input: String): Int {
//    return parseInput(input)
//        .map(String::toCharArray)
//        .map(CharArray::toList)
//        .map { chars ->
//            chars.groupBy { it }
//                .filterValues { it.size == 2 || it.size == 3 }
//                .values
//                .toList()
//                .map(List<Char>::size)
//                .distinct()
//        }
//        .map { list ->
//            if (list.contains(2) && list.contains(3)) {
//                Pair(1, 1)
//            } else if (list.contains(2)) {
//                Pair(1, 0)
//            } else if (list.contains(3)) {
//                Pair(0, 1)
//            } else {
//                Pair(0, 0)
//            }
//        }
//        .reduce { acc, pair ->
//            Pair(acc.first + pair.first, acc.second + pair.second)
//        }
//        .let { it.first * it.second }
//}

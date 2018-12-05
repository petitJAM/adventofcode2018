package days

import readInputFile

fun day3() {
    val input = readInputFile("inputs/day3.txt")
    println(day3part1(input))
    println(day3part2(input))
}

fun day3part1(input: String): Int {

    val pointCoverage = mutableMapOf<Pair<Int, Int>, Int>().withDefault { 0 }

    val claims = day3parseInput(input)

    claims.forEach { claim ->
        claim.rangeX.forEach { x ->
            claim.rangeY.forEach { y ->
                val point = Pair(x, y)
                pointCoverage[point] = pointCoverage.getValue(point) + 1
            }
        }
    }

    val overlappingPoints = pointCoverage.filterValues { claimCount -> claimCount > 1 }

    return overlappingPoints.size
}

fun day3part2(input: String): String {
    val claimsOnEachPoint = mutableMapOf<Pair<Int, Int>, MutableList<Claim>>().withDefault { mutableListOf() }

    val claims = day3parseInput(input)

    claims.forEach { claim ->
        claim.rangeX.forEach { x ->
            claim.rangeY.forEach { y ->
                val point = Pair(x, y)
                val claimsAtPoint = claimsOnEachPoint[point] ?: mutableListOf()
                claimsAtPoint.add(claim)
                claimsOnEachPoint[point] = claimsAtPoint
            }
        }
    }

    val claimsThatOverlap = claimsOnEachPoint
        .filterValues { it.size > 1 }
        .values
        .flatten()
        .distinct()

    return claims.filterNot { it in claimsThatOverlap }.first().number
}

fun day3parseInput(input: String): List<Claim> {
    return input.split("\n")
        .map { line ->
            Regex("#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)")
                .find(line)
                ?.let { matchResult ->
                    matchResult.groups
                        .drop(1)
                        .map { matchGroup ->
                            matchGroup?.value
                                ?: throw IllegalArgumentException("Input doesn't conform as expected. $matchResult")
                        }
                }
                ?: throw IllegalArgumentException("Input doesn't conform as expected.")
        }
        .map { matches ->
            Claim(
                matches[0],
                matches[1].toInt(),
                matches[2].toInt(),
                matches[3].toInt(),
                matches[4].toInt()
            )
        }
}

data class Claim(
    val number: String,
    val startX: Int,
    val startY: Int,
    val width: Int,
    val height: Int
) {
    val endX: Int
        get() = startX + width

    val endY: Int
        get() = startY + height

    val rangeX: IntRange
        get() = (startX until endX)

    val rangeY: IntRange
        get() = (startY until endY)
}

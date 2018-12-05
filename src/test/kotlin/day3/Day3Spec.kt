package day3

import days.Claim
import days.day3parseInput
import days.day3part1
import days.day3part2
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

@Suppress("unused")
object Day3Spec : Spek({

    describe("Day 3") {

        val input1 = """
            #1 @ 1,3: 4x4
            #2 @ 3,1: 4x4
            #3 @ 5,5: 2x2
        """.trimIndent()

        val input2 = """
            #1 @ 4,5: 10x100
            #2 @ 100,50: 40x200
        """.trimIndent()

        describe("parser") {
            it("returns a list of claims when given puzzle input") {
                assertEquals(
                    listOf(
                        Claim("1", 1, 3, 4, 4),
                        Claim("2", 3, 1, 4, 4),
                        Claim("3", 5, 5, 2, 2)
                    ),
                    day3parseInput(input1)
                )

                assertEquals(
                    listOf(
                        Claim("1", 4, 5, 10, 100),
                        Claim("2", 100, 50, 40, 200)
                    ),
                    day3parseInput(input2)
                )
            }
        }

        describe("part 1") {
            it("returns the number of square inches with 2 or more claims") {
                assertEquals(4, day3part1(input1))
            }
        }

        describe("part 2") {
            it("finds the id of the only claim that doesn't overlap others") {
                assertEquals("3", day3part2(input1))
            }
        }
    }
})

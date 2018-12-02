package day2

import days.day2part1
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

@Suppress("unused")
object Day2Spec : Spek({

    describe("Day 2") {
        describe("Part 1") {
            val input1 = """
                abcdef
                bababc
                abbcde
                abcccd
                aabcdd
                abcdee
                ababab
            """.trimIndent()

            it("returns a checksum of the given input") {
                assertEquals(12, day2part1(input1))
            }
        }
    }
})
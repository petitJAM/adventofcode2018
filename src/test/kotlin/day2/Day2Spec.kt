package day2

import days.day2part1
import days.day2part2
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

@Suppress("unused", "SpellCheckingInspection")
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

            val input2 = """
                aaabb
                aabb
                aabb
                abc
                aaaa
                aabb
            """.trimIndent()

            val input3 = """
                aaa
                bbb
                aabbb
                aabb
                abc
                aaaa
                aaab
            """.trimIndent()

            it("returns a checksum of the given input") {
                assertEquals(12, day2part1(input1))
                assertEquals(4, day2part1(input2))
                assertEquals(8, day2part1(input3))
            }
        }

        describe("Part 2") {
            val input1 = """
                abcde
                fghij
                klmno
                pqrst
                fguij
                axcye
                wvxyz
            """.trimIndent()

            val input2 = """
                abcde
                xbcde
                xbyde
            """.trimIndent()

            val input3 = """
                abcdefghijkl
                xbcdefghijkl
            """.trimIndent()

            it("returns which characters are common between the two correct box ids") {
                assertEquals("fgij", day2part2(input1))
                assertEquals("bcde", day2part2(input2))
                assertEquals("bcdefghijkl", day2part2(input3))
            }
        }
    }
})

package day2

import days.day2part1
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

@Suppress("unused")
object Day2Spec : Spek({

    describe("Day 2") {
        describe("Part 1") {
            @Suppress("SpellCheckingInspection")
            val input1 = """
                abcdef
                bababc
                abbcde
                abcccd
                aabcdd
                abcdee
                ababab
            """.trimIndent()

            @Suppress("SpellCheckingInspection")
            val input2 = """
                aaabb
                aabb
                aabb
                abc
                aaaa
                aabb
            """.trimIndent()

            @Suppress("SpellCheckingInspection")
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
    }
})

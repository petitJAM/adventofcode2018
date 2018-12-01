package day1

import days.solve1
import days.solve2
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day1Spec : Spek({

    describe("day 1") {

        context("part 1") {
            val input1 by memoized {
                """
                +1
                +1
                +1
                """.trimIndent()
            }

            val input2 by memoized {
                """
                +1
                +1
                -2
                """.trimIndent()
            }

            val input3 by memoized {
                """
                -1
                -2
                -3
                """.trimIndent()
            }

            it("finds the sum of the numbers") {
                assertEquals(3, solve1(input1))
                assertEquals(0, solve1(input2))
                assertEquals(-6, solve1(input3))
            }
        }

        context("part 2") {
            val input1 by memoized {
                """
                    +1
                    -1
                """.trimIndent()
            }

            val input2 by memoized {
                """
                    +3
                    +3
                    +4
                    -2
                    -4
                """.trimIndent()
            }

            val input3 by memoized {
                """
                    -6
                    +3
                    +8
                    +5
                    -6
                """.trimIndent()
            }

            val input4 by memoized {
                """
                    +7
                    +7
                    -2
                    -7
                    -4
                """.trimIndent()
            }

            it("finds the first frequency that is reached twice") {
                assertEquals(0, solve2(input1))
                assertEquals(10, solve2(input2))
                assertEquals(5, solve2(input3))
                assertEquals(14, solve2(input4))
            }
        }
    }
})
package day1

import days.solve
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day1Spec : Spek({

    describe("day 1") {
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
            assertEquals(3, solve(input1))
            assertEquals(0, solve(input2))
            assertEquals(-6, solve(input3))
        }
    }
})
package util

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import readInputFile
import kotlin.test.assertEquals

object ReadInputFileSpec : Spek({

    describe("readInputFile") {
        it("reads the contents of a resource file") {
            assertEquals("hello\nworld", readInputFile("test.txt"))
        }
    }
})
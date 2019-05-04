package ru.pearx.kasechange.test

import ru.pearx.kasechange.CaseFormat
import kotlin.test.Test
import kotlin.test.assertEquals

class CaseFormatTest {
    @Test
    fun testCamel() {
        assertEquals("camelMeUpInside", CaseFormat.CAMEL.format("CAMEL", "mE", "Up", "inside"))
    }

    @Test
    fun testPascal() {
        assertEquals("PascalMeUpInside", CaseFormat.CAPITALIZED_CAMEL.format("paSCal", "ME", "up", "INside"))
    }

    @Test
    fun testSnake() {
        assertEquals("snake_me_up_inside", CaseFormat.LOWER_UNDERSCORE.format("SNAKE", "ME", "up", "INside"))
    }

    @Test
    fun testScreamingSnake() {
        assertEquals("DONT_MAKE_ME_SCREAM", CaseFormat.UPPER_UNDERSCORE.format("dont", "mAke", "ME", "scREAM"))
    }

    @Test
    fun testKebab() {
        assertEquals("i-like-kebabs", CaseFormat.LOWER_HYPHEN.format("I", "like", "KEbabs"))
    }

    @Test
    fun testTrain() {
        assertEquals("CHOO-CHOO-MTHRFCKRS", CaseFormat.UPPER_HYPHEN.format("choo", "CHOO", "mthrfckrs"))
    }

    @Test
    fun testLowerSpace() {
        assertEquals("some regular string", CaseFormat.LOWER_SPACE.format("SOME", "regUlar", "STRing"))
    }

    @Test
    fun testUpperSpace() {
        assertEquals("SOME REGULAR STRING", CaseFormat.UPPER_SPACE.format("SOME", "regUlar", "STRing"))
    }

    @Test
    fun testTitle() {
        assertEquals("Some Really Interesting Title", CaseFormat.CAPITALIZED_SPACE.format("somE", "Really", "interesting", "TITLE"))
    }

    @Test
    fun testDot() {
        assertEquals("dot.case.is.fun", CaseFormat.LOWER_DOT.format("dot", "Case", "is", "FUN"))
    }

    @Test
    fun testDotUpper() {
        assertEquals("DOT.CASE.IS.FUN", CaseFormat.UPPER_DOT.format("dot", "Case", "is", "FUN"))
    }
}
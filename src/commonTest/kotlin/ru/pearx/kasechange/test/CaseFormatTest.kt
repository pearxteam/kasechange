package ru.pearx.kasechange.test

import ru.pearx.kasechange.CaseFormat
import kotlin.test.Test
import kotlin.test.assertEquals

class CaseFormatTest {
    @Test
    fun testCamel() {
        assertEquals("camelMeUpInside", CaseFormat.LOWER_CAMEL.format("CAMEL", "mE", "Up", "inside"))
    }

    @Test
    fun testPascal() {
        assertEquals("PascalMeUpInside", CaseFormat.UPPER_CAMEL.format("paSCal", "ME", "up", "INside"))
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
}
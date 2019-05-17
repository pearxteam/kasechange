package net.pearx.kasechange.test

import net.pearx.kasechange.splitToWords
import kotlin.test.Test
import kotlin.test.assertEquals

class SplitToWordsTest {
    @Test
    fun testSplittingCharacters() {
        assertEquals(listOf("snake", "case"), "snake_case".splitToWords())
        assertEquals(listOf("kebab", "case"), "kebab-case".splitToWords())
        assertEquals(listOf("space", "case"), "space case".splitToWords())
        assertEquals(listOf("some", "util", "random"), "some-util_random".splitToWords())
        assertEquals(listOf("java", "util", "Arrays"), "java.util.Arrays".splitToWords())
    }

    @Test
    fun testLetterCase() {
        assertEquals(listOf("camel", "Cased", "String"), "camelCasedString".splitToWords())
        assertEquals(listOf("Pascal", "Cased", "String"), "PascalCasedString".splitToWords())
        assertEquals(listOf("XML", "Http", "Request"), "XMLHttpRequest".splitToWords())
        assertEquals(listOf("Simple", "XML", "Http", "Request"), "SimpleXMLHttpRequest".splitToWords())
        assertEquals(listOf("XMLHTTP"), "XMLHTTP".splitToWords())
        assertEquals(listOf("S", "Class", "C"), "SClassC".splitToWords())
        assertEquals(listOf("XML", "Http", "Request", "JSON"), "XMLHttpRequestJSON".splitToWords())
    }
}
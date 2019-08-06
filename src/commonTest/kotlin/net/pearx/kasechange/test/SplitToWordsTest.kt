/*
 * Copyright © 2019, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange.test

import net.pearx.kasechange.splitter.splitToWords
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
        assertEquals(listOf("U", "Int", "32", "Value"), "UInt32Value".splitToWords())
        assertEquals(listOf("U", "Int32", "Value"), "UInt32Value".splitToWords(digitsAsWordBoundaries = false))
        assertEquals(listOf("U", "Int32value"), "UInt32value".splitToWords(digitsAsWordBoundaries = false))
    }
}
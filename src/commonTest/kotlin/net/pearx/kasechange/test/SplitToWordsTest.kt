/*
 * Copyright © 2019, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange.test

import net.pearx.kasechange.UNIVERSAL_WORD_SPLITTER
import kotlin.test.Test
import kotlin.test.assertEquals

class SplitToWordsTest {
    @Test
    fun testSplittingCharacters() {
        assertEquals(listOf("snake", "case"), UNIVERSAL_WORD_SPLITTER.splitToWords("snake_case"))
        assertEquals(listOf("kebab", "case"), UNIVERSAL_WORD_SPLITTER.splitToWords("kebab-case"))
        assertEquals(listOf("space", "case"), UNIVERSAL_WORD_SPLITTER.splitToWords("space case"))
        assertEquals(listOf("some", "util", "random"), UNIVERSAL_WORD_SPLITTER.splitToWords("some-util_random"))
        assertEquals(listOf("java", "util", "Arrays"), UNIVERSAL_WORD_SPLITTER.splitToWords("java.util.Arrays"))
    }

    @Test
    fun testLetterCase() {
        assertEquals(listOf("camel", "Cased", "String"), UNIVERSAL_WORD_SPLITTER.splitToWords("camelCasedString"))
        assertEquals(listOf("Pascal", "Cased", "String"), UNIVERSAL_WORD_SPLITTER.splitToWords("PascalCasedString"))
        assertEquals(listOf("XML", "Http", "Request"), UNIVERSAL_WORD_SPLITTER.splitToWords("XMLHttpRequest"))
        assertEquals(listOf("Simple", "XML", "Http", "Request"), UNIVERSAL_WORD_SPLITTER.splitToWords("SimpleXMLHttpRequest"))
        assertEquals(listOf("XMLHTTP"), UNIVERSAL_WORD_SPLITTER.splitToWords("XMLHTTP"))
        assertEquals(listOf("S", "Class", "C"), UNIVERSAL_WORD_SPLITTER.splitToWords("SClassC"))
        assertEquals(listOf("XML", "Http", "Request", "JSON"), UNIVERSAL_WORD_SPLITTER.splitToWords("XMLHttpRequestJSON"))
        assertEquals(listOf("U", "Int", "32", "Value"), UNIVERSAL_WORD_SPLITTER.splitToWords("UInt32Value"))
    }
}
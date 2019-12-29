/*
 * Copyright © 2019-2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange.test

import net.pearx.kasechange.CaseFormat
import net.pearx.kasechange.splitToWords
import net.pearx.kasechange.splitter.WordSplitter
import net.pearx.kasechange.splitter.WordSplitterConfig
import kotlin.test.Test
import kotlin.test.assertEquals

class WordSplitterTest {
    @Test
    fun testCamel() {
        assertEquals(listOf("xml", "Http", "Request", "V2", "Updated"), "xmlHttpRequestV2Updated".splitToWords(CaseFormat.CAMEL))
    }

    @Test
    fun testPascal() {
        assertEquals(listOf("XML", "Http", "Request", "V2", "Updated"), "XMLHttpRequestV2Updated".splitToWords(CaseFormat.CAPITALIZED_CAMEL))
    }

    @Test
    fun testSnake() {
        assertEquals(listOf("xml", "http", "request", "v2", "updated"), "xml_http_request_v2_updated".splitToWords(CaseFormat.LOWER_UNDERSCORE))
    }

    @Test
    fun testScreamingSnake() {
        assertEquals(listOf("XML", "HTTP", "REQUEST", "V2", "UPDATED"), "XML_HTTP_REQUEST_V2_UPDATED".splitToWords(CaseFormat.UPPER_UNDERSCORE))
    }

    @Test
    fun testKebab() {
        assertEquals(listOf("xml", "http", "request", "v2", "updated"), "xml-http-request-v2-updated".splitToWords(CaseFormat.LOWER_HYPHEN))
    }

    @Test
    fun testTrain() {
        assertEquals(listOf("XML", "HTTP", "REQUEST", "V2", "UPDATED"), "XML-HTTP-REQUEST-V2-UPDATED".splitToWords(CaseFormat.UPPER_HYPHEN))
    }

    @Test
    fun testLowerSpace() {
        assertEquals(listOf("xml", "http", "request", "v2", "updated"), "xml http request v2 updated".splitToWords(CaseFormat.LOWER_SPACE))
    }

    @Test
    fun testUpperSpace() {
        assertEquals(listOf("XML", "HTTP", "REQUEST", "V2", "UPDATED"), "XML HTTP REQUEST V2 UPDATED".splitToWords(CaseFormat.UPPER_SPACE))
    }

    @Test
    fun testTitle() {
        assertEquals(listOf("XML", "Request", "V2", "Updated"), "XML Request V2 Updated".splitToWords(CaseFormat.CAPITALIZED_SPACE))
    }

    @Test
    fun testDot() {
        assertEquals(listOf("xml", "request", "v2", "updated"), "xml.request.v2.updated".splitToWords(CaseFormat.LOWER_DOT))
    }

    @Test
    fun testDotUpper() {
        assertEquals(listOf("XML", "REQUEST", "V2", "UPDATED"), "XML.REQUEST.V2.UPDATED".splitToWords(CaseFormat.UPPER_DOT))
    }

    @Test
    fun testConfig() {
        assertEquals(listOf("xml", "Request", "V2", "Updated"), "xml*Request*V2*Updated".splitToWords(WordSplitterConfig(boundaries = setOf('*'))))
    }
}
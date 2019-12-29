/*
 * Copyright © 2019-2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange.test

import net.pearx.kasechange.formatter.CaseFormatterConfig
import net.pearx.kasechange.toCase
import net.pearx.kasechange.splitToWords
import net.pearx.kasechange.universalWordSplitter
import kotlin.test.Test
import kotlin.test.assertEquals

class UniversalWordSplitter2Test {
    @Test
    fun testCamel() {
        assertEquals(listOf("xml", "Http", "Request", "V2", "Updated"), "xmlHttpRequestV2Updated".splitToWords(universalWordSplitter(false)))
    }

    @Test
    fun testPascal() {
        assertEquals(listOf("XML", "Http", "Request", "V2", "Updated"), "XMLHttpRequestV2Updated".splitToWords(universalWordSplitter(false)))
    }

    @Test
    fun testSnake() {
        assertEquals(listOf("xml", "http", "request", "v2", "updated"), "xml_http_request_v2_updated".splitToWords(universalWordSplitter(false)))
    }

    @Test
    fun testScreamingSnake() {
        assertEquals(listOf("XML", "HTTP", "REQUEST", "V2", "UPDATED"), "XML_HTTP_REQUEST_V2_UPDATED".splitToWords(universalWordSplitter(false)))
    }

    @Test
    fun testKebab() {
        assertEquals(listOf("xml", "http", "request", "v2", "updated"), "xml-http-request-v2-updated".splitToWords(universalWordSplitter(false)))
    }

    @Test
    fun testTrain() {
        assertEquals(listOf("XML", "HTTP", "REQUEST", "V2", "UPDATED"), "XML-HTTP-REQUEST-V2-UPDATED".splitToWords(universalWordSplitter(false)))
    }

    @Test
    fun testLowerSpace() {
        assertEquals(listOf("xml", "http", "request", "v2", "updated"), "xml http request v2 updated".splitToWords(universalWordSplitter(false)))
    }

    @Test
    fun testUpperSpace() {
        assertEquals(listOf("XML", "HTTP", "REQUEST", "V2", "UPDATED"), "XML HTTP REQUEST V2 UPDATED".splitToWords(universalWordSplitter(false)))
    }

    @Test
    fun testTitle() {
        assertEquals(listOf("XML", "Http", "Request", "V2", "Updated"), "XML Http Request V2 Updated".splitToWords(universalWordSplitter(false)))
    }

    @Test
    fun testDot() {
        assertEquals(listOf("xml", "http", "request", "v2", "updated"), "xml.http.request.v2.updated".splitToWords(universalWordSplitter(false)))
    }

    @Test
    fun testDotUpper() {
        assertEquals(listOf("XML", "HTTP", "REQUEST", "V2", "UPDATED"), "XML.HTTP.REQUEST.V2.UPDATED".splitToWords(universalWordSplitter(false)))
    }

    @Test
    fun testMulti1() {
        assertEquals(listOf("MY", "XML", "REQUEST", "V2", "UPDATED"), "MY XML-REQUEST.V2_UPDATED".splitToWords(universalWordSplitter(false)))
    }

    @Test
    fun testMulti2() {
        assertEquals(listOf("my", "xml", "request", "v2", "updated"), "my xml-request.v2_updated".splitToWords(universalWordSplitter(false)))
    }

    @Test
    fun testMulti3() {
        assertEquals(listOf("my", "XML", "Request", "v2", "UPDATED"), "my XML-Request.v2_UPDATED".splitToWords(universalWordSplitter(false)))
    }
}
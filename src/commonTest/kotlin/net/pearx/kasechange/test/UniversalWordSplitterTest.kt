/*
 * Copyright © 2019, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange.test

import net.pearx.kasechange.splitToWords
import kotlin.test.Test
import kotlin.test.assertEquals

class UniversalWordSplitterTest {
    @Test
    fun testCamel() {
        assertEquals(listOf("xml", "Http", "Request", "V2", "Updated"), "xmlHttpRequestV2Updated".splitToWords())
    }

    @Test
    fun testPascal() {
        assertEquals(listOf("XML", "Http", "Request", "V2", "Updated"), "XMLHttpRequestV2Updated".splitToWords())
    }

    @Test
    fun testSnake() {
        assertEquals(listOf("xml", "http", "request", "V2", "updated"), "xml_http_request_V2_updated".splitToWords())
    }

    @Test
    fun testScreamingSnake() {
        assertEquals(listOf("XML", "HTTP", "REQUEST", "V2", "UPDATED"), "XML_HTTP_REQUEST_V2_UPDATED".splitToWords())
    }

    @Test
    fun testKebab() {
        assertEquals(listOf("xml", "http", "request", "V2", "updated"), "xml-http-request-V2-updated".splitToWords())
    }

    @Test
    fun testTrain() {
        assertEquals(listOf("XML", "HTTP", "REQUEST", "V2", "UPDATED"), "XML-HTTP-REQUEST-V2-UPDATED".splitToWords())
    }

    @Test
    fun testLowerSpace() {
        assertEquals(listOf("xml", "http", "request", "V2", "updated"), "xml http request V2 updated".splitToWords())
    }

    @Test
    fun testUpperSpace() {
        assertEquals(listOf("XML", "HTTP", "REQUEST", "V2", "UPDATED"), "XML HTTP REQUEST V2 UPDATED".splitToWords())
    }

    @Test
    fun testTitle() {
        assertEquals(listOf("XML", "Request", "V2", "Updated"), "XML Request V2 Updated".splitToWords())
    }

    @Test
    fun testDot() {
        assertEquals(listOf("xml", "request", "V2", "updated"), "xml.request.V2.updated".splitToWords())
    }

    @Test
    fun testDotUpper() {
        assertEquals(listOf("XML", "REQUEST", "V2", "UPDATED"), "XML.REQUEST.V2.UPDATED".splitToWords())
    }

    @Test
    fun testMulti1() {
        assertEquals(listOf("MY", "XML", "REQUEST", "V2", "UPDATED"), "MY XML-REQUEST.V2_UPDATED".splitToWords())
    }

    @Test
    fun testMulti2() {
        assertEquals(listOf("my", "xml", "request", "V2", "updated"), "my xml-request.V2_updated".splitToWords())
    }

    @Test
    fun testMulti3() {
        assertEquals(listOf("my", "XML", "Request", "V2", "UPDATED"), "my XML-Request.V2_UPDATED".splitToWords())
    }
}
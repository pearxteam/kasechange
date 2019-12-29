/*
 * Copyright © 2019-2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange.test

import net.pearx.kasechange.CaseFormat
import net.pearx.kasechange.formatter.CaseFormatterConfig
import net.pearx.kasechange.formatter.CaseFormatterConfigurable
import net.pearx.kasechange.formatter.format
import kotlin.test.Test
import kotlin.test.assertEquals

class CaseFormatterTest {

    @Test
    fun testCamel() {
        assertEquals("xmlHttpRequestV2Updated", CaseFormat.CAMEL.format("XmL", "http", "reQuEST", "v2", "Updated"))
    }

    @Test
    fun testPascal() {
        assertEquals("XmlHttpRequestV2Updated", CaseFormat.CAPITALIZED_CAMEL.format("xml", "HTTP", "reQuEsT", "v2", "Updated"))
    }

    @Test
    fun testSnake() {
        assertEquals("xml_http_request_v2_updated", CaseFormat.LOWER_UNDERSCORE.format("XML", "htTp", "REQUEST", "V2", "updated"))
    }

    @Test
    fun testScreamingSnake() {
        assertEquals("XML_HTTP_REQUEST_V2_UPDATED", CaseFormat.UPPER_UNDERSCORE.format("xml", "HTTP", "reQUEst", "v2", "updated"))
    }

    @Test
    fun testKebab() {
        assertEquals("xml-http-request-v2-updated", CaseFormat.LOWER_HYPHEN.format("XML", "http", "reQuEST", "V2", "Updated"))
    }

    @Test
    fun testTrain() {
        assertEquals("XML-HTTP-REQUEST-V2-UPDATED", CaseFormat.UPPER_HYPHEN.format("XML", "http", "reQuEST", "V2", "Updated"))
    }

    @Test
    fun testLowerSpace() {
        assertEquals("xml http request v2 updated", CaseFormat.LOWER_SPACE.format("XML", "http", "reQuEST", "V2", "Updated"))
    }

    @Test
    fun testUpperSpace() {
        assertEquals("XML HTTP REQUEST V2 UPDATED", CaseFormat.UPPER_SPACE.format("XmL", "http", "reQuEST", "v2", "Updated"))
    }

    @Test
    fun testTitle() {
        assertEquals("Xml Http Request V2 Updated", CaseFormat.CAPITALIZED_SPACE.format("XmL", "http", "reQuEST", "v2", "Updated"))
    }

    @Test
    fun testDot() {
        assertEquals("xml.http.request.v2.updated", CaseFormat.LOWER_DOT.format("XML", "http", "reQuEST", "V2", "Updated"))
    }

    @Test
    fun testDotUpper() {
        assertEquals("XML.HTTP.REQUEST.V2.UPDATED", CaseFormat.UPPER_DOT.format("xml", "HTTP", "reQUEst", "v2", "updated"))
    }

    @Test
    fun testConfig() {
        assertEquals("Xml**Http**Request**V2**Updated", CaseFormatterConfigurable(CaseFormatterConfig(false, "**", wordCapitalize = true, firstWordCapitalize = true)).format("XmL", "http", "REQUEST", "v2", "uPDated"))
    }
}
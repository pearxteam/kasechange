/*
 * Copyright © 2019-2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange.test

import net.pearx.kasechange.*
import net.pearx.kasechange.formatter.CaseFormatterConfig
import net.pearx.kasechange.splitter.WordSplitterConfig
import kotlin.test.Test
import kotlin.test.assertEquals

class ComplexTest {
    @Test
    fun testCamel() {
        assertEquals("xmlHttpRequestV2Updated", "xml_http_request_v2_updated".toCamelCase(CaseFormat.LOWER_UNDERSCORE))
    }

    @Test
    fun testPascal() {
        assertEquals("XmlHttpRequestV2Updated", "xml_http_request_v2_updated".toPascalCase(CaseFormat.LOWER_UNDERSCORE))
    }

    @Test
    fun testSnake() {
        assertEquals("xml_http_request_v2_updated", "XML_HTTP_REQUEST_V2_UPDATED".toSnakeCase(CaseFormat.UPPER_UNDERSCORE))
    }

    @Test
    fun testScreamingSnake() {
        assertEquals("XML_HTTP_REQUEST_V2_UPDATED", "xml_http_request_v2_updated".toScreamingSnakeCase(CaseFormat.LOWER_UNDERSCORE))
    }

    @Test
    fun testKebab() {
        assertEquals("xml-http-request-v2-updated", "xml_http_request_v2_updated".toKebabCase(CaseFormat.LOWER_UNDERSCORE))
    }

    @Test
    fun testTrain() {
        assertEquals("XML-HTTP-REQUEST-V2-UPDATED", "xml_http_request_v2_updated".toTrainCase(CaseFormat.LOWER_UNDERSCORE))
    }

    @Test
    fun testLowerSpace() {
        assertEquals("xml http request v2 updated", "xml_http_request_v2_updated".toLowerSpaceCase(CaseFormat.LOWER_UNDERSCORE))
    }

    @Test
    fun testUpperSpace() {
        assertEquals("XML HTTP REQUEST V2 UPDATED", "xml_http_request_v2_updated".toUpperSpaceCase(CaseFormat.LOWER_UNDERSCORE))
    }

    @Test
    fun testTitle() {
        assertEquals("Xml Http Request V2 Updated", "xml_http_request_v2_updated".toTitleCase(CaseFormat.LOWER_UNDERSCORE))
    }

    @Test
    fun testSentence() {
        assertEquals("Xml http request v2 updated", "xml_http_request_v2_updated".toSentenceCase(CaseFormat.LOWER_UNDERSCORE))
    }

    @Test
    fun testDot() {
        assertEquals("xml.http.request.v2.updated", "xml_http_request_v2_updated".toDotCase(CaseFormat.LOWER_UNDERSCORE))
    }

    @Test
    fun testDotUpper() {
        assertEquals("XML.HTTP.REQUEST.V2.UPDATED", "xml_http_request_v2_updated".toUpperDotCase(CaseFormat.LOWER_UNDERSCORE))
    }

    @Test
    fun testCustom1() {
        assertEquals("My**Xml**Request**V2**Updated", "MY XML-REQUEST.V2_UPDATED".toCase(CaseFormatterConfig(false, "**", wordCapitalize = true, firstWordCapitalize = true), universalWordSplitter(false)))
    }

    @Test
    fun testCustom2() {
        assertEquals("My**Xml**Request**V2**Updated", "MY_XML_REQUEST_V2_UPDATED".toCase(CaseFormatterConfig(false, "**", wordCapitalize = true, firstWordCapitalize = true), CaseFormat.UPPER_UNDERSCORE))
    }

    @Test
    fun testCustom3() {
        assertEquals("My**Xml**Request**V2**Updated", "my*xml*request*v2*updated".toCase(CaseFormatterConfig(false, "**", wordCapitalize = true, firstWordCapitalize = true), WordSplitterConfig(boundaries = setOf('*'))))
    }
}
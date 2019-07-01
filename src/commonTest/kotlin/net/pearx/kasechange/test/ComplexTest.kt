/*
 * Copyright © 2019, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange.test

import net.pearx.kasechange.toCamelCase
import net.pearx.kasechange.toDotCase
import net.pearx.kasechange.toKebabCase
import net.pearx.kasechange.toLowerSpaceCase
import net.pearx.kasechange.toPascalCase
import net.pearx.kasechange.toScreamingSnakeCase
import net.pearx.kasechange.toSnakeCase
import net.pearx.kasechange.toTitleCase
import net.pearx.kasechange.toTrainCase
import net.pearx.kasechange.toUpperDotCase
import net.pearx.kasechange.toUpperSpaceCase
import kotlin.test.Test
import kotlin.test.assertEquals

class ComplexTest {
    @Test
    fun testCamel() {
        assertEquals("someStringWith123Numbers", "Some String With 123 Numbers".toCamelCase())
    }

    @Test
    fun testPascal() {
        assertEquals("SomeStringWith123Numbers", "Some String With 123 Numbers".toPascalCase())
    }

    @Test
    fun testSnake() {
        assertEquals("some_string_with_123_numbers", "Some String With 123 Numbers".toSnakeCase())
    }

    @Test
    fun testScreamingSnake() {
        assertEquals("SOME_STRING_WITH_123_NUMBERS", "Some String With 123 Numbers".toScreamingSnakeCase())
    }

    @Test
    fun testKebab() {
        assertEquals("some-string-with-123-numbers", "Some String With 123 Numbers".toKebabCase())
    }

    @Test
    fun testTrain() {
        assertEquals("SOME-STRING-WITH-123-NUMBERS", "Some String With 123 Numbers".toTrainCase())
    }

    @Test
    fun testLowerSpace() {
        assertEquals("some string with 123 numbers", "Some String With 123 Numbers".toLowerSpaceCase())
    }

    @Test
    fun testUpperSpace() {
        assertEquals("SOME STRING WITH 123 NUMBERS", "Some String With 123 Numbers".toUpperSpaceCase())
    }

    @Test
    fun testTitle() {
        assertEquals("Some String With 123 Numbers", "some string with 123 numbers".toTitleCase())
    }

    @Test
    fun testDot() {
        assertEquals("some.string.with.123.numbers", "Some String With 123 Numbers".toDotCase())
    }

    @Test
    fun testDotUpper() {
        assertEquals("SOME.STRING.WITH.123.NUMBERS", "Some String With 123 Numbers".toUpperDotCase())
    }
}
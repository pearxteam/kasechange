/*
 * Copyright © 2019, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange.test

import net.pearx.kasechange.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ComplexTest {
    @Test
    fun testCamel() {
        assertEquals("someString", "Some String".toCamelCase())
    }

    @Test
    fun testPascal() {
        assertEquals("SomeString", "Some String".toPascalCase())
    }

    @Test
    fun testSnake() {
        assertEquals("some_string", "Some String".toSnakeCase())
    }

    @Test
    fun testScreamingSnake() {
        assertEquals("SOME_STRING", "Some String".toScreamingSnakeCase())
    }

    @Test
    fun testKebab() {
        assertEquals("some-string", "Some String".toKebabCase())
    }

    @Test
    fun testTrain() {
        assertEquals("SOME-STRING", "Some String".toTrainCase())
    }

    @Test
    fun testLowerSpace() {
        assertEquals("some string", "Some String".toLowerSpaceCase())
    }

    @Test
    fun testUpperSpace() {
        assertEquals("SOME STRING", "Some String".toUpperSpaceCase())
    }

    @Test
    fun testTitle() {
        assertEquals("Some String", "some string".toTitleCase())
    }

    @Test
    fun testDot() {
        assertEquals("some.string", "Some String".toDotCase())
    }

    @Test
    fun testDotUpper() {
        assertEquals("SOME.STRING", "Some String".toUpperDotCase())
    }
}
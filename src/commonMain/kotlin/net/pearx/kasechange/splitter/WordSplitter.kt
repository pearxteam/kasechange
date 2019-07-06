/*
 * Copyright © 2019, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange.splitter

import net.pearx.kasechange.isDigitPlatform
import net.pearx.kasechange.isLowerCasePlatform
import net.pearx.kasechange.isUpperCasePlatform

private val BOUNDARIES = arrayOf(' ', '-', '_', '.')

private fun StringBuilder.toStringAndClear() = toString().also { clear() }

private fun Char.isDigitOrUpperCase(): Boolean = this.isUpperCasePlatform() || this.isDigitPlatform()

/**
 * Splits a string to multiple words by using the following rules:
 * - All ' ', '-', '_', '.' characters are considered word boundaries.
 * - If a lowercase character is followed by an uppercase character, a word boundary is considered to be prior to the uppercase character.
 * - If multiple uppercase characters are followed by a lowercase character, a word boundary is considered to be prior to the last uppercase character.
 * - Digit characters handle same as uppercase characters.
 *
 * Examples:
 * - XMLBufferedReader => XML|Buffered|Reader
 * - newFile => new|File
 * - net.pearx.lib => net|pearx|lib
 * - NewDataClass => New|Data|Class
 * - UInt32Value => U|Int|32|Value
 */
fun String.splitToWords(): List<String> {
    val list = mutableListOf<String>()
    val word = StringBuilder()
    for (index in 0 until length) {
        val char = this[index]
        if (char in BOUNDARIES) {
            list.add(word.toStringAndClear())
        }
        else {
            if (char.isDigitOrUpperCase()) {
                val hasPrev = index > 0
                val hasNext = index < length - 1
                val prevLowerCase = hasPrev && this[index - 1].isLowerCasePlatform()
                val prevDigitUpperCase = hasPrev && this[index - 1].isDigitOrUpperCase()
                val nextLowerCase = hasNext && this[index + 1].isLowerCasePlatform()
                if (prevLowerCase || (prevDigitUpperCase && nextLowerCase)) {
                    list.add(word.toStringAndClear())
                }
            }
            word.append(char)
        }
    }
    list.add(word.toStringAndClear())
    return list
}
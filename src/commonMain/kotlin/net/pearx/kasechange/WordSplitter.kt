/*
 * Copyright © 2019, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange

private val CHARACTERS_TO_SPLIT = arrayOf(' ', '-', '_', '.')

private fun StringBuilder.toStringAndClear() = toString().also { clear() }

fun String.splitToWords(): List<String> = mutableListOf<String>().also { list ->
    val word = StringBuilder()
    for (index in 0 until length) {
        val char = this[index]
        if (char in CHARACTERS_TO_SPLIT) {
            list.add(word.toStringAndClear())
        }
        else {
            if (char.isUpperCasePlatform()) {
                if ((index > 0 && this[index - 1].isLowerCasePlatform()) ||
                    (index > 0 && index < length - 1 && this[index - 1].isUpperCasePlatform() && this[index + 1].isLowerCasePlatform())) {
                    list.add(word.toStringAndClear())
                }
            }
            word.append(char)
        }
    }
    list.add(word.toStringAndClear())
}
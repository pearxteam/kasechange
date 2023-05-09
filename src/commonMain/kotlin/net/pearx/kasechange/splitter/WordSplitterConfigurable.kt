/*
 * Copyright © 2019-2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange.splitter

/**
 * A configuration class for [WordSplitterConfigurable].
 */
data class WordSplitterConfig(
    /** @see WordSplitterConfigurable.splitToWords */
    val boundaries: Set<Char> = setOf(),
    /** @see WordSplitterConfigurable.splitToWords */
    val handleCase: Boolean = false,
    /** @see WordSplitterConfigurable.splitToWords */
    val treatDigitsAsUppercase: Boolean = false
)

/**
 * A default implementation of the [WordSplitter] that can be configured using a [WordSplitterConfig] instance.
 */
class WordSplitterConfigurable(private val config: WordSplitterConfig) : WordSplitter {
    /**
     * Splits [string] into multiple words and returns a list of them.
     * - All [WordSplitterConfig.boundaries] characters are considered word boundaries.
     * - If [WordSplitterConfig.handleCase] is set to true: if a lowercase character is followed by an uppercase character, a word boundary is considered to be prior to the uppercase character.
     * - If [WordSplitterConfig.handleCase] is set to true: if multiple uppercase characters are followed by a lowercase character, a word boundary is considered to be prior to the last uppercase character.
     * - If [WordSplitterConfig.treatDigitsAsUppercase] is set to true: Digit characters handle same as uppercase characters.
     * - If [WordSplitterConfig.treatDigitsAsUppercase] is set to false: Digit characters handle same as lowercase characters.
     */
    override fun splitToWords(string: String): List<String> {val list = mutableListOf<String>()
        val word = StringBuilder()
        for (index in string.indices) {
            val char = string[index]
            if (char in config.boundaries) {
                list.add(word.toStringAndClear())
            }
            else {
                if (config.handleCase && char.isDigitOrUpperCase(config.treatDigitsAsUppercase)) {
                    val hasPrev = index > 0
                    val hasNext = index < string.length - 1
                    val prevLowerCase = hasPrev && string[index - 1].isDigitOrLowerCase(config.treatDigitsAsUppercase)
                    val prevDigitUpperCase = hasPrev && string[index - 1].isDigitOrUpperCase(config.treatDigitsAsUppercase)
                    val nextLowerCase = hasNext && string[index + 1].isDigitOrLowerCase(config.treatDigitsAsUppercase)
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

    private fun StringBuilder.toStringAndClear() = toString().also { clear() }

    private fun Char.isDigitOrUpperCase(treatDigitsAsUppercase: Boolean): Boolean =
        (treatDigitsAsUppercase && isDigit()) || isUpperCase()

    private fun Char.isDigitOrLowerCase(treatDigitsAsUppercase: Boolean): Boolean = (!treatDigitsAsUppercase && isDigit()) || isLowerCase()
}
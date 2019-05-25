/*
 * Copyright © 2019, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange

enum class CaseFormat(private val wordUppercase: Boolean, private val wordSplitter: Char?, private val wordCapitalize: Boolean = false, private val firstWordCapitalize: Boolean = false) {
    /* SCREAMING_SNAKE_CASE */
    UPPER_UNDERSCORE(true, '_'),
    /* snake_case */
    LOWER_UNDERSCORE(false, '_'),
    /* PascalCase */
    CAPITALIZED_CAMEL(false, null, true, true),
    /* camelCase */
    CAMEL(false, null, true, false),
    /* TRAIN-CASE */
    UPPER_HYPHEN(true, '-'),
    /* kebab-case */
    LOWER_HYPHEN(false, '-'),
    /* UPPER SPACE CASE */
    UPPER_SPACE(true, ' '),
    /* Title Case */
    CAPITALIZED_SPACE(false, ' ', true, true),
    /* lower space case */
    LOWER_SPACE(false, ' '),
    /* UPPER.DOT.CASE */
    UPPER_DOT(true, '.'),
    /* dot.case */
    LOWER_DOT(false, '.');

    fun formatTo(appendable: Appendable, words: Iterable<String>) {
        appendable.apply {
            for ((index, word) in words.withIndex()) {
                if (wordSplitter != null && index != 0)
                    append(wordSplitter)
                append(when {
                    wordUppercase -> word.toUpperCase()
                    index == 0 -> {
                        when {
                            firstWordCapitalize -> word.toLowerCase().capitalize()
                            else -> word.toLowerCase()
                        }
                    }
                    wordCapitalize -> word.toLowerCase().capitalize()
                    else -> word.toLowerCase()
                })
            }
        }
    }

    fun formatTo(appendable: Appendable, vararg words: String) = formatTo(appendable, words.asIterable())

    fun format(words: Iterable<String>): String = StringBuilder().also { formatTo(it, words) }.toString()

    fun format(vararg words: String) = format(words.asIterable())
}
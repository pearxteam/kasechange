/*
 * Copyright © 2019-2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange.formatter

/**
 * A configuration class for [CaseFormatterConfigurable].
 */
data class CaseFormatterConfig(
    /** @see CaseFormatterConfigurable.formatTo */
    val wordUppercase: Boolean,
    /** @see CaseFormatterConfigurable.formatTo */
    val wordSplitter: String? = null,
    /** @see CaseFormatterConfigurable.formatTo */
    val wordCapitalize: Boolean = false,
    /** @see CaseFormatterConfigurable.formatTo */
    val firstWordCapitalize: Boolean = false
)

/**
 * A default implementation of the [CaseFormatter] that can be configured using a [CaseFormatterConfig] instance.
 */
class CaseFormatterConfigurable(private val config: CaseFormatterConfig) : CaseFormatter {
    /**
     * Joins [words], appending the result to [appendable].
     * - If [CaseFormatterConfig.wordSplitter] isn't null, it will be inserted between each word.
     * - Each word will be converted using one of the rules below (in precedence from highest to lowest):
     * - - If [CaseFormatterConfig.wordUppercase] is true, the word will be converted to uppercase.
     * - - If [CaseFormatterConfig.firstWordCapitalize] is true and the word is first, the word will be capitalized.
     * - - If [CaseFormatterConfig.wordCapitalize] is true, the word will be capitalized.
     * - - Otherwise, the word will be converted to lowercase.
     */
    override fun formatTo(appendable: Appendable, words: Iterable<String>) {
        with(appendable) {
            for ((index, word) in words.withIndex()) {
                if (config.wordSplitter != null && index != 0)
                    append(config.wordSplitter)
                append(when {
                    config.wordUppercase -> word.toUpperCase()
                    index == 0 -> {
                        when {
                            config.firstWordCapitalize -> word.toLowerCase().capitalize()
                            else -> word.toLowerCase()
                        }
                    }
                    config.wordCapitalize -> word.toLowerCase().capitalize()
                    else -> word.toLowerCase()
                })
            }
        }
    }
}
/*
 * Copyright © 2019, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange.formatter

/**
 * A configuration class for [CaseFormatterConfigurable].
 */
data class CaseFormatterConfig(
    val wordUppercase: Boolean,
    val wordSplitter: String? = null,
    val wordCapitalize: Boolean = false,
    val firstWordCapitalize: Boolean = false
)

/**
 * A default implementation of the [CaseFormatter] that can be configured using a [CaseFormatterConfig] instance.
 */
class CaseFormatterConfigurable(private val config: CaseFormatterConfig) : CaseFormatter {
    /**
     * Joins [words], appending the result to [appendable].
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
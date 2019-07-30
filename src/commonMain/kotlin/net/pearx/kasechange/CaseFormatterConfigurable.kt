/*
 * Copyright © 2019, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange

data class CaseFormatterConfig(val wordUppercase: Boolean, val wordSplitter: String? = null, val wordCapitalize: Boolean = false, val firstWordCapitalize: Boolean = false)

/**
 * A default implementation of the [CaseFormatter] that can be configured using a [CaseFormatterConfig] instance.
 */
class CaseFormatterConfigurable(private val config: CaseFormatterConfig) : CaseFormatter {

    /**
     * Joins [words], appending the result to [appendable]
     */
    override fun formatTo(appendable: Appendable, words: Iterable<String>) {
        with(config) {
            with(appendable) {
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
    }
}
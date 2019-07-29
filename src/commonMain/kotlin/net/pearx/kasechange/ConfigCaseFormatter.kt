/*
 * Copyright © 2019, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange

import net.pearx.kasechange.splitter.splitToWords

/**
 * An interface that defines a case formatter that can be used to join a collection of words into one string.
 */
class ConfigCaseFormatter(private val config: Config) : CaseFormatter {

    data class Config(val wordUppercase: Boolean, val wordSplitter: String?, val wordCapitalize: Boolean = false, val firstWordCapitalize: Boolean = false)

    /**
     * Joins [words], appending the result to [appendable]
     */
    override fun formatTo(appendable: Appendable, words: Iterable<String>) {
        with(config) {
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
    }

}
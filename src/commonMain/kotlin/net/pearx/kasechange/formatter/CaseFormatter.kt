/*
 * Copyright © 2019, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange.formatter

import net.pearx.kasechange.UNIVERSAL_WORD_SPLITTER
import net.pearx.kasechange.splitter.WordSplitter

/**
 * An interface that defines a case formatter that can be used to join a collection of words into single string.
 */
interface CaseFormatter {
    /**
     * Joins all elements of [words], appending the result to [appendable].
     */
    fun formatTo(appendable: Appendable, words: Iterable<String>)
}

/**
 * Joins all elements of [words], appending the result to [appendable].
 */
fun CaseFormatter.formatTo(appendable: Appendable, vararg words: String) = formatTo(appendable, words.asIterable())

/**
 * Joins all elements of [words] and returns the resulting string.
 */
fun CaseFormatter.format(words: Iterable<String>): String = buildString { formatTo(this, words) }

/**
 * Joins all elements of [words] and returns the resulting string.
 */
fun CaseFormatter.format(vararg words: String) = format(words.asIterable())

/**
 * Returns a copy of [string] converted to another case by splitting it into multiple words using [wordSplitter] and joining them using [CaseFormatter].
 */
fun CaseFormatter.format(string: String, wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = format(wordSplitter.splitToWords(string))
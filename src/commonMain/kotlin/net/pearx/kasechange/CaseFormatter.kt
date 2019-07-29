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
interface CaseFormatter {
    /**
     * Joins [words], appending the result to [appendable]
     */
    fun formatTo(appendable: Appendable, words: Iterable<String>)

    // TODO: Move methods below out of the interface and make them extensions

    /**
     * Joins [words], appending the result to [appendable]
     */
    fun formatTo(appendable: Appendable, vararg words: String) = formatTo(appendable, words.asIterable())

    /**
     * Joins [words] and returns the result.
     */
    fun format(words: Iterable<String>): String = buildString { formatTo(this, words) }

    /**
     * Joins [words] and returns the result.
     */
    fun format(vararg words: String) = format(words.asIterable())

    /**
     * Converts a string to the case format of the formatter using the word splitting rules defined in [splitToWords]
     */
    fun format(string: String) = format(string.splitToWords())
}
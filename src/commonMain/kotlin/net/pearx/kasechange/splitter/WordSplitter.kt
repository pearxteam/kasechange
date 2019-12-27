/*
 * Copyright © 2019, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange.splitter

/**
 * An interface that defines a word splitter that can be used to split a string into multiple words.
 */
interface WordSplitter {
    /**
     * Splits [string] into multiple words and returns a list of them.
     */
    fun splitToWords(string: String): List<String>
}
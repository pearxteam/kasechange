/*
 * Copyright © 2019, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange

import net.pearx.kasechange.formatter.CaseFormatter
import net.pearx.kasechange.formatter.CaseFormatterConfig
import net.pearx.kasechange.formatter.CaseFormatterConfigurable
import net.pearx.kasechange.splitter.WordSplitter
import net.pearx.kasechange.splitter.WordSplitterConfig
import net.pearx.kasechange.splitter.WordSplitterConfigurable

/**
 * An enumeration that contains a standard set of [CaseFormatter]s.
 */
enum class CaseFormat(caseFormatterConfig: CaseFormatterConfig, wordSplitterConfig: WordSplitterConfig) : CaseFormatter by CaseFormatterConfigurable(caseFormatterConfig), WordSplitter by WordSplitterConfigurable(wordSplitterConfig) {
    /** SCREAMING_SNAKE_CASE */
    UPPER_UNDERSCORE(CaseFormatterConfig(true, "_"), WordSplitterConfig(setOf('_'))),
    /** snake_case */
    LOWER_UNDERSCORE(CaseFormatterConfig(false, "_"), WordSplitterConfig(setOf('_'))),
    /** PascalCase */
    CAPITALIZED_CAMEL(CaseFormatterConfig(false, wordCapitalize = true, firstWordCapitalize = true), WordSplitterConfig(setOf(' ', '-', '_', '.'), handleCase = true, treatDigitsAsUppercase = true)),
    /** camelCase */
    CAMEL(CaseFormatterConfig(false, wordCapitalize = true, firstWordCapitalize = false), WordSplitterConfig(setOf(' ', '-', '_', '.'), handleCase = true, treatDigitsAsUppercase = true)),
    /** TRAIN-CASE */
    UPPER_HYPHEN(CaseFormatterConfig(true, "-"), WordSplitterConfig(setOf('-'))),
    /** kebab-case */
    LOWER_HYPHEN(CaseFormatterConfig(false, "-"), WordSplitterConfig(setOf('-'))),
    /** UPPER SPACE CASE */
    UPPER_SPACE(CaseFormatterConfig(true, " "), WordSplitterConfig(setOf(' '))),
    /** Title Case */
    CAPITALIZED_SPACE(CaseFormatterConfig(false, " ", wordCapitalize = true, firstWordCapitalize = true), WordSplitterConfig(setOf(' '))),
    /** lower space case */
    LOWER_SPACE(CaseFormatterConfig(false, " "), WordSplitterConfig(setOf(' '))),
    /** UPPER.DOT.CASE */
    UPPER_DOT(CaseFormatterConfig(true, "."), WordSplitterConfig(setOf('.'))),
    /** dot.case */
    LOWER_DOT(CaseFormatterConfig(false, "."), WordSplitterConfig(setOf('.')));
}

private fun createUniversalWordSplitter(treatDigitsAsUppercase: Boolean): WordSplitter {
    return WordSplitterConfigurable(WordSplitterConfig(
        boundaries = setOf(' ', '-', '_', '.'),
        handleCase = true,
        treatDigitsAsUppercase = treatDigitsAsUppercase
    ))
}


private val UNIVERSAL_WORD_SPLITTER_DIGITS_UPPERCASE = createUniversalWordSplitter(true)

private val UNIVERSAL_WORD_SPLITTER_DIGITS_NOT_UPPERCASE = createUniversalWordSplitter(false)

/**
 * Returns a default [WordSplitter] that can be used to split a string in any supported case format into words.
 * However, its behavior may be strange and it's always better to specify other [WordSplitter] (for example one of [CaseFormat]s) manually.
 * @param treatDigitsAsUppercase See [WordSplitterConfig.treatDigitsAsUppercase]
 */
fun universalWordSplitter(treatDigitsAsUppercase: Boolean = true) =  if(treatDigitsAsUppercase) UNIVERSAL_WORD_SPLITTER_DIGITS_UPPERCASE else UNIVERSAL_WORD_SPLITTER_DIGITS_NOT_UPPERCASE
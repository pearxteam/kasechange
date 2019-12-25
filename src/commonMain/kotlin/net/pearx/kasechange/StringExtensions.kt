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
import net.pearx.kasechange.formatter.format
import net.pearx.kasechange.splitter.WordSplitter
import net.pearx.kasechange.splitter.WordSplitterConfig
import net.pearx.kasechange.splitter.WordSplitterConfigurable

/**
 * Returns a copy of this string converted to another case by splitting it into multiple words using [wordSplitter] and joining them using [caseFormatter].
 */
fun String.toCase(caseFormatter: CaseFormatter, wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = caseFormatter.format(this, wordSplitter)

/**
 * Returns a copy of this string converted to another case by splitting it into multiple words using [wordSplitter] and joining them using [CaseFormatterConfigurable] configured with [caseFormatterConfig].
 */
fun String.toCase(caseFormatterConfig: CaseFormatterConfig, wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormatterConfigurable(caseFormatterConfig), wordSplitter)
/**
 * Returns a copy of this string converted to another case by splitting it into multiple words using [WordSplitterConfigurable] configured with [wordSplitterConfig] and joining them using [CaseFormatterConfigurable] configured with [caseFormatterConfig].
 */
fun String.toCase(caseFormatterConfig: CaseFormatterConfig, wordSplitterConfig: WordSplitterConfig) = toCase(caseFormatterConfig, WordSplitterConfigurable(wordSplitterConfig))

/** Returns a copy of this string converted to SCREAMING_SNAKE_CASE by splitting it into multiple words using [wordSplitter] and joining them using [CaseFormat.UPPER_UNDERSCORE]. */
fun String.toScreamingSnakeCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.UPPER_UNDERSCORE, wordSplitter)

/** Returns a copy of this string converted to snake_case by splitting it into multiple words using [wordSplitter] and joining them using [CaseFormat.LOWER_UNDERSCORE].. */
fun String.toSnakeCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.LOWER_UNDERSCORE, wordSplitter)

/** Returns a copy of this string converted to PascalCase by splitting it into multiple words using [wordSplitter] and joining them using [CaseFormat.CAPITALIZED_CAMEL].. */
fun String.toPascalCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.CAPITALIZED_CAMEL, wordSplitter)

/** Returns a copy of this string converted to camelCase by splitting it into multiple words using [wordSplitter] and joining them using [CaseFormat.CAMEL].. */
fun String.toCamelCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.CAMEL, wordSplitter)

/** Returns a copy of this string converted to TRAIN-CASE by splitting it into multiple words using [wordSplitter] and joining them using [CaseFormat.UPPER_HYPHEN].. */
fun String.toTrainCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.UPPER_HYPHEN, wordSplitter)

/** Returns a copy of this string converted to kebab-case by splitting it into multiple words using [wordSplitter] and joining them using [CaseFormat.LOWER_HYPHEN].. */
fun String.toKebabCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.LOWER_HYPHEN, wordSplitter)

/** Returns a copy of this string converted to UPPER SPACE CASE by splitting it into multiple words using [wordSplitter] and joining them using [CaseFormat.UPPER_SPACE].. */
fun String.toUpperSpaceCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.UPPER_SPACE, wordSplitter)

/** Returns a copy of this string converted to Title Case by splitting it into multiple words using [wordSplitter] and joining them using [CaseFormat.CAPITALIZED_SPACE].. */
fun String.toTitleCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.CAPITALIZED_SPACE, wordSplitter)

/** Returns a copy of this string converted to lower space case by splitting it into multiple words using [wordSplitter] and joining them using [CaseFormat.LOWER_SPACE].. */
fun String.toLowerSpaceCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.LOWER_SPACE, wordSplitter)

/** Returns a copy of this string converted to UPPER.DOT.CASE by splitting it into multiple words using [wordSplitter] and joining them using [CaseFormat.UPPER_DOT].. */
fun String.toUpperDotCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.UPPER_DOT, wordSplitter)

/** Returns a copy of this string converted to dot.case by splitting it into multiple words using [wordSplitter] and joining them using [CaseFormat.LOWER_DOT].. */
fun String.toDotCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.LOWER_DOT, wordSplitter)
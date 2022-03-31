/*
 * Copyright © 2019-2020, PearX Team
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
 * Returns a copy of this string converted to another case by splitting it into multiple words using [specified][from] [WordSplitter] and joining them using [specified][to] [CaseFormatter].
 */
fun String.toCase(to: CaseFormatter, from: WordSplitter = universalWordSplitter()) = to.format(this, from)

/**
 * Returns a copy of this string converted to another case by splitting it into multiple words using [specified][from] [WordSplitter] and joining them using [CaseFormatterConfigurable] configured with [toConfig].
 */
fun String.toCase(toConfig: CaseFormatterConfig, from: WordSplitter = universalWordSplitter()) = toCase(CaseFormatterConfigurable(toConfig), from)

/**
 * Returns a copy of this string converted to another case by splitting it into multiple words using [WordSplitterConfigurable] configured with [fromConfig] and joining them using [CaseFormatterConfigurable] configured with [toConfig].
 */
fun String.toCase(toConfig: CaseFormatterConfig, fromConfig: WordSplitterConfig) = toCase(toConfig, WordSplitterConfigurable(fromConfig))

/** Returns a copy of this string converted to SCREAMING_SNAKE_CASE by splitting it into multiple words using [specified][from] [WordSplitter] and joining them using [CaseFormat.UPPER_UNDERSCORE]. */
fun String.toScreamingSnakeCase(from: WordSplitter = universalWordSplitter()) = toCase(CaseFormat.UPPER_UNDERSCORE, from)

/** Returns a copy of this string converted to snake_case by splitting it into multiple words using [specified][from] [WordSplitter] and joining them using [CaseFormat.LOWER_UNDERSCORE].. */
fun String.toSnakeCase(from: WordSplitter = universalWordSplitter()) = toCase(CaseFormat.LOWER_UNDERSCORE, from)

/** Returns a copy of this string converted to PascalCase by splitting it into multiple words using [specified][from] [WordSplitter] and joining them using [CaseFormat.CAPITALIZED_CAMEL].. */
fun String.toPascalCase(from: WordSplitter = universalWordSplitter()) = toCase(CaseFormat.CAPITALIZED_CAMEL, from)

/** Returns a copy of this string converted to camelCase by splitting it into multiple words using [specified][from] [WordSplitter] and joining them using [CaseFormat.CAMEL].. */
fun String.toCamelCase(from: WordSplitter = universalWordSplitter()) = toCase(CaseFormat.CAMEL, from)

/** Returns a copy of this string converted to TRAIN-CASE by splitting it into multiple words using [specified][from] [WordSplitter] and joining them using [CaseFormat.UPPER_HYPHEN].. */
fun String.toTrainCase(from: WordSplitter = universalWordSplitter()) = toCase(CaseFormat.UPPER_HYPHEN, from)

/** Returns a copy of this string converted to kebab-case by splitting it into multiple words using [specified][from] [WordSplitter] and joining them using [CaseFormat.LOWER_HYPHEN].. */
fun String.toKebabCase(from: WordSplitter = universalWordSplitter()) = toCase(CaseFormat.LOWER_HYPHEN, from)

/** Returns a copy of this string converted to UPPER SPACE CASE by splitting it into multiple words using [specified][from] [WordSplitter] and joining them using [CaseFormat.UPPER_SPACE].. */
fun String.toUpperSpaceCase(from: WordSplitter = universalWordSplitter()) = toCase(CaseFormat.UPPER_SPACE, from)

/** Returns a copy of this string converted to Title Case by splitting it into multiple words using [specified][from] [WordSplitter] and joining them using [CaseFormat.CAPITALIZED_SPACE].. */
fun String.toTitleCase(from: WordSplitter = universalWordSplitter()) = toCase(CaseFormat.CAPITALIZED_SPACE, from)

/** Returns a copy of this string converted to Sentence case by splitting it into multiple words using [specified][from] [WordSplitter] and joining them using [CaseFormat.SENTENCE_SPACE].. */
fun String.toSentenceCase(from: WordSplitter = universalWordSplitter()) = toCase(CaseFormat.SENTENCE_SPACE, from)

/** Returns a copy of this string converted to lower space case by splitting it into multiple words using [specified][from] [WordSplitter] and joining them using [CaseFormat.LOWER_SPACE].. */
fun String.toLowerSpaceCase(from: WordSplitter = universalWordSplitter()) = toCase(CaseFormat.LOWER_SPACE, from)

/** Returns a copy of this string converted to UPPER.DOT.CASE by splitting it into multiple words using [specified][from] [WordSplitter] and joining them using [CaseFormat.UPPER_DOT].. */
fun String.toUpperDotCase(from: WordSplitter = universalWordSplitter()) = toCase(CaseFormat.UPPER_DOT, from)

/** Returns a copy of this string converted to dot.case by splitting it into multiple words using [specified][from] [WordSplitter] and joining them using [CaseFormat.LOWER_DOT].. */
fun String.toDotCase(from: WordSplitter = universalWordSplitter()) = toCase(CaseFormat.LOWER_DOT, from)


/**
 * Splits this string into multiple words using [specified][splitter] [WordSplitter] and returns a list of words.
 */
fun String.splitToWords(splitter: WordSplitter = universalWordSplitter()) = splitter.splitToWords(this)

/**
 * Splits this string into multiple words using [WordSplitterConfigurable] configured with [config] and returns a list of words.
 */
fun String.splitToWords(config: WordSplitterConfig) = splitToWords(WordSplitterConfigurable(config))
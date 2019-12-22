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

/**
 * Converts a string from one case to another by splitting this string into multiple words using [wordSplitter] and joining them using [caseFormatter].
 */
fun String.toCase(caseFormatter: CaseFormatter, wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = caseFormatter.format(this, wordSplitter)

/**
 * Converts a string from one case to another by splitting this string into multiple words using [wordSplitter] and joining them using [CaseFormatterConfigurable] configured with [caseFormatterConfig].
 */
fun String.toCase(caseFormatterConfig: CaseFormatterConfig, wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = CaseFormatterConfigurable(caseFormatterConfig).format(this, wordSplitter)

/** Converts a string from one case to SCREAMING_SNAKE_CASE by splitting this string into multiple words using [wordSplitter]. */
fun String.toScreamingSnakeCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.UPPER_UNDERSCORE, wordSplitter)

/** Converts a string from one case to snake_case by splitting this string into multiple words using [wordSplitter]. */
fun String.toSnakeCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.LOWER_UNDERSCORE, wordSplitter)

/** Converts a string from one case to PascalCase by splitting this string into multiple words using [wordSplitter]. */
fun String.toPascalCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.CAPITALIZED_CAMEL, wordSplitter)

/** Converts a string from one case to camelCase by splitting this string into multiple words using [wordSplitter]. */
fun String.toCamelCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.CAMEL, wordSplitter)

/** Converts a string from one case to TRAIN-CASE by splitting this string into multiple words using [wordSplitter]. */
fun String.toTrainCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.UPPER_HYPHEN, wordSplitter)

/** Converts a string from one case to kebab-case by splitting this string into multiple words using [wordSplitter]. */
fun String.toKebabCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.LOWER_HYPHEN, wordSplitter)

/** Converts a string from one case to UPPER SPACE CASE by splitting this string into multiple words using [wordSplitter]. */
fun String.toUpperSpaceCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.UPPER_SPACE, wordSplitter)

/** Converts a string from one case to Title Case by splitting this string into multiple words using [wordSplitter]. */
fun String.toTitleCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.CAPITALIZED_SPACE, wordSplitter)

/** Converts a string from one case to lower space case by splitting this string into multiple words using [wordSplitter]. */
fun String.toLowerSpaceCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.LOWER_SPACE, wordSplitter)

/** Converts a string from one case to UPPER.DOT.CASE by splitting this string into multiple words using [wordSplitter]. */
fun String.toUpperDotCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.UPPER_DOT, wordSplitter)

/** Converts a string from one case to dot.case by splitting this string into multiple words using [wordSplitter]. */
fun String.toDotCase(wordSplitter: WordSplitter = UNIVERSAL_WORD_SPLITTER) = toCase(CaseFormat.LOWER_DOT, wordSplitter)
/*
 * Copyright © 2019, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange

import net.pearx.kasechange.splitter.splitToWords
import net.pearx.kasechange.ConfigCaseFormatter.Config

/**
 * An enumeration that represents a case format that can be used to join a collection of words into one string.
 */
enum class CaseFormat(val config: Config) : CaseFormatter by ConfigCaseFormatter(config) {
    /** SCREAMING_SNAKE_CASE */
    UPPER_UNDERSCORE(Config(true, "_")),
    /** snake_case */
    LOWER_UNDERSCORE(Config(false, "_")),
    /** PascalCase */
    CAPITALIZED_CAMEL(Config(false, null, true, true)),
    /** camelCase */
    CAMEL(Config(false, null, true, false)),
    /** TRAIN-CASE */
    UPPER_HYPHEN(Config(true, "-")),
    /** kebab-case */
    LOWER_HYPHEN(Config(false, "-")),
    /** UPPER SPACE CASE */
    UPPER_SPACE(Config(true, " ")),
    /** Title Case */
    CAPITALIZED_SPACE(Config(false, " ", true, true)),
    /** lower space case */
    LOWER_SPACE(Config(false, " ")),
    /** UPPER.DOT.CASE */
    UPPER_DOT(Config(true, ".")),
    /** dot.case */
    LOWER_DOT(Config(false, "."));
}
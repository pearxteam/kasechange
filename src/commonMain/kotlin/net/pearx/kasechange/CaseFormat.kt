/*
 * Copyright © 2019, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange

/**
 * An enumeration that contains a standard set of [CaseFormatter]s.
 */
enum class CaseFormat(config: CaseFormatterConfig) : CaseFormatter by CaseFormatterConfigurable(config) {
    /** SCREAMING_SNAKE_CASE */
    UPPER_UNDERSCORE(CaseFormatterConfig(true, "_")),
    /** snake_case */
    LOWER_UNDERSCORE(CaseFormatterConfig(false, "_")),
    /** PascalCase */
    CAPITALIZED_CAMEL(CaseFormatterConfig(false, wordCapitalize = true, firstWordCapitalize = true)),
    /** camelCase */
    CAMEL(CaseFormatterConfig(false, wordCapitalize = true, firstWordCapitalize = false)),
    /** TRAIN-CASE */
    UPPER_HYPHEN(CaseFormatterConfig(true, "-")),
    /** kebab-case */
    LOWER_HYPHEN(CaseFormatterConfig(false, "-")),
    /** UPPER SPACE CASE */
    UPPER_SPACE(CaseFormatterConfig(true, " ")),
    /** Title Case */
    CAPITALIZED_SPACE(CaseFormatterConfig(false, " ", wordCapitalize = true, firstWordCapitalize = true)),
    /** lower space case */
    LOWER_SPACE(CaseFormatterConfig(false, " ")),
    /** UPPER.DOT.CASE */
    UPPER_DOT(CaseFormatterConfig(true, ".")),
    /** dot.case */
    LOWER_DOT(CaseFormatterConfig(false, "."));
}
/*
 * Copyright © 2019, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.kasechange


internal actual fun Char.isUpperCasePlatform(): Boolean = isUpperCase()

internal actual fun Char.isLowerCasePlatform(): Boolean = isLowerCase()

internal actual fun Char.isDigitPlatform(): Boolean = isDigit()
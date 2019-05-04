package ru.pearx.kasechange


internal actual fun Char.isUpperCasePlatform(): Boolean = isUpperCase()

internal actual fun Char.isLowerCasePlatform(): Boolean = isLowerCase()

internal actual fun Char.isLetterPlatform(): Boolean = isLetter()
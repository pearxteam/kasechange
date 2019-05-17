package net.pearx.kasechange

internal actual fun Char.isUpperCasePlatform(): Boolean = toUpperCase() == this && toLowerCase() != this

internal actual fun Char.isLowerCasePlatform(): Boolean = toLowerCase() == this && toUpperCase() != this
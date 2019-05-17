package net.pearx.kasechange

fun String.toCase(format: CaseFormat) = format.format(splitToWords())

fun String.toScreamingSnakeCase() = toCase(CaseFormat.UPPER_UNDERSCORE)
fun String.toSnakeCase() = toCase(CaseFormat.LOWER_UNDERSCORE)
fun String.toPascalCase() = toCase(CaseFormat.CAPITALIZED_CAMEL)
fun String.toCamelCase() = toCase(CaseFormat.CAMEL)
fun String.toTrainCase() = toCase(CaseFormat.UPPER_HYPHEN)
fun String.toKebabCase() = toCase(CaseFormat.LOWER_HYPHEN)
fun String.toUpperSpaceCase() = toCase(CaseFormat.UPPER_SPACE)
fun String.toTitleCase() = toCase(CaseFormat.UPPER_SPACE)
fun String.toLowerSpaceCase() = toCase(CaseFormat.LOWER_SPACE)
fun String.toUpperDotCase() = toCase(CaseFormat.UPPER_DOT)
fun String.toDotCase() = toCase(CaseFormat.LOWER_DOT)
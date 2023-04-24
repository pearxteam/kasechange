# KaseChange [![Maven Central](https://img.shields.io/maven-central/v/net.pearx.kasechange/kasechange.svg?label=version&logo=kotlin&logoColor=white)](https://search.maven.org/search?q=g:%22net.pearx.kasechange%22%20AND%20a:%22kasechange%22) [![Awesome Kotlin Badge](https://kotlin.link/awesome-kotlin.svg)](https://github.com/KotlinBy/awesome-kotlin)
[![License](https://img.shields.io/github/license/pearxteam/kasechange.svg)](https://raw.githubusercontent.com/pearxteam/kasechange/master/LICENSE.TXT)
[![Discord](https://img.shields.io/discord/136085738151346176.svg?logo=discord&logoColor=white)](https://discord.gg/q9cX9QE)
![Test & Deploy | develop](https://github.com/pearxteam/kasechange/workflows/Test%20&%20Deploy%20%7C%20develop/badge.svg?branch=develop)
![Test & Deploy | master](https://github.com/pearxteam/kasechange/workflows/Test%20&%20Deploy%20%7C%20master/badge.svg?branch=master)

Multiplatform Kotlin library to convert strings between various case formats

# Supported Case Formats
- SCREAMING_SNAKE_CASE
- snake_case
- PascalCase
- camelCase
- TRAIN-CASE
- kebab-case
- UPPER SPACE CASE
- Title Case
- Sentence case
- lower space case
- UPPER.DOT.CASE
- dot.case
- custom one :)

# Setup
1. Add the lib to your project's dependencies:

* Groovy (replace `$kasechange_version` with the version you want):
```groovy
 // universal dependency for Gradle 5.3 and above
 // in case of multiplatform project, just specify the dependency for commonMain/commonTest source set
 implementation "net.pearx.kasechange:kasechange:$kasechange_version" 
```
```kotlin
 // for Gradle versions below 5.3:
 implementation "net.pearx.kasechange:kasechange-metadata:$kasechange_version" // for Common
 // or
 implementation "net.pearx.kasechange:kasechange-jvm:$kasechange_version" // for JVM
 // or
 implementation "net.pearx.kasechange:kasechange-js:$kasechange_version" // for JS
 // or
 implementation "net.pearx.kasechange:kasechange-android:$kasechange_version" // for Android
 // or
 implementation "net.pearx.kasechange:kasechange-PLATFORM_YOU_WANT:$kasechange_version" // for Native
```

* Kotlin (replace `$kasechangeVersion` with the version you want):
```kotlin
 // universal dependency for Gradle 5.3 and above
 // in case of multiplatform project, just specify the dependency for commonMain/commonTest source set
 implementation("net.pearx.kasechange:kasechange:$kasechangeVersion") 
```
```kotlin
 // for Gradle versions below 5.3:
 implementation("net.pearx.kasechange:kasechange-metadata:$kasechangeVersion") // for Common
 // or
 implementation("net.pearx.kasechange:kasechange-jvm:$kasechangeVersion") // for JVM
 // or
 implementation("net.pearx.kasechange:kasechange-js:$kasechangeVersion") // for JS
 // or
 implementation("net.pearx.kasechange:kasechange-android:$kasechangeVersion") // for Android
 // or
 implementation("net.pearx.kasechange:kasechange-PLATFORM_YOU_WAN:$kasechangeVersion") // for Native
```

2. Use the library and have fun!
# Examples:
 - Transforming string from any case to specific one:
```kotlin
 "IAmAPascalCasedString123".toSnakeCase() // i_am_a_pascal_cased_string_123
 "IAmAPascalCasedString123".toCase(CaseFormat.LOWER_UNDERSCORE)  // i_am_a_pascal_cased_string_123
 "IAmAPascalCasedString123".toCase(to = CaseFormat.LOWER_UNDERSCORE, from = universalWordSplitter())  // i_am_a_pascal_cased_string_123
 "IAmAPascalCasedString123".toSnakeCase(universalWordSplitter())  // i_am_a_pascal_cased_string_123
 "IAmAPascalCasedString123".toCase(to = CaseFormat.LOWER_UNDERSCORE, from = universalWordSplitter(treatDigitsAsUppercase = false))  // i_am_a_pascal_cased_string123
 "IAmAPascalCasedString123".toSnakeCase(universalWordSplitter(treatDigitsAsUppercase = false))  // i_am_a_pascal_cased_string123
```
 - Transforming string from one case to another:
```kotlin
 "123e4567-e89b-12d3-a456-426655440000".toSnakeCase(CaseFormat.LOWER_HYPHEN) // 123e4567_e89b_12d3_a456_426655440000
 "123e4567-e89b-12d3-a456-426655440000".toCase(to = CaseFormat.LOWER_UNDERSCORE, from = CaseFormat.LOWER_HYPHEN)  // 123e4567_e89b_12d3_a456_426655440000
```
- Transforming string to a custom case:
```kotlin
"some_string".toCase(CaseFormatterConfig(false, "..", wordCapitalize = true, firstWordCapitalize = true)) // Some..String
```
 - Splitting a string in any case into words:
```kotlin
 "XMLExtendedParser".splitToWords() // [XML, Extended, Parser]
 "XMLExtendedParser2".splitToWords(universalWordSplitter(treatDigitsAsUppercase = true)) // [XML, Extended, Parser, 2]
 "XMLExtendedParser2".splitToWords(universalWordSplitter(treatDigitsAsUppercase = false)) // [XML, Extended, Parser2]
```
 - Splitting a string in specific case into words:
```kotlin
 "s0meth1ng_in_snake_case".splitToWords(CaseFormat.LOWER_UNDERSCORE) // [s0meth1ng, in, snake, case]
```
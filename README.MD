# KaseChange [![Maven Central](https://img.shields.io/maven-central/v/net.pearx.kasechange/kasechange-metadata.svg?label=common&logo=kotlin&logoColor=white)](https://search.maven.org/search?q=g:%22net.pearx.kasechange%22%20AND%20a:%22kasechange-metadata%22) [![Maven Central](https://img.shields.io/maven-central/v/net.pearx.kasechange/kasechange-jvm.svg?label=jvm&logo=java&logoColor=white)](https://search.maven.org/search?q=g:%22net.pearx.kasechange%22%20AND%20a:%22kasechange-jvm%22) [![Maven Central](https://img.shields.io/maven-central/v/net.pearx.kasechange/kasechange-js.svg?label=js&logo=javascript&logoColor=white)](https://search.maven.org/search?q=g:%22net.pearx.kasechange%22%20AND%20a:%22kasechange-js%22)
[![License](https://img.shields.io/github/license/pearxteam/kasechange.svg)](https://raw.githubusercontent.com/pearxteam/kasechange/master/LICENSE.TXT)
[![Discord](https://img.shields.io/discord/136085738151346176.svg?logo=discord&logoColor=white)](https://discord.gg/q9cX9QE)
[![Release Build Status](https://img.shields.io/jenkins/build/https/ci.pearx.net/job/pearxteam/job/kasechange/job/master.svg?label=build%20%5Bmaster%5D&logo=jenkins&logoColor=white)](https://ci.pearx.net/job/pearxteam/job/kasechange/job/master/)
[![Release Code Coverage](https://img.shields.io/jenkins/coverage/jacoco/https/ci.pearx.net/job/pearxteam/job/kasechange/job/master.svg?label=coverage%20%5Bmaster%5D)](https://ci.pearx.net/job/pearxteam/job/kasechange/job/master/)
[![Develop Build Status](https://img.shields.io/jenkins/build/https/ci.pearx.net/job/pearxteam/job/kasechange/job/develop.svg?label=build%20%5Bdevelop%5D&logo=jenkins&logoColor=white)](https://ci.pearx.net/job/pearxteam/job/kasechange/job/develop/)
[![Develop Code Coverage](https://img.shields.io/jenkins/coverage/jacoco/https/ci.pearx.net/job/pearxteam/job/kasechange/job/develop.svg?label=coverage%20%5Bdevelop%5D)](https://ci.pearx.net/job/pearxteam/job/kasechange/job/develop/)

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
- lower space case
- UPPER.DOT.CASE
- dot.case

# Setup
1. Add the lib to your project's dependencies by copying one of the following lines depending on the platform: 
 - Groovy (replace `$kasechange_version` with the version you want):
```groovy
 implementation "net.pearx.kasechange:kasechange-metadata:$kasechange_version" // for Common
 // or
 implementation "net.pearx.kasechange:kasechange-jvm:$kasechange_version" // for JVM
 // or
 implementation "net.pearx.kasechange:kasechange-js:$kasechange_version" // for JS
```
 - Kotlin (replace `$kasechangeVersion` with the version you want):
```kotlin
 "implementation"("net.pearx.kasechange:kasechange-metadata:$kasechangeVersion") // for Common
 // or
 "implementation"("net.pearx.kasechange:kasechange-jvm:$kasechangeVersion") // for JVM
 // or
 "implementation"("net.pearx.kasechange:kasechange-js:$kasechangeVersion") // for JS
```
2. Use the library and have fun!
# Examples:
 - Transforming string from one case to another:
```kotlin
 "IAmAPascalCasedString".toSnakeCase() // i_am_a_pascal_cased_string
 "IAmAPascalCasedString".toCase(CaseFormat.LOWER_UNDERSCORE)  // i_am_a_pascal_cased_string
```
 - Splitting a string into words:
```kotlin
 "XMLExtendedParser".splitToWords() // [XML, Extended, Parser]
```
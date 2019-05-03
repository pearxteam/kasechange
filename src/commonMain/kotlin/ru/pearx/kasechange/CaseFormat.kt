package ru.pearx.kasechange

enum class CaseFormat(private val wordUppercase: Boolean, private val wordSplitter: Char?, private val firstLetterUppercase: Boolean = false, private val startUppercase: Boolean = false) {
    /* SCREAMING_SNAKE_CASE */
    UPPER_UNDERSCORE(true, '_'),
    /* snake_case */
    LOWER_UNDERSCORE(false, '_'),
    /* PascalCase */
    UPPER_CAMEL(false, null, true, true),
    /* camelCase */
    LOWER_CAMEL(false, null, true, false),
    /* TRAIN-CASE */
    UPPER_HYPHEN(true, '-'),
    /* kebab-case */
    LOWER_HYPHEN(false, '-');

    fun formatTo(appendable: Appendable, words: Iterable<String>) {
        appendable.apply {
            for ((index, word) in words.withIndex()) {
                if (wordSplitter != null && index != 0)
                    append(wordSplitter)
                append(when {
                    wordUppercase -> word.toUpperCase()
                    index == 0 -> {
                        when {
                            startUppercase -> word.toLowerCase().capitalize()
                            else -> word.toLowerCase()
                        }
                    }
                    firstLetterUppercase -> word.toLowerCase().capitalize()
                    else -> word.toLowerCase()
                })
            }
        }
    }

    fun formatTo(appendable: Appendable, vararg words: String) = formatTo(appendable, words.asIterable())

    fun format(words: Iterable<String>): String = StringBuilder().also { formatTo(it, words) }.toString()

    fun format(vararg words: String) = format(words.asIterable())
}
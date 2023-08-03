package kityukha.kotlin.countriesapp

import java.text.NumberFormat

fun languagesToString(languages: List<Language>): String {
//    var result = ""
//    for ((index, language) in languages.withIndex())
//        if (index != languages.lastIndex)
//            result += { "${language.name}, " }
//        else
//            result += language.name
//
//    return result

    return languages.joinToString { it.name }
}


fun formatNumber(number: Long): String {
    return NumberFormat.getNumberInstance().format(number)
}
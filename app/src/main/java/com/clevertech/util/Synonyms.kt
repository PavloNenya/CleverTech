package com.clevertech.util

enum class Synonyms (
    private val synonyms : List<String>
) {
    LIGHT(listOf("світло", "ліхтарі", "лампочки", "лампочка", "ліхтар", "лампочку")),
    TURN_ON(listOf("увімкнути", "ввімкнути", "включити")),
    TURN_OFF(listOf("вимкнути", "виключити")),
    IN(listOf("в", "у"))
    ;
    fun synonyms() : List<String> {
        return synonyms
    }
}
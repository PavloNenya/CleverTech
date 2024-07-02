package com.clevertech.util.commands

interface CommandContext {
    fun toJson() : String
    fun deserialize(string: String) : CommandContext
}
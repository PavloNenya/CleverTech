package com.clevertech.util.commands

interface CommandContext {
    fun deserialize(string: String) : CommandContext
}
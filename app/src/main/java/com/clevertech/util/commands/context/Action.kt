package com.clevertech.util.commands.context

interface Action {
    fun serialize() : String
    fun deserialize(string: String) : Action
}
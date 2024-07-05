package com.clevertech.util.commands.action

abstract class Action {
    abstract fun serialize() : String

    abstract fun deserialize(string: String) : Action
}
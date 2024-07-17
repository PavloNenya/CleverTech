package com.clevertech.util.commands.action

interface Action {

    override fun toString(): String
    fun deserialize(string: String) : Action
}
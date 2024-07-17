package com.clevertech.util.commands

import com.clevertech.util.commands.action.Action

abstract class Command {

    fun execute() /*: CommandResult */{
        val command = toString()

//      TODO  return parseCommandResult();
    }
    override fun toString(): String {
        return "{ " +
                "\"object\":\"${getObject()}\"," +
                "\"action\":\"${getAction()}\", " +
                "\"context\":${getContext()}  " +
                "}"
    }

    abstract fun getObject(): CommandObject
    abstract fun getAction(): Action?
    abstract fun getContext(): CommandContext?
    abstract fun deserialize(string: String) : Command
}
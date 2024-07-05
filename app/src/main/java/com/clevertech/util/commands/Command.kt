package com.clevertech.util.commands

import com.clevertech.util.commands.action.Action

abstract class Command {

    fun execute() /*: CommandResult */{
        val command = toJson()

//      TODO  return parseCommandResult();
    }
    fun toJson(): String {
        return "{ " +
                "\"object\":${getObject()}," +
                "\"type\":${getAction()}, " +
                "\"context\":${getContext()},  " +
                "}"
    }

    abstract fun getObject(): CommandObject
    abstract fun getAction(): Action
    abstract fun getContext(): CommandContext
    abstract fun deserialize(string: String) : Command
}
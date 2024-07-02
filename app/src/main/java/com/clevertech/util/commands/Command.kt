package com.clevertech.util.commands

abstract class Command {

    fun execute() /*: CommandResult */{
        val command = toJson()

//      TODO  return parseCommandResult();
    }

    abstract fun toJson() : String
    abstract fun deserialize(string: String) : Command
}
package com.clevertech.util.commands.`object`.light

import com.clevertech.util.commands.Command
import com.clevertech.util.commands.CommandContext
import com.clevertech.util.commands.CommandObject
import com.clevertech.util.commands.action.Action

class LightCommand(
    private val context: CommandContext,
    private val commandObject: CommandObject,
    private val action: Action
): Command() {
    private val type = CommandObject.LIGHT

    override fun getObject(): CommandObject {
        return commandObject
    }

    override fun getAction(): Action {
        return action
    }

    override fun getContext(): CommandContext {
        return context
    }

    override fun deserialize(string: String): Command {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return super.toString()
    }

}
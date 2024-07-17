package com.clevertech.util.commands.objects.light

import com.clevertech.util.commands.Command
import com.clevertech.util.commands.CommandContext
import com.clevertech.util.commands.CommandObject
import com.clevertech.util.commands.action.Action

class LightCommand(
    private val context: CommandContext?,
    private val action: Action?
): Command() {
    override fun getObject(): CommandObject {
        return CommandObject.LIGHT
    }

    override fun getAction(): Action? {
        return action
    }

    override fun getContext(): CommandContext? {
        return context
    }

    override fun deserialize(string: String): Command {
        TODO("Not yet implemented")
    }

}
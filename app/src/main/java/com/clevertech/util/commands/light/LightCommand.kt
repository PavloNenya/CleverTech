package com.clevertech.util.commands.light

import com.clevertech.util.commands.Command
import com.clevertech.util.commands.CommandContext
import com.clevertech.util.commands.CommandType

class LightCommand(
    private val context: CommandContext
): Command() {
    private val type = CommandType.LIGHT

    override fun toJson(): String {
        val contextString = context.toJson()
        return "{ \"context\"$contextString, \"type\":$type }"
    }

    override fun deserialize(string: String): Command {
        TODO("Not yet implemented")
    }

}
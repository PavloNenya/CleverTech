package com.clevertech.util.commands.objects.light

import com.clevertech.util.commands.CommandContext
import com.clevertech.util.commands.context.Room

class LightCommandContext(
    private val room: Room?,
    private val toggle: Boolean?,
    private val brightness: Int?,
    private val color: Int?
): CommandContext {

    override fun deserialize(string: String): CommandContext {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "{" +
                "\"room\":$room," +
                "\"toggle\":$toggle," +
                "\"brightness\":$brightness," +
                "\"color\":$color " +
                "}"
    }

}
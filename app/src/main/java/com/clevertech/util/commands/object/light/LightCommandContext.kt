package com.clevertech.util.commands.`object`.light

import com.clevertech.util.commands.CommandContext
import com.clevertech.util.commands.context.Room

class LightCommandContext(
    private val room: Room
): CommandContext {

    override fun deserialize(string: String): CommandContext {
        TODO("Not yet implemented")
    }


    fun getRoom() : Room {
        return room
    }
}
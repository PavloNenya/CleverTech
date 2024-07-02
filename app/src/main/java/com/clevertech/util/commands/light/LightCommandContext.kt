package com.clevertech.util.commands.light

import com.clevertech.util.commands.CommandContext
import com.clevertech.util.commands.context.Room

class LightCommandContext(
    private val action: LightAction,
    private val room: Room
): CommandContext {

    override fun toJson(): String {
        val actionString = action.serialize()
        val roomString = room.serialize()
        return "{ \"action\"$actionString, \"room\":$roomString }"
    }

    override fun deserialize(string: String): CommandContext {
        TODO("Not yet implemented")
    }

    fun getAction(): LightAction {
        return action
    }

    fun getRoom() : Room {
        return room
    }
}
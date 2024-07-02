package com.clevertech.util.commands.light

import com.clevertech.util.commands.context.Action

class LightAction(
    private val toggle: Boolean,
    private val brightness: Int,
    private val color: Int // TODO refactor
): Action {

    override fun serialize(): String {
        return "{" +
                    "\"toggle\":$toggle," +
                    "\"brightness\":$brightness," +
                    "\"color\":$color " +
                "}"
    }

    override fun deserialize(string: String): Action {
        TODO("Not yet implemented")
    }

}
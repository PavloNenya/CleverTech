package com.clevertech.util.commands.`object`.light

import com.clevertech.util.commands.action.Action
import java.util.Collections

class LightAction(
    private val toggle: Boolean,
    private val brightness: Int,
    private val color: Int
): Action() {

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

    companion object {
        val LIGHT_ACTION_ON = "увімкнути"
        val LIGHT_ACTION_OFF = "вимкнути"
        val LIGHT_ACTION_CHANGE_BRIGHTNESS = "яскравість"
        val LIGHT_ACTION_CHANGE_COLOR = "колір"

    }
}
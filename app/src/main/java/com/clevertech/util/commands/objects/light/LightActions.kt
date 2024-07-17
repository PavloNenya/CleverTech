package com.clevertech.util.commands.objects.light

import com.clevertech.util.commands.action.Action

enum class LightAction(
    private val stringRepresentation : String
): Action {
    LIGHT_ACTION_ON("увімкнути"),
    LIGHT_ACTION_OFF("вимкнути"),
    LIGHT_ACTION_CHANGE_BRIGHTNESS("яскравість"),
    LIGHT_ACTION_CHANGE_COLOR("колір")
    ;

    fun getStringRepresentation() : String {
        return stringRepresentation
    }

    override fun toString(): String {
        return this.name
    }

    override fun deserialize(string: String): Action {
        TODO("Not yet implemented")
    }

}
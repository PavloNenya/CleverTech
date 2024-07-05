package com.clevertech.util

import com.clevertech.util.commands.CommandContext
import com.clevertech.util.commands.CommandObject
import com.clevertech.util.commands.action.Action

class WordParser {


    fun parse(words: Array<String>) {
        val it = words.iterator()

        while (it.hasNext()) {
            val word = it.next()
//            if()
        }
    }

    companion object {
        val actions = HashMap<String, Action>()
        val objects = HashMap<String, CommandObject>()
        val context = HashMap<String, CommandContext>()

        init {
            fillActions()
            fillObjects()
            fillContext()
        }

        fun fillActions() {

        }

        fun fillObjects() {

        }

        fun fillContext() {

        }
    }
}
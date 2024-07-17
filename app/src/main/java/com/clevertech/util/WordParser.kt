package com.clevertech.util

import com.clevertech.util.commands.Command
import com.clevertech.util.commands.CommandContext
import com.clevertech.util.commands.CommandObject
import com.clevertech.util.commands.action.Action
import com.clevertech.util.commands.context.Room
import com.clevertech.util.commands.objects.light.LightAction
import com.clevertech.util.commands.objects.light.LightCommand
import com.clevertech.util.commands.objects.light.LightCommandContext

class WordParser {

    companion object {

        val actions = HashMap<String, Action>()
        val objects = HashMap<String, CommandObject>()
        val contexts = HashMap<String, CommandContext>()

        init {
            fillActions()
            fillObjects()
            fillContext()
        }

        fun parseWords(words: ArrayList<String>?) : Command? {
            var command : Command? = null
            words?.let {
                val iterator = it.iterator().next().split(" ").iterator()
                println()
                // action - object - context
                var action : Action?
                var obj: CommandObject? = null
                var context: CommandContext?

                while (iterator.hasNext()) {
                    val actionWord = iterator.next().lowercase()
                    println(actionWord)
                    action = actions[actionWord]
                    if(iterator.hasNext()) {
                        val objectWord = iterator.next().lowercase()
                        obj = objects[objectWord]
                    }

                    val contextWords = ArrayList<String>()
                    iterator.forEachRemaining {remaining ->
                        contextWords.add(remaining.lowercase())
                    }
                    context = parseContext(contextWords, obj, action)
                    println(obj)
                    if(obj == CommandObject.LIGHT) {
                        command = LightCommand(context, action)
                    }
                }
            }
            return command
        }

        private fun parseContext(
            contextWords: ArrayList<String>,
            obj: CommandObject?,
            action: Action?
        ): CommandContext? {
            var context : CommandContext? = null
            if(obj == CommandObject.LIGHT) {
                context = parseLightContext(action, contextWords)
            }
            return context
        }

        private fun parseLightContext(action: Action?, contextWords: ArrayList<String>): CommandContext? {
            var context : CommandContext? = null
            if (action == LightAction.LIGHT_ACTION_ON || action == LightAction.LIGHT_ACTION_OFF) {
                var room : Room? = null
                val iterator = contextWords.iterator()
                while(iterator.hasNext()) {
                    val word = iterator.next()
                    if (word.equals(getSynonyms("в", Synonyms.IN))){
                        if(iterator.hasNext()) {
                            room = Room(iterator.next())
                        }
                    }
                }
                context = LightCommandContext(room, action == LightAction.LIGHT_ACTION_ON, null, null)
            }
            return context
        }

//        private fun parseObject(objectWord: String): CommandObject? {
//            CommandObject.entries.forEach {
//                if(it.name == objectWord) {
//                    return it
//                }
//            }
//            return null
//        }

        fun fillActions() {
            actions.putAll(getSynonyms(LightAction.LIGHT_ACTION_ON.getStringRepresentation(),
                LightAction.LIGHT_ACTION_ON
            ))
            actions.putAll(getSynonyms(LightAction.LIGHT_ACTION_OFF.getStringRepresentation(),
                LightAction.LIGHT_ACTION_OFF))
        }

        fun fillObjects() {
            objects.putAll(getSynonyms("світло", CommandObject.LIGHT))
//            objects.putAll(getSynonyms("холодильник", CommandObject.FREEZER))
        }

        fun fillContext() {

        }

        fun <OUT> getSynonyms(baseWord : String, association : OUT) : Map<String, OUT>{
            val map = HashMap<String,OUT>()
            val literal = Synonyms.values().let { synonyms ->
                synonyms.forEach {
                    if(it.synonyms().contains(baseWord)) {
                        return@let it
                    }
                }
                throw IllegalArgumentException()
            }

            val list = literal.synonyms().forEach {
                map[it] = association
            }
            return map
        }

    }
}
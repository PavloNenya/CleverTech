package com.clevertech.util.commands.context

 class Room(
     private val id : String
 )

 {
    fun serialize() : String {
        return id
    }
}
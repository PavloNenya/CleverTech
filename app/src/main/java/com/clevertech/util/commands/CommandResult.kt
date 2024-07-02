package com.clevertech.util.commands

interface CommandResult {
    fun getException() : Throwable?
    fun isSuccessful() : Boolean
}
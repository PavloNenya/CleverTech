package com.clevertech.util.commands.objects.light

import com.clevertech.util.commands.CommandResult

class LightCommandResult: CommandResult {
    private var exception: Exception? = null
    private var success = false;

    override fun getException(): Throwable? {
        return exception
    }

    override fun isSuccessful(): Boolean {
        return success
    }
}
package com.clevertech.network.http

import com.clevertech.BASE_URL
import com.clevertech.PORT
import com.clevertech.util.commands.Command
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.net.SocketTimeoutException

class HttpUtil {

    companion object {
        private val client = OkHttpClient()
        suspend fun getResponse(request: Request): Response? {
            println(request)
            var response : Response? = null
            try {
                response = client.newCall(request).execute()

            } catch (e: SocketTimeoutException) {
                println("Socket not found!")
            }
            return response
        }

        fun buildRequest(command: Command?): Request {
            if(command == null) {
                throw IllegalArgumentException("Command is null")
            }
            println("Command : $command")
            val r = Request.Builder()
                .url("$BASE_URL:$PORT/exec")
                .post(command.toString().toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull()))
                .build()
            return r
        }

    }

}
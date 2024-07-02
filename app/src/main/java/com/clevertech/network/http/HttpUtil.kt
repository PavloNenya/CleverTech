package com.clevertech.network.http

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class HttpUtil {
    suspend fun getResponse(request: Request): Response? {
        var response : Response?
        val client = OkHttpClient()
        response = client.newCall(request).execute()
        return response
    }
}
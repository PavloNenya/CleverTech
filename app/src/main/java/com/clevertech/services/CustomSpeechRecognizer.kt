package com.clevertech.services

import android.os.Bundle
import android.speech.RecognitionListener

class CustomSpeechRecognizer : RecognitionListener {
    // Own
    private var callback: (partialResults: Bundle?) -> Int

    constructor(callback: (partialResults: Bundle?) -> Int) {
        this.callback = callback
    }

    // RecognitionListener functions
    override fun onReadyForSpeech(params: Bundle?) {
//        TODO("Not yet implemented")
    }

    override fun onBeginningOfSpeech() {
//        TODO("Not yet implemented")
    }

    override fun onRmsChanged(rmsdB: Float) {
//        TODO("Not yet implemented")
    }

    override fun onBufferReceived(buffer: ByteArray?) {
//        TODO("Not yet implemented")
    }

    override fun onEndOfSpeech() {
//        TODO("Not yet implemented")
    }

    override fun onError(error: Int) {
//        TODO("Not yet implemented")
    }

    override fun onResults(results: Bundle?) {
        callback.invoke(results)
    }

    override fun onPartialResults(partialResults: Bundle?) {
//        callback.invoke(partialResults)
    }

    override fun onEvent(eventType: Int, params: Bundle?) {
//        TODO("Not yet implemented")
    }
}
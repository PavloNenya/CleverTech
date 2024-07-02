package com.clevertech

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.clevertech.network.http.HttpUtil
import com.clevertech.services.CustomSpeechRecognizer
import com.clevertech.ui.theme.CleverTechTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Request
import java.util.regex.Pattern

class MainActivity : ComponentActivity() {
    private val dynamicText = mutableStateOf("Sample text")
    private lateinit var voiceInputCallback :  (Bundle?) -> Int
    private val httpUtil = HttpUtil()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) !=
            PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.RECORD_AUDIO),
                1)

        }

        var printedText = ""
        voiceInputCallback = fun (results: Bundle?): Int {
            if (results != null) {
                val t = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    ?.get(0) ?: "Error"

                println(results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION))
                val newText = t.replaceFirst(Pattern.quote(printedText), "")
                dynamicText.value = newText
                printedText = t


                val res = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                val isToggleLight: Boolean = parseWords(res)
                val r = buildRequest(isToggleLight)
                lifecycleScope.launch(Dispatchers.IO) {
                    val response = httpUtil.getResponse(r)
                }

                return 1
            }
            return 0;
        }

        startUI()
    }

    private fun startUI() {
        setContent {
            CleverTechTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Greeting(
                        text = dynamicText
                    )
                    Button(onClick = {
                        val sr = SpeechRecognizer.createSpeechRecognizer(this@MainActivity)
                        sr.setRecognitionListener(CustomSpeechRecognizer(voiceInputCallback))
                        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
                        intent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true)
                        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1)
                        sr.startListening(intent)
                    }) {
                        Text(text = "Press to start listen")
                    }
                }
            }
        }
    }

    private fun buildRequest(toggle: Boolean): Request {
        val mode = if(toggle) {
            "H"
        } else {
            "L"
        }
        val r = Request.Builder()
            .url("$BASE_URL:$PORT/$mode")
            .build()
        return r
    }

    private fun parseWords(words: ArrayList<String>?): Boolean {
        var res = false
        words?.let {
            println(words)
            if(it[0].lowercase() == "увімкнути світло" || it[0].lowercase() == "ввімкнути світло") {
                res = true
            }
            if(it[0].lowercase() == "вимкнути світло") {
                res = false
            }
        }

        return res
    }

}

@Composable
fun Greeting(text: MutableState<String>, modifier: Modifier = Modifier) {
    val t by text
    Text(
        text = t,
        modifier = modifier
    )
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CleverTechTheme {
        Greeting(mutableStateOf("Android"))
    }
}
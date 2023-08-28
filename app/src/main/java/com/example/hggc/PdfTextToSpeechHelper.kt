package com.example.hggc

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

class PdfTextToSpeechHelper(context: Context) {
    private var textToSpeech: TextToSpeech? = null
    private var isReading = false
    private var completionListener: OnCompletionListener? = null

    interface OnCompletionListener {
        fun onCompletion()
    }

    init {
        // Initialize the TextToSpeech instance
        textToSpeech = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = textToSpeech?.setLanguage(Locale.US)
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    // Handle language data missing or not supported
                }
            } else {
                // Handle text-to-speech initialization failure
            }
        }

        // Set up the completion listener
        textToSpeech?.setOnUtteranceCompletedListener { utteranceId ->
            if (utteranceId == "endOfSpeech") {
                isReading = false
                completionListener?.onCompletion()
            }
        }
    }

    fun startSpeaking(
        pdfText: String,
        completionListener: PdfTextToSpeechHelper.OnCompletionListener
    ) {
        if (!isReading) {
            this.completionListener = completionListener
            textToSpeech?.speak(pdfText, TextToSpeech.QUEUE_FLUSH, null, "endOfSpeech")
            isReading = true
        }
    }

    fun stopSpeaking() {
        if (isReading) {
            textToSpeech?.stop()
            isReading = false
        }
    }

    fun shutdown() {
        textToSpeech?.shutdown()
        isReading = false
    }
}

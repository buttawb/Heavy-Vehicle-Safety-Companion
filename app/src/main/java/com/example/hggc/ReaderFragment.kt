package com.example.hggc


import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.appcompat.app.AppCompatActivity
import com.example.hggc.PDF.PDFView
import com.example.hggc.PDF.util.FitPolicy
import java.io.InputStream


class ReaderFragment : AppCompatActivity() {
    private lateinit var textToSpeech: TextToSpeech
    private lateinit var extractedText: String // Declare the extracted text variable
    private lateinit var pdfInputStream: InputStream // Input stream for the PDF

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_reader)

        val pdfView = findViewById<PDFView>(R.id.pdfReader)

        // Retrieve the PDF file name from the arguments
        val pdfFileName = intent?.getStringExtra("pdfFileName")

        if (pdfFileName != null) {
            // Open the specific PDF file from assets based on the passed parameter
            pdfInputStream = assets.open(pdfFileName)

            pdfView.fromStream(pdfInputStream)
                .enableSwipe(true)
                .swipeHorizontal(true)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true)
                .spacing(0)
                .pageFitPolicy(FitPolicy.WIDTH)
                .load()
        }
    }
}

//        // Handle errors here
//        textToSpeech = TextToSpeech(this) { status ->
//            if (status == TextToSpeech.SUCCESS) {
//                val result = textToSpeech.setLanguage(Locale.US)
//                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                    // Handle language data missing or not supported
//                } else {
//                    // Text-to-speech is initialized successfully
//                    // Call the extractData method to extract text and store it in extractedText
//                    extractedText = extractData()
//                }
//            } else {
//                // Handle text-to-speech initialization failure
//            }
//        }
//
//        var isPLaying = false
//
//        val btn = findViewById<Button>(R.id.btn_read)
//        btn.setOnClickListener {
//            if (isPLaying) {
//                btn.text = "Play"
//                textToSpeech.stop()
//                isPLaying = false
//            } else {
//                btn.text = "Stop"
//                isPLaying = true
//                textToSpeech.speak(extractedText, TextToSpeech.QUEUE_FLUSH, null)
//            }
//        }
//    }
//
//    private fun extractData(): String {
//        return try {
//            var extractedText = ""
//            val pdfReader: PdfReader = PdfReader(pdfInputStream)
//            val n = pdfReader.numberOfPages
//            for (i in 0 until n) {
//                extractedText += PdfTextExtractor.getTextFromPage(pdfReader, i + 1).trim() + "\n"
//            }
//            pdfReader.close()
//            if (extractedText.isBlank()) {
//                "No text found in the PDF."
//            } else {
//                extractedText
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//            "Error extracting text from PDF: ${e.message}"
//        }
//    }


package com.example.hggc.ui.gallery

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hggc.PDF.PDFView
import com.example.hggc.PDF.util.FitPolicy
import com.example.hggc.R
import java.io.InputStream

class GalleryFragment : Fragment() {

    private lateinit var textToSpeech: TextToSpeech
    private lateinit var extractedText: String // Declare the extracted text variable
    private lateinit var pdfInputStream: InputStream

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_reader, container, false)

        val pdfView = view.findViewById<PDFView>(R.id.pdfReader)

        // Hardcode the PDF file name to "econtacts.pdf"
        val pdfFileName = "econtacts.pdf"

        // Open the specific PDF file from assets based on the hardcoded name
        pdfInputStream = requireContext().assets.open(pdfFileName)

        pdfView.fromStream(pdfInputStream) // Load the PDF from the input stream
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

        // Initialize Text-to-Speech here if needed

        return view
    }
}

package com.example.hggc.procedures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hggc.R
import com.example.hggc.PdfTextToSpeechHelper
import android.content.Context
import android.widget.Button

/**
 * A simple [Fragment] subclass.
 * Use the [Policy1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Procedure3Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var pdfTextToSpeechHelper: PdfTextToSpeechHelper
    private var isReading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_procedure3, container, false)

        // PDF content (replace with your actual PDF text)
        val pdfText = "PRODUCT HANDLING AND ASSOCIATED RISKS:\n" +
                "1. Store product in correctly labelled containers\n" +
                "2. Follow any instructions on product labels\n" +
                "3. Wear correct protective clothing\n" +
                "4. Use barrier cream and/or gloves\n" +
                "5. Avoid skin contact\n" +
                "6. Avoid breathing vapors.\n" +
                "7. Never swallow / mouth siphoning\n" +
                "8. No eating/smoking\n" +
                "9. Keep all ignition sources away\n" +
                "10. If the product makes contact with your skin, remove it from the skin promptly by washing hands with soap\n" +
                "11. Do not use product to remove oil/grease from the skin\n" +
                "12. After handling the product, Wash hands and face before eating, drinking, toilet needs\n" +
                "13. Get first aid for cuts and scratches\n" +
                "14. Get medical advice for abnormal skin conditions\n" +
                "15. Use the following PPE for product handling.\n" +
                "• Gloves (gauntlets, thermally insulated, impervious to liquids)\n" +
                "• safety boots\n" +
                "• goggles\n" +
                "• side shields\n" +
                "• full-face shields\n" +
                "• safety helmets with chin guard\n" +
                "• Clothes (cotton / natural, anti-static)\n" +
                "16. For more details, read driver’s hand book, which is available in every vehicle."
        // Initialize your PDFTextToSpeechHelper
        pdfTextToSpeechHelper = PdfTextToSpeechHelper(requireContext())

        // Find the "Read PDF" button
        val btnRead = view.findViewById<Button>(R.id.btnRead)

        btnRead.setOnClickListener {
            if (isReading) {
                // Stop reading and change button text
                pdfTextToSpeechHelper.stopSpeaking()
                btnRead.text = "Start Reading"
                isReading = false
            } else {
                // Start reading and change button text
                pdfTextToSpeechHelper.startSpeaking(
                    pdfText,
                    object : PdfTextToSpeechHelper.OnCompletionListener {
                        override fun onCompletion() {
                            // This is called when the speech is completed
                            activity?.runOnUiThread {
                                btnRead.text = "Start Reading" // Change button text when done
                                isReading = false
                            }
                        }
                    })
                btnRead.text = "Stop Reading"
                isReading = true
            }
        }



        return view
    }

    override fun onStop() {
        super.onStop()
        // Stop reading and reset button text when the fragment is stopped
        if (isReading) {
            pdfTextToSpeechHelper.stopSpeaking()
        }
    }

    companion object {

    }
}
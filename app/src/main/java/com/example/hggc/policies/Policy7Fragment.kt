package com.example.hggc.policies

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
class Policy7Fragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_policy7, container, false)

        // PDF content (replace with your actual PDF text)
        val pdfText =
            "To maintain the quality of the Company, HGGC has adopted a policy of rewards and sanctions for its drivers which must be followed\n" +
                    "The objectives of this policy are as follows:\n" +
                    "1. Link rewards and restrictions to performance measuring.\n" +
                    "2. Lay a foundation for ideal performance.\n" +
                    "3. Encourage the driver to perform better.\n" +
                    "4. Encourage competition in service delivery.\n" +
                    "5. Promote innovation and creativity in service delivery."

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
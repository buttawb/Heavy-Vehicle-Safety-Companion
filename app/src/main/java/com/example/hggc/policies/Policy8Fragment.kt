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
class Policy8Fragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_policy8, container, false)

        // PDF content (replace with your actual PDF text)
        val pdfText =
            "Seat belts hold the occupants in the consequence of a sudden brake or accident, which can save lives, which is why all the employees of HAJI GUL GROUP OF COMPANIES must follow the following policy.\n" +
                    "All HGGC and connector vehicles used for the company's work will be fitted with seat belts for all passengers.\n" +
                    "The seat belt should have three points:\n" +
                    "1. Seat belts must be used on all drivers and passengers traveling for company work.\n" +
                    "2. All seats should have head restraints.\n" +
                    "3. The condition of the seat belt should be checked during vehicle inspection.\n" +
                    "HGGC staff and contractors are also encouraged to follow this policy whether they are driving private vehicles or not on the job."

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
package com.example.hggc.emergencyprocedures

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
class EmergProc3Fragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_emerg_proc3, container, false)

        // PDF content (replace with your actual PDF text)
        val pdfText = "MEDICAL EMERGENCY PLAN\n" +
                "\n" +
                "•In case of small medical emergency e.g. small cuts, or burns, providefirst aid service with the help of a first aid kit, which is available in thevehicle\n" +
                "•In case of any serious injury, call the nearest hospital or ambulance\n" +
                "•Do not leave the injured person unattended\n" +
                "•Inform supervisor as soon as possible\n"
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
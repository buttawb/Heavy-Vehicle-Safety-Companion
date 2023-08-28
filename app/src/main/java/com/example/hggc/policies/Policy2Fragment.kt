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
class Policy2Fragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_policy2, container, false)

        // PDF content (replace with your actual PDF text)
        val pdfText = "" +
                "Fatigue is a significant risk for drivers and can be caused by constant work, improper rest, or lack of sleep. For this reason, HGGC limits the maximum driving and working hours and is allowed specific driving and working.\n" +
                "The driving/working limits are as follows, and if the customer's demand is better, it will prevail.\n" +
                "A maximum of 4 hours 30 minutes (continuous) of driving after a minimum of 30 minutes of rest is mandatory. However, it is advisable to rest 15 minutes after driving every 2 hours.\n" +
                "1. A maximum of 10 hours can be driven in a day.\n" +
                "2. A maximum of 56 hours can be driven in a week.\n" +
                "3. A maximum of 12 hours can be worked in a day.\n" +
                "4. A maximum of 72 hours can be worked in a week.\n" +
                "5. A minimum of 9 consecutive hours of rest is mandatory in 1 day.\n" +
                "6. A minimum of 24 consecutive hours of rest in a week.\n" +
                "It is the responsibility of drivers to get proper rest. In case of fatigue, it is important to inform your supervisor for further guidance. Fatigue is a significant risk for drivers and can be caused by constant work, improper rest, or lack of sleep."

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
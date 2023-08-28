package com.example.hggc;

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
class RewardsFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_rewards, container, false)

        // PDF content (replace with your actual PDF text)
        val pdfText =
            "Driver Evaluation Procedure: 1 This procedure shall be applicable to all active tank lorry drivers of the company who have completed DDC and other related trainings.\n" +
                    "2 Drivers shall be evaluated for Driver League System on quarterly performance and merit points will be awarded to them as per the following criteria:\n" +
                    "3 All merit points will be recorded in KPI Sheet when points are awarded as per scoring criteria. The sheet will be kept updated by the Operation Manager/Supervisor.\n" +
                    "4 Awarded points shall be classified into three categories:\n" +
                    "❖ 1st: Those scoring the highest % of criteria score in a quarter.\n" +
                    "❖ 2nd: Those scoring 2nd highest % of criteria score in a quarter.\n" +
                    "❖ 3rd: Those scoring 3rd highest % of criteria score in a quarter.\n" +
                    "5 Following incentives shall be awarded to those who secure in the above categories:\n" +
                    "❖ 1st Position: shall be awarded 75% of the monthly salary.\n" +
                    "❖ 2nd Position: shall be awarded 50% of the monthly salary.\n" +
                    "❖ 3rd Position: shall be awarded 50% of the monthly salary\n"

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
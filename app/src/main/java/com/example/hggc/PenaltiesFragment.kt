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
class PenaltiesFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_penalties, container, false)

        // PDF content (replace with your actual PDF text)
        val pdfText =
            " Nature of violations: Driving at a speed higher than the prescribed speed or applying hard brakes or overtaking the wrong way, and suddenly turning the car.\n" +
                    "Driving on a prohibited route or location or taking an alternate route without informing the office.\n" +
                    "Stopping for more than 10 minutes at a prohibited or unapproved resting place or parking the vehicle in a starting position. Stopping the car at the black spot.\n" +
                    "Don't tell or take pre-trip briefings about violations or fatigue of scheduled driving and rest hours.\n" +
                    "Driver not contacting the office while traveling, refusing to fill the trip log, buying diesel for the vehicle in an unauthorized manner.\n" +
                    "The driver does not have the necessary documents or writing on the necessary documents or not having a handbook, term card.\n" +
                    "Violating The JMP Or Company Rules and Regulations.\n" +
                    "Not inspecting the vehicle daily, neglecting to keep the vehicle in good condition, the driver not reporting the defect inside the vehicle or trying to fix the vehicle's fault himself without permission.\n" +
                    "Not reporting a hose pipe leak or any other kind of product leakage.\n" +
                    "Not checking fire cylinders, and other necessary equipment or circling 360 degrees, placing loose items inside the cabin.\n" +
                    "Violation of driver's defense driving rules, not using signals, unnecessary use of horns.\n" +
                    "Driver not following traffic signals or driving on the wrong side or opening the car door without looking back.\n" +
                    "Using hand-breaking items while driving (triangle mobile, hand-free, tape recorder, and others).\n" +
                    "The driver does not use protective gear or take the help of another driver when reversing.\n" +
                    "Not using safety cones or earth cables or not checking earth points on the site or misbehaving with the customer.\n" +
                    "Not filling the emptying checklist completely or not using interlock and well square.\n" +
                    "The driver's stop work policy process is not compliant or the vehicle is filled and emptied against the plan setting.\n" +
                    "Poor appearance or lack of cleanliness or not keeping the car clean or hiding your illness.\n" +
                    "The driver should keep the covers of the tank open during the journey, do not report any accident or report a possible accident.\n" +
                    "The driver's misbehavior or narrow-mindedness with other drivers or fighting with others.\n" +
                    "Don't keep the driver's first aid and spill kit right.\n" +
                    "Driver not attending toolbox meetings, and other training sessions."

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
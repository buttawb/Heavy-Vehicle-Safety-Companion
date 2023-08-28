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
class Procedure5Fragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_procedure5, container, false)

        // PDF content (replace with your actual PDF text)
        val pdfText = "VEHICLE PARKING RULES:\n" +
                "1. The driver should assess the parking area before parking the vehicle. Following are few checks that need to be performed:\n" +
                "• Is there proper access to the rest area, with an appropriate approach road?\n" +
                "• Has the site got enough parking spaces to park the vehicle safely?\n" +
                "• Has the site got enough facility for drivers to take rest?\n" +
                "• Is the land is solid enough to bear the vehicle load?\n" +
                "• Is there proper lighting in the parking?\n" +
                "• Is there any fuel station nearby?\n" +
                "• Is there any maintenance facility available on the site?\n" +
                "• Is there any hazard of flames or welding in the nearby area?\n" +
                "• Is there proper security available in that place?\n" +
                "2. If all of the above-mentioned hazards are assessed and no problem is found then the driver can park his vehicle at the site.\n" +
                "3. After Parking:\n" +
                "• Always Lock Your Doors\n" +
                "• Roll Up and Lock Your Windows\n" +
                "• Do Not Leave Valuables Insight - (phones, pagers, purses, wallets, etc., invite theft)\n" +
                "• Put valuables and packages in the trunk or out of sight before arriving at the parking facility.\n" +
                "• Do Not Leave the vehicle unattended.\n" +
                "• If you have the option, choose a well-lit parking spot.\n" +
                "• Do not hide a spare key in or on your vehicle - it can be found.\n" +
                "• Be aware and report any suspicious activity immediately by calling HGGC Emergency # 0346-6381599 or for emergencies dial 15\n" +
                "4. When returning to your vehicle:\n" +
                "• Return to your vehicle along with another driver.\n" +
                "• Have your door keys in hand?\n" +
                "• When approaching your vehicle look inside before entering to make sure there are no unwanted occupants. After entering, lock all doors.\n" +
                "• Once inside the vehicle, lock the door and start the engine. Start moving the vehicle as soon as possible after getting situated.\n" +
                "• If there is any concern for personal safety, for any reason, notify the Police immediately or call HGGC ER number 0346-6381599\n" +
                "• Never offer rides to an unauthorized person."
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
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
class Procedure1Fragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_procedure1, container, false)

        // PDF content (replace with your actual PDF text)
        val pdfText = "LOADING OF VEHICLE:\n" +
                "1. Before loading the vehicle, the driver must collect all delivery documentation for the delivery about to be Loaded.\n" +
                "2. Checks all information is correct, the Driver then takes both the paperwork and vehicle to the filling gantry.\n" +
                "3. The driver is directed to the correct filling bay, then the driver moves the vehicle into the required/assigned loading gantry.\n" +
                "4. Apply the parking brake.\n" +
                "5. Switch off the engine.\n" +
                "6. Turn off the master switch where appropriate.\n" +
                "7. Connect the bonding wire to the bare metal or bounding lug of the Tank body (First on. Last off).\n" +
                "8. Check product ID tags and fix as per the product being loaded.\n" +
                "9. Close the outlets and internal valves.\n" +
                "10. Open the Manhole covers.\n" +
                "11. Inspect the compartments to ensure that they are empty. If a compartment is not empty, moved out the truck to decant/empty out the chamber.\n" +
                "12. Insert the filling hose right down to the bottom of the appropriate compartment.\n" +
                "13. Inform filling supervisor to start loading.\n" +
                "14. Open the appropriate valves to commence filling, manhole must not be jammed open.\n" +
                "15. Stand upwind of the loading compartment where possible, if not face away from vapors.\n" +
                "16. If any product is spilled during the loading operation, all operations must cease until the spillage has been removed.\n" +
                "17. The vehicle engine must not be started until the spilled product is removed.\n" +
                "18. All spills to be reported to the depot supervisor.\n" +
                "19. After the vehicle loaded, Seal all vehicles outlets where appropriate.\n" +
                "20. Confirm product indicators on each compartment.\n" +
                "21. Check paperwork for the route.\n" +
                "22. Leave the terminal slowly.\n" +
                "23. Drive safely to the delivery."

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
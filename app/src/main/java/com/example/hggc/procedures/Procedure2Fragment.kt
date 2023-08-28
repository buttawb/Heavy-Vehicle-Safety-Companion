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
class Procedure2Fragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_procedure2, container, false)

        // PDF content (replace with your actual PDF text)
        val pdfText = " UNLOADING OF VEHICLE:\n" +
                "1. On arrival at the customer’s premises the driver shall inspect the area where the vehicle shall need to park.\n" +
                "2. Driver shall ensure the following points:\n" +
                "• High tension wires\n" +
                "• Any source of fire ignition near-by\n" +
                "• Any obstruction (e.g. vehicle parked)\n" +
                "• Soft soil at discharging area\n" +
                "• Uneven surface at discharging area\n" +
                "3. After ensure the above points, driver shall proceed directly to the discharge point, park the vehicle, apply the park brake, switch off the engine and turn off the master switch.\n" +
                "4. After parking the vehicle, the driver shall present the delivery document to the customer and request them to take the following actions:\n" +
                "• Check location\n" +
                "• Place Safety Cones to direct traffic\n" +
                "• Check all seals against paperwork\n" +
                "• Check product quantity\n" +
                "5. Customer will Gauge the tank compartments through the dip hole and “not” the manhole using Dip Rod. It is recommended that the customer should have his own dip rod for the measurement.\n" +
                "6. Dip reading at the time of receipt of the product should be mentioned against the dips mentioned already on the invoice.\n" +
                "7. Customer rep receiving the product shall calculate Transit Loss / Gain and shall take signature of the tank truck driver on invoice prior to decant the product.\n" +
                "8. Any difference in dip / product shortage shall be communicated to shipped Terminal / concerned Sales rep for advice. The difference shall be reflected on invoice for compensation / re-imbursement with driver acknowledgement.\n" +
                "9. Customer rep shall then advise the driver/ his rep to connect the other end of the hose with customer tank pipe and start decanting of product into the customer tank.\n" +
                "10. Customer rep shall be present all time at the decanting site to avoid any mishap.\n" +
                "11. Manhole cover of the chamber to be decanted shall be opened only.\n" +
                "12. After completion of the tank truck discharge customer shall verify “all” compartments as being empty.\n" +
                "13. Customer shall then acknowledge the Invoice affixes the rubber stamp and hand over the contractor copy of the invoice to Driver.\n" +
                "14. While the customer is carrying out the checks the driver should be in attendance throughout to satisfy that:\n" +
                "• The customer is satisfied\n" +
                "• There are no hazards in the area\n" +
                "• The correct tanks have been identified\n" +
                "15. The driver should not misbehave the customer in any condition."

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
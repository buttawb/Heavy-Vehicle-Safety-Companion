package com.example.hggc.procedures

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import com.example.hggc.PdfTextToSpeechHelper
import com.example.hggc.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

/**
 * A simple [Fragment] subclass.
 * Use the [Policy1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Procedure2Fragment : Fragment() {
    private var mMediaPlayer: MediaPlayer? = null
    private var isPlaying = false
    // TODO: Rename and change types of parameters
    private lateinit var pdfTextToSpeechHelper: PdfTextToSpeechHelper
    private var isReading = false
    private var tab_select = true
    private lateinit var tabLayout: TabLayout
    private lateinit var urdu_scrollview: ScrollView
    private lateinit var english_scrollview: ScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_procedure2, container, false)

        val urduText = " آ ف لوڈ نگ کا طریقہ\n" +
                "\n" +
                "ڈیلوری انوائس چیک کرلیں  کہ درست جگہ ہے۔ \n" +
                "۱۔ کسٹمر کی جگہ کا اچھی طرح جائزہ لیں کوئی خطرہ موجود ہے تو اس کو دور کریں۔ ا۔ کوئی بجلی کی تاریں، کوئی شعلے    یا ویلڈنگ کا کام تو نہیں کررہا۔ راستے میں کوئی روکاوٹ یا جانے کی سطح غیر ہموا ر تو نہیں ہے۔ \n" +
                "۲۔  گاڑی خالی کرنے کی جگہ لے جائیں\n" +
                "۳۔  ہینڈ بریک لگا کر سوئیچ بند کر دیں اور مین سوئیچ  بھی آف کردیں \n" +
                "۴۔  سیفٹی کون اور ویل چوک لگا دیں   فائیر  پاس رکھیں لیں ۔ اور ارتھ کی تار جوڑ دیں\n" +
                "۵۔  پمپ  یا ڈیپو کا نمائیندہ  کو انوائیس دے دیں  وہ کچھ دیر بعد ڈیپ لے گا\n" +
                "۶۔ڈیپ لینے ساتھ سمپل بھی لیے جائیں گے۔\n" +
                "۷۔ اگر پروڈکٹ میں کمی ہو تو وہ نوٹ کر کے انوئیس میں درج کرے گا۔ \n" +
                "۸۔ ہوز (پائیپ) کسٹمر کے پائپ کے ساتھ جوڑ دیں\n" +
                "۹۔ مین ہول کا ڈھکن اور والوز کھول دیں \n" +
                "۱۰۔ آف لوڈنگ کی نگرانی کریں  کسی بھی غیر مطلقہ شخص کو قریب نہ آنے دیں \n" +
                "۱۱۔ آف لوڈنگ مکمل ہونے کے بعد کسٹنر سے دستخط لیں اور مہر لگوا لیں \n" +
                "۱۲۔ ہوز  نکال دیں، فا ئیر سلینڈر اور سیفٹی  کون گاڑی  واپس گاڑی میں رکھ لیں\n" +
                "۱۳۔  گاڑی احتیاط سے لوکیشن سے نکال لیں۔ \n"
        // PDF content (replace with your actual PDF text)
        val engText = " UNLOADING OF VEHICLE:\n" +
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

        pdfTextToSpeechHelper = PdfTextToSpeechHelper(requireContext())

        // Find the "Read PDF" button

        // Find the "Read PDF" button
        val floatingButton = view.findViewById<FloatingActionButton>(R.id.floating_button)
        floatingButton.setOnClickListener {
            if (isReading) {
                // Stop reading and change button text
                isReading = false
                pdfTextToSpeechHelper.stopSpeaking()
                //                btnRead.text = "Start Reading"
                floatingButton.setImageResource(R.drawable.baseline_voice_over_off_24)

            } else if (isPlaying) {
                isPlaying = false
                mMediaPlayer!!.release()
                mMediaPlayer = null
                floatingButton.setImageResource(R.drawable.baseline_voice_over_off_24)


            } else {
                // Start reading and change button text
                if (tab_select) {
                    // Read the first text
                    isReading = true
                    pdfTextToSpeechHelper.startSpeaking(
                        engText,
                        object : PdfTextToSpeechHelper.OnCompletionListener {
                            override fun onCompletion() {
                                // This is called when the speech is completed
                                floatingButton.setImageResource(R.drawable.baseline_voice_over_off_24)
                                onPause()
                                activity?.runOnUiThread {
                                    // You can add any actions to perform when the first text is done reading
                                }
                            }
                        })
                    floatingButton.setImageResource(R.drawable.baseline_record_voice_over_24)


                } else {
                    // Read the second text
                    mMediaPlayer = MediaPlayer.create(requireContext(), R.raw.pr2)
                    mMediaPlayer!!.isLooping = false

// Set up an OnCompletionListener

// Set up an OnCompletionListener
                    mMediaPlayer!!.setOnCompletionListener { mediaPlayer ->
                        // The audio playback has completed, so stop the MediaPlayer
                        floatingButton.setImageResource(R.drawable.baseline_voice_over_off_24)
                        onStop()
                        isPlaying = false // Update the flag
                    }

// Start the audio playback

// Start the audio playback
                    mMediaPlayer!!.start()
                    isPlaying = true


                    floatingButton.setImageResource(R.drawable.baseline_record_voice_over_24)
                }


            }

        }

        // Find the TabLayout
        english_scrollview = view.findViewById(R.id.english_scrollview)
        urdu_scrollview = view.findViewById(R.id.urdu_scrollview)

        // Find the TabLayout
        tabLayout = view.findViewById(R.id.tabLayout)

// Create tabs with titles
        val englishTab = tabLayout.newTab().setText("English")
        val urduTab = tabLayout.newTab().setText("Urdu")

// Add the tabs to the TabLayout
        tabLayout.addTab(englishTab)
        tabLayout.addTab(urduTab)

// Set up TabLayout listener to handle tab changes
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    when (it.position) {
                        0 -> { // English tab is selected
                            english_scrollview.visibility = View.VISIBLE
                            urdu_scrollview.visibility = View.GONE
                            tab_select = true
                        }

                        1 -> { // Urdu tab is selected
                            english_scrollview.visibility = View.GONE
                            urdu_scrollview.visibility = View.VISIBLE
                            tab_select = false
                        }
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Not needed in this case
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Not needed in this case
            }
        })

        return view


    }

    // 2. Pause playback

    override fun onPause() {
        super.onPause()
        // Stop TTS when the app goes into the background or is paused
        if (isReading) {
            pdfTextToSpeechHelper.stopSpeaking()
            isReading = false

        }

        if (isPlaying) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
            isPlaying = false
        }
    }

    override fun onDestroy() {
        pdfTextToSpeechHelper.shutdown()
        super.onDestroy()
    }

    override fun onStop() {
        super.onStop()
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }
}

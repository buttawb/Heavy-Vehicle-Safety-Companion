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
class Procedure1Fragment : Fragment() {
    private var mMediaPlayer: MediaPlayer? = null
    private var isPlaying = false
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
        val view = inflater.inflate(R.layout.fragment_procedure1, container, false)

        val urduText = "لوڈ نگ کا طریقہ\n" +
                "۱۔ لوڈ نگ سے پہلے گاڑی کے کاغذات چیک کرلیں \n" +
                "۲۔  گاڑی  لوڈنگ پوائینٹ پر لے جائیں\n" +
                "۳۔ گاڑی کا انجن بند کردیں اور مین سوئیچ بھی آف کر دیں\n" +
                "۴۔ گاڑی کی پارک بریک لگا دیں\n" +
                "۵۔ ویل چوک لگا دیں\n" +
                "۶۔ ارتھ کی تار لگا دیں\n" +
                "۷۔ والوز بند کر دیں\n" +
                "۸۔ سیفٹی ہارنس پہن کر ہک کر لیں \n" +
                "۹۔ ٹنک کے مین ہول ڈھکن کھول دیں اور دیکھیں اندر ٹنک صاف ہے  کوئی چیز یا باقی ماندہ پرڈکٹ موجود تو نہیں ہے؟اگر کوئی گندگی ہے توباہر جاکر صاف کروالیں۔ \n" +
                "۱۰۔ ہوز لگا کر سوپروائیز کو بتا دیں\n" +
                "۱۱۔ لوڈنگ شروع کروائیں\n" +
                "۱۲۔ پروڈکٹ کی ڈیپ کریں گے اور ٹمپریچر   لکھ لیں گے۔ \n" +
                "۱۳۔ لوڈ نگ مکمل ہونے  کے بعد  سیل لگوالیں  اور ساری سیل چیک کرلیں کہ درست ہیں اگر کوئی رہ گئی ہو تو وہ بھی لگوا لیں۔\n" +
                "۱۴۔ پروڈکٹ  سلیکٹر لگا دیں\n" +
                "۱۵۔ انوائیس لے لیں اور چیک کر لیں\n" +
                "۱۵۔ احتیاط سے گاڑی چلائیں\n"
        // PDF content (replace with your actual PDF text)
        val engText = "LOADING OF VEHICLE:\n" +
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
                    mMediaPlayer = MediaPlayer.create(requireContext(), R.raw.pr1)
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

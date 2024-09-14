package com.example.hggc.emergencyprocedures

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
class EmergProc4Fragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_emerg_proc4, container, false)
        val urduText = " گاڑیوں کا تصادم/رولیور\n" +
                "• اگر کوئی چوٹ ہے تو پہلے اس کا علاج کریں۔\n" +
                "مقامی فائر بریگیڈ اور ایمبولینس کو مطلع کریں۔\n" +
                "ERP سپروائزر اور کلائنٹ کے ایمرجنسی نمبر کو فوری طور پر مطلع کریں۔\n" +
                "• اگر کسی بھی طرح کے پھیلنے کا مشاہدہ کیا جاتا ہے، تو دستیاب وسائل کی مدد سے پھیلنے کو کنٹرول کرنے کی کوشش کریں، جیسے سپل کٹ، صابن۔\n" +
                "• انجن ماسٹر سوئچ کو آپریٹ کرکے برقی نظام کو بند کر دیں اور انجن کو بند کر دیں۔\n" +
                "اس بات کو یقینی بنائیں کہ قریب میں اگنیشن کا کوئی ذریعہ نہیں ہے۔\n" +
                "•گاڑی کو بغیر توجہ کے مت چھوڑیں۔\n" +
                "•علاقے کو گھیرے میں لے لیں/بریگیڈ کریں۔\n" +
                "• گاڑی سے 50 میٹر تک حفاظتی شنک کو مناسب طریقے سے رکھیں۔\n" +
                "لوگوں کو واقعہ کی جگہ سے دور رکھنے کی کوشش کریں۔\n"
        // PDF content (replace with your actual PDF text)
        val engText = "VEHICLE COLLISION/ROLLOVER\n" +
                "•If there is any injury, treat it first.\n" +
                "•Inform local area fire brigade and ambulance.\n" +
                "•Immediately Inform ERP supervisor and client emergency number.\n" +
                "•If any spill is observed, try to control the spill with the help of availableresources, e.g. Spill Kit, Soap.\n" +
                "•Turn off electrical system by operating engine master switch, and shutdown the engine.\n" +
                "•Ensure there is no source of ignition nearby.\n" +
                "•Do not leave the vehicle unattended.\n" +
                "•Cordon-off/brigade the area.\n" +
                "•Properly place safety cone up to 50m from vehicle.\n" +
                "•Try to keep people away from incident area."

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
                    mMediaPlayer = MediaPlayer.create(requireContext(), R.raw.ep4)
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

package com.example.hggc.policies

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
class Policy4Fragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_policy4, container, false)

        val urduText = "\n" +
                "۱۔ صحت ، حفاظت ،تحفظ اور  ماحول  کی پالیسی \n" +
                "\n" +
                "ہم یقین رکھتے ہیں کہ صحت، تحفظ اور ماحول سے زیادہ اہم کوئی چیزنہیں ہے\n" +
                "کمپنی کے تمام ملازمیں پر لازم ہے کہ وہ سیفٹی اور ماحول کا خاص خیال رکھیں اور ایسا کوئی کام نہ کریں جس سے کسی قسم کی صحت ، تحفظ اور ماحول پرمنفی اثرات پڑیں۔\n" +
                "صحت مند افراد سےہی صحت مند معاشرہ تشکیل پاتا ہے اس لئے کمپنی اپنے تمام ملازمیں کی صحت پر خصوصی توجہ دیتی ہے ۔ کمپنی اپنی تمام گاڑیوں  کو مکمل  فٹ اور تمام سیفٹی آلات سے لیس  رکھتی ہے \n" +
                "کمپنی ماحول کو صحت مند رکھنے اور اس کو کسی قسم  کی آلودگی نا پہنچانے کو بھی اپنا اولیں مقصد سمجھتی ہے۔\n" +
                "کمپنی اپنی گاڑیوں کی منٹینس پر خاص توجہ دیتی ہے اور ماحول دوست اقدامات کی حوصلہ افزائی کرتی ہے۔\n" +
                "اس بات کو مد نظر رکھتے ہوئے  اس ذمن میں کمپنی کی  تمام پالیسیوں پر سختی سےعمل درآمد کروایا جاتا ہے\n" +
                "نگرانی کا ایک ایسا انتظامی نظام نافذ کرنا جو  ہماری  HSE اور سماجی کارکردگی کو بہتر کرے \n" +
                "ماحول کو آلودہ ہونے سے بچانا ہے۔کام سے متعلقہ تمام اقسام کے حادثات کو بچانا ہے\n "
        // PDF content (replace with your actual PDF text)
        val engText = "HSE Policy\n" +
                "We believe that nothing is more important than Health, Safety and Environment. Every person of the company is responsible to think about HSE before commencing any job.\n" +
                "1. No job will be performed that exsert negative impact on HSE.\n" +
                "2. A healthy people build a healthy society therefore all employee must maintain and care for their health.\n" +
                "3. All employees must keep the environment free form pollution.\n" +
                "4. All employee must cooperate to maintain the vehicles in such way that it must not pollutes the environment.\n" +
                "5. All HSE policies must be implemented that improve the HSE of the company and play a dominant role in building a safe society."
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
                    mMediaPlayer = MediaPlayer.create(requireContext(), R.raw.p4)
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

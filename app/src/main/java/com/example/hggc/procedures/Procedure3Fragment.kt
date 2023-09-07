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
class Procedure3Fragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_procedure3, container, false)
        val urduText =
            "پروڈکٹ ہینڈلنگ اور اس سے وابستہ خطرات ١۔ پروڈکٹ کو صحیح لیبل والے کنٹینرز میں اسٹور کریں\\n\\n\n" +
                    "    ٢۔ پروڈکٹ لیبلز پر کسی بھی ہدایات پر عمل کریں\\n\\n\n" +
                    "    ٣۔ صحیح حفاظتی لباس پہنیں\\n\\n\n" +
                    "    ٤۔ بیریئر کریم اور/یا دستانے استعمال کریں\\n\\n\n" +
                    "    ٥۔ جلد کے رابطے سے گریز کریں\\n\\n\n" +
                    "    ٦۔ سانس لینے والے بخارات سے پرہیز کریں۔\\n\\n\n" +
                    "    ٧۔ کبھی نہ نگلیں / منہ کا گھونٹ\\n\\n\n" +
                    "    ٨۔ کوئی کھانا/سگریٹ نوشی نہیں\\n\\n\n" +
                    "    ٩۔ اگنیشن کے تمام ذرائع کو دور رکھیں\\n\\n\n" +
                    "    ١٠۔ اگر پروڈکٹ آپ کی جلد سے رابطہ کرتا ہے، تو صابن سے ہاتھ دھو کر اسے جلد سے ہٹا دیں\\n\\n\n" +
                    "    ١١۔ جلد سے تیل/چکنائی ہٹانے کے لیے پروڈکٹ کا استعمال نہ کریں\\n\\n\n" +
                    "    ١٢۔ پروڈکٹ کو سنبھالنے کے بعد، کھانے، پینے، بیت الخلا کی ضروریات سے پہلے ہاتھ اور چہرہ دھوئیں\\n\\n\n" +
                    "    ١٣۔ کٹ اور خروںچ کے لیے ابتدائی طبی امداد حاصل کریں\\n\\n\n" +
                    "    ١٤۔ جلد کی غیر معمولی حالتوں کے لیے طبی مشورہ حاصل کریں\\n\\n\n" +
                    "    ١٥۔ پروڈکٹ ہینڈلنگ کے لیے درج ذیل PPE استعمال کریں:\\n\\n\n" +
                    "    • دستانے (گونٹلیٹس، تھرمل طور پر موصل، مائعات کے لیے غیر محفوظ)\\n\\n\n" +
                    "    • حفاظتی جوتے\\n\\n\n" +
                    "    • چشمیں\\n\\n\n" +
                    "    • سائیڈ شیلڈز\\n\\n\n" +
                    "    • پورے چہرے کی شیلڈز\\n\\n\n" +
                    "    • ٹھوڑی گارڈ کے ساتھ حفاظتی ہیلمٹ\\n\\n\n" +
                    "    • کپڑے (سوتی / قدرتی، مخالف جامد)\\n\\n\n" +
                    "    ١٦۔ مزید تفصیلات کے لیے، ڈرائیور کی ہینڈ بک پڑھیں، جو ہر گاڑی میں دستیاب ہے۔\""
        // PDF content (replace with your actual PDF text)
        val engText = "PRODUCT HANDLING AND ASSOCIATED RISKS:\n" +
                "1. Store product in correctly labelled containers\n" +
                "2. Follow any instructions on product labels\n" +
                "3. Wear correct protective clothing\n" +
                "4. Use barrier cream and/or gloves\n" +
                "5. Avoid skin contact\n" +
                "6. Avoid breathing vapors.\n" +
                "7. Never swallow / mouth siphoning\n" +
                "8. No eating/smoking\n" +
                "9. Keep all ignition sources away\n" +
                "10. If the product makes contact with your skin, remove it from the skin promptly by washing hands with soap\n" +
                "11. Do not use product to remove oil/grease from the skin\n" +
                "12. After handling the product, Wash hands and face before eating, drinking, toilet needs\n" +
                "13. Get first aid for cuts and scratches\n" +
                "14. Get medical advice for abnormal skin conditions\n" +
                "15. Use the following PPE for product handling.\n" +
                "• Gloves (gauntlets, thermally insulated, impervious to liquids)\n" +
                "• safety boots\n" +
                "• goggles\n" +
                "• side shields\n" +
                "• full-face shields\n" +
                "• safety helmets with chin guard\n" +
                "• Clothes (cotton / natural, anti-static)\n" +
                "16. For more details, read driver’s hand book, which is available in every vehicle."
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
                    mMediaPlayer = MediaPlayer.create(requireContext(), R.raw.pr3)
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

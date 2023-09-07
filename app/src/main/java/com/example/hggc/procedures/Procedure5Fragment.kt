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
class Procedure5Fragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_procedure5, container, false)
        val urduText = "گاڑیوں کی پارکنگ کے قوانین:\\n\\n\n" +
                "1. ڈرائیور کو گاڑی پارک کرنے سے پہلے پارکنگ ایریا کا جائزہ لینا چاہیے۔ ذیل میں چند چیکس ہیں جن کو انجام دینے کی ضرورت ہے:\\n\n" +
                "• کیا ریسٹ ایریا تک مناسب رسائی ہے، مناسب اپروچ روڈ کے ساتھ؟\\n\n" +
                "• کیا سائٹ کے پاس گاڑی کو محفوظ طریقے سے پارک کرنے کے لیے کافی پارکنگ کی جگہیں ہیں؟\\n\n" +
                "• کیا سائٹ پر ڈرائیوروں کے لیے آرام کرنے کی کافی سہولت موجود ہے؟\\n\n" +
                "• کیا زمین گاڑی کا بوجھ برداشت کرنے کے لیے کافی ٹھوس ہے؟\\n\n" +
                "• کیا پارکنگ میں مناسب روشنی ہے؟\\n\n" +
                "• کیا آس پاس کوئی ایندھن اسٹیشن ہے؟\\n\n" +
                "• کیا سائٹ پر دیکھ بھال کی کوئی سہولت دستیاب ہے؟\\n\n" +
                "• کیا قریبی علاقے میں شعلوں یا ویلڈنگ کا کوئی خطرہ ہے؟\\n\n" +
                "• کیا اس جگہ پر مناسب سیکیورٹی دستیاب ہے؟\\n\\n\n" +
                "2. اگر مذکورہ بالا تمام خطرات کا جائزہ لیا جائے اور کوئی مسئلہ نہیں پایا جاتا ہے، تو ڈرائیور اپنی گاڑی سائٹ پر کھڑی کر سکتا ہے۔\\n\\n\n" +
                "3. پارکنگ کے بعد:\\n\n" +
                "• ہمیشہ اپنے دروازے بند رکھیں\\n\n" +
                "• اپنے ونڈوز کو رول اپ اور لاک کریں\\n\n" +
                "• قیمتی اشیاء کی بصیرت کو نہ چھوڑیں - (فون، پیجرز، پرس، بٹوے، وغیرہ، چوری کی دعوت دیتے ہیں)\\n\n" +
                "• پارکنگ کی سہولت پر پہنچنے سے پہلے قیمتی سامان اور پیکجوں کو ٹرنک میں یا نظروں سے اوجھل رکھیں۔\\n\n" +
                "• گاڑی کو بغیر توجہ کے مت چھوڑیں۔\\n\n" +
                "• اگر آپ کے پاس اختیار ہے، تو اچھی طرح سے روشن پارکنگ کی جگہ کا انتخاب کریں۔\\n\n" +
                "• اپنی گاڑی میں یا اس پر فالتو چابی نہ چھپائیں - اسے مل سکتا ہے۔\\n\n" +
                "• آگاہ رہیں اور HGGC ایمرجنسی # 0346-6381599 پر کال کرکے یا ہنگامی صورتحال کے لیے 15 ڈائل کرکے فوری طور پر کسی بھی مشکوک سرگرمی کی اطلاع دیں۔\n" +
                "• کبھی بھی کسی غیر مجاز شخص کو سواری کی پیشکش نہ کریں۔\""
        // PDF content (replace with your actual PDF text)
        val engText = "VEHICLE PARKING RULES:\n" +
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
                    mMediaPlayer = MediaPlayer.create(requireContext(), R.raw.pr5)
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

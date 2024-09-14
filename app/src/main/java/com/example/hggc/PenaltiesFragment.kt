package com.example.hggc;

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout


/**
 * A simple [Fragment] subclass.
 * Use the [Policy1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PenaltiesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var mMediaPlayer: MediaPlayer? = null
    private lateinit var pdfTextToSpeechHelper: PdfTextToSpeechHelper
    private var isReading = false
    private var isPlaying = false
    private var tab_select = true
    private lateinit var tabLayout: TabLayout
    private lateinit var urdu_scrollview: ScrollView
    private lateinit var english_scrollview: ScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_penalties, container, false)

        // PDF content (replace with your actual PDF text)
        val urduText =
            "خلاف ورزیوں کی نوعیت\n\n" + "۱. مقررہ رفتار سے زیادہ رفتار پر گاڑی چلانا یا سخت بریک لگانا یا غلط طریقہ سے اوور ٹیک کرنا، اور اچانک گاڑی گھمانا۔\n\n" + "۲. ممنوعہ روٹ یا مقام پر گاڑی چلانا یا دفتر کو اطلاع دیے بغیر متبادل راستہ اختیار کرنا۔\n\n" + "۳. ممنوعہ یا غیر منظور شدہ آرام گاہ پر 10 منٹ سے زیادہ دیر تک رکنا یا گاڑی کو سٹارٹ حالت میں کھڑا کرنا۔ بلیک اسپاٹ پر گاڑی روکنا۔\n\n" + "۴. مقرر کردہ ڈرائیونگ اور آرام کے اوقات کی خلاف ورزی یا تھکاوٹ کے متعلق نہ بتانا یا پری ٹرپ بریفنگ نہیں لینا۔\n\n" + "۵. ڈرائیور کا سفر کے دوران دفتر سے رابطہ نہ کرنا, ٹرپ لاگ بھرنے سے انکار, غیر مجاز ی طریقےسے گاڑی کے لیے ڈیزل خریدنا۔\n\n" + "۶. ڈرائیور کے پاس ضروری دستاویزات کا موجود نہ ہونا یا ضروری دستاویزات پر لکھائی کرنا یا ہینڈ بک، ٹرم کارڈ کا موجود نہ ہونا۔\n\n" + "۷. جرنی مینجمٹ(JMP ) یا کمپنی کے قواعد و ضوابط کی خلاف ورزی کرنا۔\n\n" + "۸. گاڑی کا روزانہ معائنہ نہ کرنا، گاڑی کو اچھی حالت میں رکھنے میں کوتاہی کرنا، ڈرائیور کا گاڑی کے اندر موجود نُقص کو رپورٹ نہ کرنا یا گاڑی کا نُقص بغیر اجازت خود ٹھیک کرنے کی کوشش کرنا۔\n\n" + "۹. ہوز پائپ لیک ہونے کی صورت میں رپورٹ نہ کرنا یا دیگر کیسی بھی قسم کی پروڈیکٹ لیکیج رپورٹ نہ کرنا۔\n\n" + "۱۰. فائیر سلنڈر، اور دیگر ضروری آلات کو چیک نہ کرنا یا 360 ڈگری کا چکر نہ لگانا، کیبن کے اندر لوز آٹم رکھنا۔\n\n" + "۱۱. ڈرائیور کا دفاعی ڈرائیونگ کے اصولوں کی خلاف ورزی کرنا، اشاروں کا استعمال نہ کرنا، ہارن کا غیر ضروری استعمال کرنا۔\n\n" + "۱۲. ڈرائیور کا ٹریفک سگنل پر عمل نہ کرنا یا غلط سائیڈ پر گاڑی چلانا یا پیچھے دیکھے بغیر گاڑی دروازہ کھولنا۔\n\n" + "۱۳. دورانِ ڈرائیونگ دیھان بٹانے والی اشیائہ کا استعمال کرنا (مثلن موبائل، ھینڈ فری، ٹیپ ریکاڈر اور دیگر)۔\n\n" + "۱۴. ڈرائیور کا حفاظتی سامان کا استعمال نہ کرنا یا ریورس کرتے وقت دوسرے ڈرائیور کی مدد نہ لینا۔\n\n" + "۱۵. سیفٹی کونز یا ارتھ کیبل کا استعمال نہ کرنا یا سائیٹ پر ارتھ پوائنٹ کو چیک نہ کرنا یا کسٹمر کے ساتھ بد تمیزی سے پیش آنا۔\n\n" + "۱۶. خالی کرنے والی چیک لسٹ کا مکمل نہ بھرنا یا انٹر لاک اور ویل چوک کا استعمال نہ کرنا۔\n\n" + "۱۷. ڈرائیور کا سٹاپ ورک پالیسی عمل پیر ا نہ ہونا یا پلان کی ترتیب کے بر خلاف گاڑی کا بھرنا اور خالی کرنا۔\n\n" + "۱۸. ظاہری حالت خراب ہونایا صفائی ستھرائی نہ ہونا یا گاڑی کو صاف ستھرا نہ رکھنا یا اپنی بیماری کو چھپانا۔\n\n" + "۱۹. ڈرائیور کا دوران سفر ٹینک کے ڈھکنے کھلے رکھنا، کسی حادثہ کی اطلاع نہ دینا یا امکانی حادثہ کی رپورٹ نہ دینا۔\n\n" + "۲۰. ڈرائیور کا دوسرے ڈرائیور حضرات سے بدتمیزی یا تنگ مزاجی یا دوسروں سے لڑئی جھگڑا کرنا۔\n\n" + "۲۱. ڈرائیور کا فرسٹ ایڈ اور اسپل کٹ کا صحیح نہ رکھنا۔\n\n" + "۲۲. ڈرائیور کا ٹول بکس میٹنگ، اور دیگر ٹرینگ سیشن میں نہ آنا۔"


        val engText =
            " Nature of violations: Driving at a speed higher than the prescribed speed or applying hard brakes or overtaking the wrong way, and suddenly turning the car.\n" + "Driving on a prohibited route or location or taking an alternate route without informing the office.\n" + "Stopping for more than 10 minutes at a prohibited or unapproved resting place or parking the vehicle in a starting position. Stopping the car at the black spot.\n" + "Don't tell or take pre-trip briefings about violations or fatigue of scheduled driving and rest hours.\n" + "Driver not contacting the office while traveling, refusing to fill the trip log, buying diesel for the vehicle in an unauthorized manner.\n" + "The driver does not have the necessary documents or writing on the necessary documents or not having a handbook, term card.\n" + "Violating The JMP Or Company Rules and Regulations.\n" + "Not inspecting the vehicle daily, neglecting to keep the vehicle in good condition, the driver not reporting the defect inside the vehicle or trying to fix the vehicle's fault himself without permission.\n" + "Not reporting a hose pipe leak or any other kind of product leakage.\n" + "Not checking fire cylinders, and other necessary equipment or circling 360 degrees, placing loose items inside the cabin.\n" + "Violation of driver's defense driving rules, not using signals, unnecessary use of horns.\n" + "Driver not following traffic signals or driving on the wrong side or opening the car door without looking back.\n" + "Using hand-breaking items while driving (triangle mobile, hand-free, tape recorder, and others).\n" + "The driver does not use protective gear or take the help of another driver when reversing.\n" + "Not using safety cones or earth cables or not checking earth points on the site or misbehaving with the customer.\n" + "Not filling the emptying checklist completely or not using interlock and well square.\n" + "The driver's stop work policy process is not compliant or the vehicle is filled and emptied against the plan setting.\n" + "Poor appearance or lack of cleanliness or not keeping the car clean or hiding your illness.\n" + "The driver should keep the covers of the tank open during the journey, do not report any accident or report a possible accident.\n" + "The driver's misbehavior or narrow-mindedness with other drivers or fighting with others.\n" + "Don't keep the driver's first aid and spill kit right.\n" + "Driver not attending toolbox meetings, and other training sessions."
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
                    mMediaPlayer = MediaPlayer.create(requireContext(), R.raw.penalties)
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

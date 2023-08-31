package com.example.hggc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout


class DriverFragment : Fragment() {

    private lateinit var pdfTextToSpeechHelper: PdfTextToSpeechHelper
    private var isReading = false
    private var tab_select = true
    private lateinit var tabLayout: TabLayout
    private lateinit var urdu_scrollview: ScrollView
    private lateinit var english_scrollview: ScrollView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_driver, container, false)


        pdfTextToSpeechHelper = PdfTextToSpeechHelper(requireContext())
        // PDF content (replace with your actual PDF text)
        val urduText = ": ڈرائیور کے کام \n" +
                "ملازمت کی ذمہ داریاں\n" +
                "01.کمپنی کے پٹرولیم مصنوعات کی با حفاظت ترسیل۔\n" +
                "02. پٹرولیم مصنوعات کی لوڈنگ، آف لوڈنگ ،وقت پر ترسیلی اور مال کے معیار اور مقدار میں کمی نہیں ہونی چاہیے ۔\n" +
                "03. سفری منصوبہ بندی،گاڑی کی صفائی اور حفاطت\n" +
                "04. ڈیلیوری سے متعلق کاغذات/انوائس کے بارے میں معلومات اور انکا صحیح استعمال(دفتر جمع کرانا)۔\n" +
                "اپنے آپ کو تھکاوٹ سے دور  رکھیں۔  .05  \n" +
                "06. ،گاڑی کو فٹ رکھیں اورکسی قسم کی معلومات کے لیے دفتر سے رابطے میں رہیں۔\n" +
                "07. اپنے ضروری کاغذات(شناختی کارڈ، ڈرائیونگ لائسنس اور موٹروے کارڈ) اپنے ہمراہ رکھیں۔\n" +
                "08. کمپنی کی فراہم کردہ ٹریننگ حاصل کریں، ٹول بکس میٹنگ میں شرکت کو یقینی بنائیں اور ان پر عمل کریں۔\n" +
                "09. ٹرپ لاگ کی صحیح طریقے سے فلنگ اور سفر کے اختتام پر دفتر جمع کروانا۔\n" +
                "ٹریفک کے قوانین پرعمل درامد۔. 10. \n" +
                "11. راستے کے خطرات اور مسائل(این ایم پی آئی)کی اطلاع دینا لازمی ہے۔\n" +
                "12.گاڑی بھرنے  سے قبل  سیف ٹو لوڈ کرانا لازمی ہے اور اس دوران گاڑی  خرابی کو نوٹ کرانا اور ان کو درست کروانا\n" +
                "13. بیس پر ہونے والی سیفٹی ڈرل کی سرگرمیوں میں شرکت لازمی ہے۔\n" +
                "14. کسی بھی غیر محفوظ،غیر معیاری اور سیفٹی کے اصولوں کی خلاف ورزی پر مبنی کاموں کے لیے کمپنی کے فراہم کردہ سٹاپ کارڈ کا استعمال کریں اور اس کی اطلاع فوراًاپنے دفتر دیں تا کہ اس مسئلے کو حل کیا جا سکے۔\n" +
                ". کسٹمرز کے ساتھ پیار اور خوش اخلاقی سے پیش آئیں۔\n"          // (Rest of your Urdu text)

        val engText = " Driver Job Description \n" +
                "\n" +
                "\n" +
                "1.\tSafe transportation of company products.\n" +
                "2.\tProduct loading and offloading within time delivery.\n" +
                "3.\tTransportation without any abnormal shortage and change in quality.\n" +
                "4.\t Fill the drivers documents 1. Driver daily vehicle inspection sheet 2. Trip log 3. Near Miss potential incident 4. Stop card as per need and deposit these documents in the office \n" +
                "5.\tKeep the vehicle and driver documents safely all the time. \n" +
                "6.\tMaintain the vehicle and keep it clean.\n" +
                "7.\tFollow the traffic rules and regulations.\n" +
                "8.\tParticipate in TBM, drills and trainings offered from HGGC.\n" +
                "9.\t Conduct the STL with the site supervisor and repair the vehicle as per require. \n" +
                "10.\t Keep a good attitude with all co workers and customers. \n"
        // Initialize your PDFTextToSpeechHelper


        // Find the "Read PDF" button
        val floatingButton = view.findViewById<FloatingActionButton>(R.id.floating_button)
        floatingButton.setOnClickListener {
            if (isReading) {
                // Stop reading and change button text
                pdfTextToSpeechHelper.stopSpeaking()
                //                btnRead.text = "Start Reading"
                floatingButton.setImageResource(R.drawable.baseline_voice_over_off_24)

                isReading = false
            } else {
                // Start reading and change button text
                if (tab_select) {
                    // Read the first text
                    pdfTextToSpeechHelper.startSpeaking(
                        engText,
                        object : PdfTextToSpeechHelper.OnCompletionListener {
                            override fun onCompletion() {
                                // This is called when the speech is completed
                                activity?.runOnUiThread {
                                    // You can add any actions to perform when the first text is done reading
                                }
                            }
                        }
                    )
                } else {
                    // Read the second text
                    pdfTextToSpeechHelper.startSpeaking(
                        urduText,
                        object : PdfTextToSpeechHelper.OnCompletionListener {
                            override fun onCompletion() {
                                // This is called when the speech is completed
                                activity?.runOnUiThread {
                                    // You can add any actions to perform when the second text is done reading
                                }
                            }
                        }
                    )
                }

                floatingButton.setImageResource(R.drawable.baseline_record_voice_over_24)
                //                btnRead.text = "Stop Reading"
                isReading = true
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


    // Rest of your code
    // ...

// Function to toggle between English and Urdu content


    override fun onPause() {
        super.onPause()
        // Stop TTS when the app goes into the background or is paused
        if (isReading) {
            pdfTextToSpeechHelper.stopSpeaking()
            isReading = false
        }
    }

    override fun onDestroy() {
        pdfTextToSpeechHelper.shutdown()
        super.onDestroy()
    }

}

package com.example.hggc.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.hggc.PdfTextToSpeechHelper
import com.example.hggc.R
import com.example.hggc.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var pdfTextToSpeechHelper: PdfTextToSpeechHelper
    private var isReading = false
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val pdfText = "Welcome to Haji Gul Group of Companies"

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Initialize your PDFTextToSpeechHelper
        pdfTextToSpeechHelper = PdfTextToSpeechHelper(requireContext())


        pdfTextToSpeechHelper.startSpeaking(
            pdfText,
            object : PdfTextToSpeechHelper.OnCompletionListener {
                override fun onCompletion() {
                    // This is called when the speech is completed
                    activity?.runOnUiThread {

                    }
                }
            })

        // Get a reference to the ImageView with ID buttongo
        val buttongoImageView = _binding?.root?.findViewById<Button>(R.id.buttongo)


        pdfTextToSpeechHelper = PdfTextToSpeechHelper(requireContext())

        // Find the "Read PDF" button

        buttongoImageView?.setOnClickListener {
            if (isReading) {
                // Stop reading and change button text
                pdfTextToSpeechHelper.stopSpeaking()
                isReading = false
            } else {
                // Start reading and change button text
                pdfTextToSpeechHelper.startSpeaking(
                    pdfText,
                    object : PdfTextToSpeechHelper.OnCompletionListener {
                        override fun onCompletion() {
                            // This is called when the speech is completed
                            activity?.runOnUiThread {
                                isReading = false
                            }
                        }
                    })
                isReading = true
            }

            findNavController().navigate(R.id.action_nav_home_to_nav_menu)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
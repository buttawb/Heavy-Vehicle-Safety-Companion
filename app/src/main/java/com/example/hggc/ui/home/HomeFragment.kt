// HomeFragment.kt
package com.example.hggc.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.hggc.PdfTextToSpeechHelper
import com.example.hggc.R
import com.example.hggc.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var pdfTextToSpeechHelper: PdfTextToSpeechHelper
    private var isReading = false
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val pdfText = "Welcome to Haji Gul Group of Companies"

        // Initialize PdfTextToSpeechHelper
        pdfTextToSpeechHelper = PdfTextToSpeechHelper(requireContext())
        pdfTextToSpeechHelper.startSpeaking(pdfText, object : PdfTextToSpeechHelper.OnCompletionListener {
            override fun onCompletion() {
                // Actions after completion if needed
            }
        })

        // Handle button click to start/stop reading and navigate
        val buttongoButton = binding.buttongo
        buttongoButton.setOnClickListener {
            if (isReading) {
                pdfTextToSpeechHelper.stopSpeaking()
                isReading = false
            } else {
                pdfTextToSpeechHelper.startSpeaking(pdfText, object : PdfTextToSpeechHelper.OnCompletionListener {
                    override fun onCompletion() {
                        isReading = false
                    }
                })
                isReading = true
            }
            // Navigate to menu fragment
            findNavController().navigate(R.id.action_nav_home_to_nav_menu)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

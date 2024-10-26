package com.example.hggc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.io.InputStream

class TrainingFragment : Fragment() {

    private lateinit var pdfInputStream: InputStream // Input stream for the PDF

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_training, container, false)

        // Find the RelativeLayout with id train1
        val train1Layout = view.findViewById<RelativeLayout>(R.id.train1)
        val train2Layout = view.findViewById<RelativeLayout>(R.id.train2)
        val train3Layout = view.findViewById<RelativeLayout>(R.id.train3)
        val train4Layout = view.findViewById<RelativeLayout>(R.id.train4)
        val train5Layout = view.findViewById<RelativeLayout>(R.id.train5)
        val train6Layout = view.findViewById<RelativeLayout>(R.id.train6)
        val train7Layout = view.findViewById<RelativeLayout>(R.id.train7)
        val train8Layout = view.findViewById<RelativeLayout>(R.id.train8)
        val train9Layout = view.findViewById<RelativeLayout>(R.id.train9)
        val train10Layout = view.findViewById<RelativeLayout>(R.id.train10)
        val train11Layout = view.findViewById<RelativeLayout>(R.id.train11)

        setTrainingClickListener(train1Layout, "fire.pdf")
        setTrainingClickListener(train2Layout, "journey.pdf")
        setTrainingClickListener(train3Layout, "auth.pdf")
        setTrainingClickListener(train4Layout, "emerg.pdf")
        setTrainingClickListener(train5Layout, "loading.pdf")
        setTrainingClickListener(train6Layout, "spill.pdf")
        setTrainingClickListener(train7Layout, "height.pdf")
        setTrainingClickListener(train8Layout, "er2023.pdf")
        setTrainingClickListener(train9Layout, "tp2023.pdf")
        setTrainingClickListener(train10Layout, "er2024.pdf")
        setTrainingClickListener(train11Layout, "tp2024.pdf")

        return view
    }

    private fun setTrainingClickListener(layout: View, pdfFileName: String) {
        AnimationUtils.setCardClickAnimation(layout, R.id.action_trainingFragment_to_readerFragment, Bundle().apply {
            putString("pdfFileName", pdfFileName)
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = TrainingFragment()
    }
}

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

        train1Layout.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "fire.pdf")

            findNavController().navigate(R.id.action_trainingFragment_to_readerFragment, bundle)

        }
        // Set an OnClickListener for the train1Layout
        train2Layout.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "jouney.pdf")

            findNavController().navigate(R.id.action_trainingFragment_to_readerFragment, bundle)

        }

        train3Layout.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "auth.pdf")

            findNavController().navigate(R.id.action_trainingFragment_to_readerFragment, bundle)

        }

        train4Layout.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "emerg.pdf")

            findNavController().navigate(R.id.action_trainingFragment_to_readerFragment, bundle)

        }

        train5Layout.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "loading.pdf")

            findNavController().navigate(R.id.action_trainingFragment_to_readerFragment, bundle)

        }

        train6Layout.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "spill.pdf")

            findNavController().navigate(R.id.action_trainingFragment_to_readerFragment, bundle)

        }

        train7Layout.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "height.pdf")

            findNavController().navigate(R.id.action_trainingFragment_to_readerFragment, bundle)

        }

        train8Layout.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "er2023.pdf")

            findNavController().navigate(R.id.action_trainingFragment_to_readerFragment, bundle)

        }

        train9Layout.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "tp2023.pdf")

            findNavController().navigate(R.id.action_trainingFragment_to_readerFragment, bundle)

        }

        train10Layout.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "er2024.pdf")

            findNavController().navigate(R.id.action_trainingFragment_to_readerFragment, bundle)

        }

        train11Layout.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "tp2024.pdf")

            findNavController().navigate(R.id.action_trainingFragment_to_readerFragment, bundle)

        }

        return view
    }


    companion object {
        @JvmStatic
        fun newInstance() = TrainingFragment()
    }
}

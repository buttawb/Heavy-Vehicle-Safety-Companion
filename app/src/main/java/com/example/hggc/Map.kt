package com.example.hggc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/**
 * A simple [Fragment] subclass.
 * Use the [Map.newInstance] factory method to
 * create an instance of this fragment.
 */
class Map : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_map, container, false)

        // Find the RelativeLayout with id train1
        val m2 = view.findViewById<RelativeLayout>(R.id.m2)
        val m3 = view.findViewById<RelativeLayout>(R.id.m3)
        val m4 = view.findViewById<RelativeLayout>(R.id.m4)

        val m6 = view.findViewById<RelativeLayout>(R.id.m6)
        val m7 = view.findViewById<RelativeLayout>(R.id.m7)
        val m8 = view.findViewById<RelativeLayout>(R.id.m8)
        val m9 = view.findViewById<RelativeLayout>(R.id.m9)
        val m10 = view.findViewById<RelativeLayout>(R.id.m10)
        val m11 = view.findViewById<RelativeLayout>(R.id.m11)

        val m12 = view.findViewById<RelativeLayout>(R.id.m12)
        val m13 = view.findViewById<RelativeLayout>(R.id.m13)
        val m14 = view.findViewById<RelativeLayout>(R.id.m14)
        val m15 = view.findViewById<RelativeLayout>(R.id.m15)
        val m16 = view.findViewById<RelativeLayout>(R.id.m16)
        val m17 = view.findViewById<RelativeLayout>(R.id.m17)
        val m18 = view.findViewById<RelativeLayout>(R.id.m18)
        val m19 = view.findViewById<RelativeLayout>(R.id.m19)
        val m20 = view.findViewById<RelativeLayout>(R.id.m20)

        m2.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "5.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        m3.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "6.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        m4.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "7.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        m6.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "9.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        m7.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "10.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        m8.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "12.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        m9.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "13.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        m10.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "14.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        m11.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "15.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        m12.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "16.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        m13.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "20.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        m14.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "21.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        m15.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "22.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        m16.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "23.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        m17.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "24.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        m18.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "25.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        m19.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "26.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        m20.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "27.pdf")

            findNavController().navigate(R.id.action_map2_to_readerFragment, bundle)

        }
        return view
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Map.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Map().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
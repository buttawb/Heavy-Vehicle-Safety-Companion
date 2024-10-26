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
        val pdfFileNames = arrayOf(
            "5.pdf", "6.pdf", "7.pdf", "9.pdf", "10.pdf", "12.pdf",
            "13.pdf", "14.pdf", "15.pdf", "16.pdf", "20.pdf",
            "21.pdf", "22.pdf", "23.pdf", "24.pdf", "25.pdf",
            "26.pdf", "27.pdf"
        )

        val layoutIds = arrayOf(
            R.id.m2, R.id.m3, R.id.m4, R.id.m6, R.id.m7, R.id.m8,
            R.id.m9, R.id.m10, R.id.m11, R.id.m12, R.id.m13,
            R.id.m14, R.id.m15, R.id.m16, R.id.m17, R.id.m18,
            R.id.m19, R.id.m20
        )

        // Set animations and navigation for each layout
        for (i in layoutIds.indices) {
            val layout = view.findViewById<RelativeLayout>(layoutIds[i])
            AnimationUtils.setCardClickAnimation(layout, R.id.action_map2_to_readerFragment, Bundle().apply {
                putString("pdfFileName", pdfFileNames[i])
            })
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
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
 * Use the [RestArea.newInstance] factory method to
 * create an instance of this fragment.
 */
class RestArea : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_rest_area, container, false)

        // Find the RelativeLayout with id train1
        val ra1 = view.findViewById<RelativeLayout>(R.id.ra1)
        val ra2 = view.findViewById<RelativeLayout>(R.id.ra2)


        AnimationUtils.setCardClickAnimation(ra1, R.id.action_restArea_to_readerFragment, Bundle().apply {
            putString("pdfFileName", "ra.pdf")
        })

        // Set animations and navigation for ra2
        AnimationUtils.setCardClickAnimation(ra2, R.id.action_restArea_to_readerFragment, Bundle().apply {
            putString("pdfFileName", "lbs.pdf")
        })
        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RestArea.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RestArea().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
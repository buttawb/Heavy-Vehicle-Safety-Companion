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
 * Use the [VideosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VideosFragment : Fragment() {
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val video1 = view.findViewById<RelativeLayout>(R.id.video1)
        val video2 = view.findViewById<RelativeLayout>(R.id.video2)
        val video3 = view.findViewById<RelativeLayout>(R.id.video3)
        val video4 = view.findViewById<RelativeLayout>(R.id.video4)

        video1.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_videosFragment_to_video1Fragment)
        }

        video2.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_videosFragment_to_video2Fragment)
        }

        video3.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_videosFragment_to_video3Fragment)
        }
        video4.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_videosFragment_to_video4Fragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_videos, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment VideosFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VideosFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
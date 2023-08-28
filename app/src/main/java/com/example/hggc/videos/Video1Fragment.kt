package com.example.hggc.videos

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import com.example.hggc.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Video1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Video1Fragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_video1, container, false)

        // Find the VideoView and the "Play" button in your fragment's layout XML.
        val videoView: VideoView = view.findViewById(R.id.videoView)
        val playButton: Button = view.findViewById(R.id.buttonContainer)

        // Set a click listener on the "Play" button to start video playback.
        playButton.setOnClickListener {
            val videoUri =
                Uri.parse("android.resource://" + requireContext().packageName + "/" + R.raw.feuse)
            videoView.setVideoURI(videoUri)

            // Set up media controller for video playback controls.
            val mediaController = MediaController(requireContext())
            mediaController.setAnchorView(videoView)
            videoView.setMediaController(mediaController)

            // Start video playback.
            videoView.start()
            playButton.visibility = View.GONE

        }

        // You can keep any other existing UI elements and code here.

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Video1Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Video1Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
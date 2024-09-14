package com.example.hggc;

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideoPlayer : AppCompatActivity() {
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // No need to set content view here.
        // The VideoView will take up the entire activity.

        videoView = VideoView(this)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        // Retrieve the video URI from the intent extras.
        val videoUriString = intent.getStringExtra("video_uri")

        if (videoUriString != null) {
            val uri: Uri = Uri.parse(videoUriString)
            videoView.setMediaController(mediaController)
            videoView.setVideoURI(uri)
            videoView.requestFocus()
            videoView.start()

            setContentView(videoView) // Set the VideoView as the content view.
        } else {
            // Handle the case where the video URI is not provided.
            // You can display an error message or take appropriate action.
        }
    }
}

package com.example.videoplayerapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // displaying video from Local Storage
        val videoView: VideoView = findViewById(R.id.vvLocalVideo)
//        videoView.setVideoPath(
//            "android.resource://"
//                + packageName
//                + "/"
//                + R.raw.mountains
//        )
        // we can use Uri method instead of setVideoPath()
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.mountains)

        val mediaController = MediaController(this) // this line is must
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(videoUri)
        videoView.requestFocus()

        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.start()
        }


        // displaying video from online source
        val videoView2: VideoView = findViewById(R.id.vvOnlineVideo)
        val onlineUri =
            Uri.parse("https://static.videezy.com/system/resources/previews/000/002/231/original/5226496.mp4")


        val mediaController2 = MediaController(this)
        mediaController2.setAnchorView(videoView2)
        videoView2.setMediaController(mediaController2)
        videoView2.setVideoURI(onlineUri)
        videoView2.requestFocus()

        videoView2.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.start()
        }


    }
}
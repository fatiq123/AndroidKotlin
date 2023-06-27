package com.example.frenchteacherapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sayColorName(view: View) {

        val clickedButton: Button = view as Button

//        val mediaPlayer: MediaPlayer = MediaPlayer.create(
//            this,
//            resources.getIdentifier(
//                clickedButton.tag.toString(),
//                "raw",
//                packageName
//            )
//        )
//        mediaPlayer.start()       it is not good practice to use getIdentifier instead we should use R... method to allocate resources


        val resourceId = when (clickedButton.tag.toString()) {
            "yellow" -> R.raw.yellow
            "red" -> R.raw.red
            "green" -> R.raw.green
            "purple" -> R.raw.purple
            "black" -> R.raw.black
            else -> 0  // Default value in case no match found
        }
        if (resourceId != 0) {
            val mediaPlayer: MediaPlayer = MediaPlayer.create(this, resourceId)
            mediaPlayer.start()
        }
    }
}
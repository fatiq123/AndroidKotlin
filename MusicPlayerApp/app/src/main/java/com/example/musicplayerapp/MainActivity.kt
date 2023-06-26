package com.example.musicplayerapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import java.sql.Time
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {


    // variables
    var startTime = 0.0
    var finalTime = 0.0
    var forwardTime = 10000
    var backwardTime = 10000
    var oneTimeOnly = 0


    // we have to declare them on top because we have to use them in the function updateSongTime()
    private lateinit var tvProgress: TextView
    private lateinit var seekBar: SeekBar

    // media player
    private var mediaPlayer: MediaPlayer? = null


    // handler
    var handler: Handler = Handler()


    private var playbackPosition = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // declaring all buttons
        val btnForward: Button = findViewById(R.id.btnForward)
        val btnBackward: Button = findViewById(R.id.btnBackward)
        val btnPause: Button = findViewById(R.id.btnPause)
        val btnPlay: Button = findViewById(R.id.btnPlay)

        // declaring textView for the timer
        tvProgress = findViewById(R.id.tvProgress)

        // declaring seekbar
        seekBar = findViewById(R.id.sbProgress)

        // declaring textView for song title
        val tvSongTitle: TextView = findViewById(R.id.tvSongTitle)

        // assigning the song to the media player.
        mediaPlayer = MediaPlayer.create(
            this,
            R.raw.astronaut
        )
        seekBar.isClickable = false


        // Adding Functionalities for the buttonskj
        btnPlay.setOnClickListener() {
            mediaPlayer?.start()

            finalTime = mediaPlayer?.duration!!.toDouble()
            startTime = mediaPlayer?.currentPosition!!.toDouble()

            if (oneTimeOnly == 0) {
                seekBar.max = finalTime.toInt()     // assigning the seekBar to the full length of song
                oneTimeOnly = 1     //The oneTimeOnly variable is set to 1 to indicate that the operations inside the conditional statement have been executed and should not be repeated.
            }

            tvProgress.text = startTime.toString()
            seekBar.progress = startTime.toInt()    // The progress of the seekBar is set to startTime.toInt(). It updates the SeekBar's progress based on the current playback time of the song.

            handler.postDelayed(updateSongTime, 100)    //The handler.postDelayed(updateSongTime, 100) line schedules a delayed execution of the updateSongTime Runnable after a 100-millisecond delay. This implies that the updateSongTime Runnable is responsible for updating the song time progress continuously.
        }


        // Setting the music title
        tvSongTitle.text = resources.getResourceEntryName(R.raw.astronaut)


        // Stop Button
        btnPause.setOnClickListener() {
            mediaPlayer?.pause()
        }


        // Forward Button
        btnForward.setOnClickListener() {
            val temp = startTime
            if ((temp + forwardTime) <= finalTime) {
                startTime += forwardTime
                mediaPlayer?.seekTo(startTime.toInt())
            } else {
                Toast.makeText(
                    this,
                    "Can't Jump forward", Toast.LENGTH_LONG
                ).show()
            }
        }

        btnBackward.setOnClickListener() {
            val temp = startTime.toInt()

            if ((temp - backwardTime) > 0) {
                startTime -= backwardTime
                mediaPlayer?.seekTo(startTime.toInt())
            } else {
                Toast.makeText(
                    this,
                    "Can't Jump backward",
                    Toast.LENGTH_LONG
                ).show()
            }
        }


    }

    // Creating the Runnable
    private val updateSongTime: Runnable = object : Runnable {
        override fun run() {
            startTime = mediaPlayer?.currentPosition!!.toDouble()
            tvProgress.text = "" +
                    String.format(
                        "%d min , %d sec",
                        TimeUnit.MILLISECONDS.toMinutes(startTime.toLong()),
                        TimeUnit.MILLISECONDS.toSeconds(
                            startTime.toLong()
                                    - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(
                                    startTime.toLong()
                                )
                            )
                        )
                    )


            seekBar.progress = startTime.toInt()
            handler.postDelayed(this, 100)

        }

    }


//    private fun playAudio(view: View) {
//        if (mediaPlayer == null) {
//            mediaPlayer = MediaPlayer.create(this, R.raw.astronaut)
//            mediaPlayer?.setOnCompletionListener {
//                releaseMediaPlayer()
//            }
//        }
//
//        mediaPlayer?.apply {
//            start()
//        }
//    }
//
//    private fun pauseAudio(view: View) {
//        mediaPlayer?.apply {
//            if (isPlaying) {
//                playbackPosition = currentPosition
//                pause()
//            }
//        }
//    }
//
//    fun resumeAudio(view: View) {
//        mediaPlayer?.apply {
//            if (!isPlaying) {
//                seekTo(playbackPosition)
//                start()
//            }
//        }
//    }
//
//    private fun backwardAudio(view: View) {
//        mediaPlayer?.apply {
//            playbackPosition -= 5000 // Move 5 seconds backward
//            if (playbackPosition < 0) {
//                playbackPosition = 0
//            }
//            seekTo(playbackPosition)
//        }
//    }
//
//    private fun forwardAudio(view: View) {
//        mediaPlayer?.apply {
//            playbackPosition += 5000 // Move 5 seconds forward
//            val duration = duration
//            if (playbackPosition > duration) {
//                playbackPosition = duration
//            }
//            seekTo(playbackPosition)
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()
        releaseMediaPlayer()
    }

    private fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
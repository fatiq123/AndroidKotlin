package com.example.luckynumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import kotlin.random.nextInt

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)

        // declaring the views
        val tvLuckyNumber: TextView = findViewById(R.id.tvLuckyNumber)
        val btnShareLuck: Button = findViewById(R.id.btnShareLuck)


        val userName = receiveUserName()
        val randomNumber = generateRandomNumber()

        // to set the text of luckyNumber to the generated random number
        tvLuckyNumber.setText(""+randomNumber)


        // button to share result
        btnShareLuck.setOnClickListener {
            // we can remove this extra check by just adding .toString() to receiveUserName()
            // it is saying that if userName is not null then pass it to function
            if (userName != null) {
                shareData(userName,randomNumber)
            }
        }
    }


    // function to get name from previous activity
    private fun receiveUserName(): String? {
//        val bundle: Bundle? = intent.extras
//        return bundle?.get("EXTRA_NAME").toString()
        return intent.getStringExtra("EXTRA_NAME")

    }

    // function to generate random number
    private fun generateRandomNumber(): Int {
        return Random.nextInt(0..100)
    }

    // function for sharing user name and data
    private fun shareData(userName: String, number: Int){
        // implicit intent
        val i: Intent = Intent(Intent.ACTION_SEND)
        i.type = "text/plain"
        i.putExtra(Intent.EXTRA_SUBJECT,"$userName is lucky today")
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is $number")
        startActivity(i)
    }
}
package com.example.explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.btnNextActivity)

        btn.setOnClickListener {

            // explicit intent
            val i: Intent = Intent(this, SecondActivity::class.java)

            // passing data between activities
            i.putExtra("age",20)

            startActivity(i)
        }
    }
}
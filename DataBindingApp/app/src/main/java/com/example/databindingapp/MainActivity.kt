package com.example.databindingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.databindingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


//        val tvShowName: TextView = findViewById(R.id.textView)
//        val etEnterName: EditText = findViewById(R.id.etName)
//        val btnShowName: Button = findViewById(R.id.btnShowName)


        // we can directly use .apply function to avoid binding keyword in code
        binding.apply {
            btnShowName.setOnClickListener {

                textView.text = etName.text.toString()
            }
        }




    }
}
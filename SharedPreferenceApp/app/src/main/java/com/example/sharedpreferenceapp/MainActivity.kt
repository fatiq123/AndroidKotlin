package com.example.sharedpreferenceapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Note i would prefer to check the code and method of Philip Lackner as he has explained it very well.


    private lateinit var tvShowName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName: EditText = findViewById(R.id.etEnterName)
        tvShowName = findViewById(R.id.tvShowName)
        val btnSave: Button = findViewById(R.id.btnSave)


        displaySavedName()

        btnSave.setOnClickListener{

            val enteredName = etName.text.toString()
            saveNameInSharedPreference(enteredName)
        }
    }

    // save function
    private fun saveNameInSharedPreference(enteredName: String) {

        // initializing the shared preference
        val sharedPreferences: SharedPreferences = getSharedPreferences("EXTRA_NAME", MODE_PRIVATE)

        // writing the data to shared preference
        val editor: SharedPreferences.Editor? = sharedPreferences.edit()
        editor?.putString("name",enteredName)
            ?.apply()
    }

    // load function
    private fun displaySavedName(){
        val sharedPreferences: SharedPreferences = getSharedPreferences("EXTRA_NAME", MODE_PRIVATE)

        val s1: String? = sharedPreferences.getString("name", "")

        tvShowName.text = s1
    }
}
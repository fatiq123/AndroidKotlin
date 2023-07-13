package com.example.journalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.journalapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: com.example.journalapp.databinding.ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }
}
package com.example.journalapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.journalapp.JournalList
import com.example.journalapp.R
import com.example.journalapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Initialize Firebase Auth
        auth = Firebase.auth



        binding.createAccountButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }


        // Now if the user exists and wants to sign in directly then
        binding.emailSignInButton.setOnClickListener {
            loginWithEmailPassword(
                // ham an editTexts sa email aur password lena to ha tab hi ham user login karwa sakan ga
                binding.email.text.toString().trim(),
                binding.password.text.toString().trim()
            )
        }


    }

    private fun loginWithEmailPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)

            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful) {
                    gotoJournalList()
                } else {
                    Toast.makeText(
                        this,
                        "Authentication failed",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }

            }
    }


    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser

        if (currentUser != null) {
            // yani user pehla hi login ha aur us ko JournalList page pa redirect kar dia jaya ga
            gotoJournalList()
        }
    }

    private fun gotoJournalList() {
        val intent = Intent(this, JournalList::class.java)
        startActivity(intent)
    }
}
package com.example.firebaseapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)

        // real time database reference
        database = Firebase.database.reference

        // Write data to firebase
        database.child("Price").setValue(100)



        // Read data to firebase
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                val landPrice = dataSnapshot.value
                textView.text = landPrice.toString()
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        // very important line to read data from firebase
        database.child("Price").addValueEventListener(postListener)
    }
}
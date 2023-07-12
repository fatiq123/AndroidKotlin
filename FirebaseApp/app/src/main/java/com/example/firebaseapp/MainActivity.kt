package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val textView2: TextView = findViewById(R.id.textView2)

        // real time database reference
        database = Firebase.database.reference




        // Write data to firebase
        database.child("Price").setValue(100)


        // Read data from firebase
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








        // Writing custom objects to firebase

        val user1 = User("fatiq","123")

        database.child("Users").setValue(user1)


        // Reading custom objects from firebase
        val readFromFirebase = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val post = snapshot.getValue<User>()
                textView2.text = post.toString()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }

        database.child("Users").addValueEventListener(readFromFirebase)
    }
}
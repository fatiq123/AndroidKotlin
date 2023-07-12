package com.example.firebaseapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val textView2: TextView = findViewById(R.id.textView2)
        val textView3: TextView = findViewById(R.id.textView3)

        // real time database reference
        database = Firebase.database.reference

        /* Realtime database starts from here */


        // ---------------------------------------Write data to firebase-----------------------------
        database.child("Price").setValue(100)


        //----------------------------------------Read data from firebase-----------------------------
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


        //--------------------------------- Writing custom objects to firebase------------------------

        val user = User("fatiq", "123")

        database.child("Users").setValue(user)


        //--------------------------------Reading custom objects from firebase-----------------------
        val readFromFirebase = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val post = snapshot.getValue<User>()
                textView2.text = post.toString()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }

        database.child("Users").addValueEventListener(readFromFirebase)







        /* Firestore database starts from here */


        // Firestore instance
        val db = Firebase.firestore

        // ---------------------------------Add data-------------------------------------------------

        // Creating a collection
        val usersCollection = db.collection("User")

        // Create a new user with a first and last name
        val user1 = hashMapOf(
            "first" to "Ada",
            "second" to "Lovelace",
            "born" to 1815
        )
        // Create a new user with a first, middle, and last name
        val user2 = hashMapOf(
            "first" to "Alan",
            "middle" to "Mathison",
            "last" to "Turing",
            "born" to 1912,
        )

        // Add a new document with a generated ID
        db.collection("User")
            .add(user1)
        db.collection("User")
            .add(user2)

        // Adding Documents to Collections
        // db.document("user1").set(user1)   // this is a more line and doing the same thing as above line do
        //db.document("user2").set(user2)


        // ------------------------------------Read data--------------------------------------------

        db.collection("User")
            .get()
            .addOnSuccessListener { result ->

//                if (result != null) {
//                    textView3.text = "${result.metadata}"
//                }
                var allDocuments: String = ""   // to get all documents from collection
                for (document in result) {
                    allDocuments += "${document.data} "+" \n"
                    allDocuments += "\n"
                }
                textView3.text = allDocuments
            }
            .addOnFailureListener {
                Toast.makeText(
                    this,
                    "Unknown exception",
                    Toast.LENGTH_LONG
                ).show()
            }







        //-------------------------------Update Data to Firestore Database---------------------------

        db.collection("User").document().update("first", "fatiq")
        // i am not applying this change as i don't want to change their names


        //-------------------------------Delete Data to Firestore Database---------------------------

        db.collection("User").document().delete()
    }
}
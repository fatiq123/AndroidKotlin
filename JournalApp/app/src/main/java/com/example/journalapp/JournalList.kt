package com.example.journalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.journalapp.adapter.JournalAdapter
import com.example.journalapp.databinding.ActivityJournalListBinding
import com.example.journalapp.model.Journal
import com.example.journalapp.view.AddJournalActivity
import com.example.journalapp.view.SignInActivity
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference


class JournalList : AppCompatActivity() {

    private lateinit var binding: ActivityJournalListBinding    // declare binding

    // Firebase References
    private lateinit var firebaseAuth: FirebaseAuth     // Authentication
    private lateinit var firebaseUser: FirebaseUser     // Authentication
    private val db = FirebaseFirestore.getInstance()            // Firestore database

    private lateinit var storageReference: StorageReference     // Storage

    private lateinit var journalList: MutableList<Journal>         // List of Journal
    private lateinit var adapter: JournalAdapter

    private var collectionReference: CollectionReference =
        db.collection("Journal") // Firestore Collection

    private lateinit var noPostTextView: TextView       // for textView to show how much posts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_journal_list)


        // Firebase Auth
        firebaseAuth = Firebase.auth
        firebaseUser = firebaseAuth.currentUser!!

        // RecyclerView
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Posts ArrayList
        journalList = arrayListOf<Journal>()



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.add -> if (firebaseAuth != null && firebaseUser != null) {
                val intent = Intent(this, AddJournalActivity::class.java)
                startActivity(intent)
            }

            R.id.sign_out -> if (firebaseAuth != null && firebaseUser != null) {
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    // Getting all posts
    override fun onStart() {
        super.onStart()


        collectionReference.whereEqualTo("userId", firebaseUser.uid)
            .get()
            .addOnSuccessListener {
                if (!it.isEmpty) {

                    // simple we just adding these things to collection
                    for (document in it) {
                        val journal = Journal(
                            document.data["title"].toString(),
                            document.data["thoughts"].toString(),
                            document.data["imageUrl"].toString(),
                            document.data["userId"].toString(),
                            document.data["timeAdded"] as Timestamp,
                            document.data["username"].toString(),

                        )

                        journalList.add(journal)
                    }



                    // RecyclerView
                    adapter = JournalAdapter(
                        this,
                        journalList = journalList
                    )

                    binding.recyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()
                } else {
                    noPostTextView.visibility = View.VISIBLE
                }
            }
            .addOnFailureListener {
                Toast.makeText(
                    this,
                    "OOPs, Something went wrong",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
    }
}
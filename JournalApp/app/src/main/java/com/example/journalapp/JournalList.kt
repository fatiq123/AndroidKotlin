package com.example.journalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.journalapp.adapter.JournalAdapter
import com.example.journalapp.databinding.ActivityJournalListBinding
import com.example.journalapp.model.Journal
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage

class JournalList : AppCompatActivity() {

    private lateinit var binding: ActivityJournalListBinding    // declare binding

    // Firebase References
    private lateinit var firebaseAuth: FirebaseAuth     // Authentication
    private lateinit var firebaseUser: FirebaseUser     // Authentication
    private val db = FirebaseFirestore.getInstance()            // Firestore database

    private lateinit var storageReference: StorageReference     // Storage

    private lateinit var journalList: List<Journal>         // List of Journal
    private lateinit var adapter: JournalAdapter

    private var collectionReference: CollectionReference = db.collection("Journal") // Firestore Collection

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

        val storage = Firebase.storage("gs://journalapp-e1e05.appspot.com")





    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
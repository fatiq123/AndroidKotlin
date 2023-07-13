package com.example.journalapp.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.journalapp.JournalList
import com.example.journalapp.JournalUser
import com.example.journalapp.R
import com.example.journalapp.databinding.ActivityAddJournalBinding
import com.example.journalapp.model.Journal
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.Date

class AddJournalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddJournalBinding

    // Credentials
    var currentUserId: String = ""
    var currentUserName: String = ""

    // Firebase
    lateinit var auth: FirebaseAuth
    lateinit var user: FirebaseUser

    // Firestore Firebase
    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()

    // Storage
    lateinit var storageReference: StorageReference

    // Collection
    var collectionReference: CollectionReference = db.collection("Journal")

    // image
    lateinit var imageUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_journal)

        // initialize Storage
        storageReference = FirebaseStorage.getInstance().reference

        // initialize Auth
        auth = FirebaseAuth.getInstance()



        binding.apply {
            postProgressBar.visibility = View.INVISIBLE

            if (JournalUser.instance != null) {
                currentUserId = JournalUser.instance!!.userId.toString()
                currentUserName = JournalUser.instance!!.username.toString()

                postUsernameTextview.text = currentUserName
            }

            // getting image from gallery
            postCameraButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_GET_CONTENT)
                intent.type = "image/*"
                startActivityForResult(intent, 1)
                // this refers to onActivityResult() written below
            }


            postSaveJournalButton.setOnClickListener {
                saveJournal()
            }
        }

    }

    private fun saveJournal() {
        val title = binding.postTitleEt.text.toString().trim()
        val thoughts = binding.postDescriptionEt.text.toString().trim()

        binding.postProgressBar.visibility = View.VISIBLE

        if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(thoughts) && imageUri != null) {
            // Note: !isEmpty() is equivalent to isNotEmpty()

            // Saving the path of images in Storage
            // .../journal_images/our_image.png
            val filePath: StorageReference = storageReference
                .child("journal_images")
                .child("my_image_" + Timestamp.now().seconds)

            // Uploading the Images
            filePath.putFile(imageUri)
                .addOnSuccessListener {
                    filePath.downloadUrl.addOnSuccessListener {

                        val imageUri: String = it.toString()
                        val timestamp: Timestamp = Timestamp(Date())

                        // creating the object of Journal
                        val journal: Journal = Journal(
                            title = title,
                            thoughts = thoughts,
                            imageUrl = imageUri,
                            userId = currentUserId,
                            timeAdded = timestamp,
                            username = currentUserName
                        )

                        // adding a new journal
                        collectionReference.add(journal)
                            .addOnSuccessListener {
                                binding.postProgressBar.visibility = View.INVISIBLE

                                val intent: Intent = Intent(this, JournalList::class.java)
                                startActivity(intent)
                                finish()
                            }
                            .addOnFailureListener {
                                binding.postProgressBar.visibility = View.INVISIBLE
                            }
                    }
                }
        } else {
            binding.postProgressBar.visibility = View.VISIBLE
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                imageUri = data.data!!  // getting the actual image path
                binding.postImageView.setImageURI(imageUri) // showing the image
            }
        }
    }

    override fun onStart() {
        super.onStart()

        user = auth.currentUser!!
    }

    override fun onStop() {
        super.onStop()
    }
}
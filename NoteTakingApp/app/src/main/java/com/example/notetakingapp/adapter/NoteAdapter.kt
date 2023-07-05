package com.example.notetakingapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notetakingapp.R
import com.example.notetakingapp.databinding.NoteLayoutBinding
import com.example.notetakingapp.fragments.HomeFragmentDirections
import com.example.notetakingapp.model.Note
import java.util.*

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {


    inner class NoteViewHolder(val itemBinding: NoteLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


    }

    // main purpose is to calculate updates for the recyclerView adapter and display things when we need to restart, delete, update
    // it will make operations faster and smooth
    //The DiffUtil class is a utility provided by the Android Jetpack library. It is commonly used in conjunction
    //with RecyclerView to efficiently update the contents of a list or grid when the underlying data changes.
    private val differCallBack = object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.noteTitle == newItem.noteTitle &&
                    oldItem.noteBody == newItem.noteBody
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem   // returns if there exists an same item in database or recycler view then return newOne equal to oldOne
        }

    }

    //Overall, using AsyncListDiffer simplifies the process of updating a RecyclerView's data set with
    // diff calculations and automatically dispatching the necessary updates to the adapter.
    // It helps to optimize the UI updates, keep the data in sync, and maintain a smooth user experience.
    val differ = AsyncListDiffer(this, differCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
//        return NoteViewHolder(
//            NoteLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        )
        // we can use above code instead of this
        val inflater = LayoutInflater.from(parent.context)
        val binding: NoteLayoutBinding =
            DataBindingUtil.inflate(inflater, R.layout.note_layout, parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = differ.currentList[position]

        holder.itemBinding.tvNoteTitle.text = currentNote.noteTitle
        holder.itemBinding.tvNoteBody.text = currentNote.noteBody


        // to display color in note
        val random = Random()
        val color = Color.argb(
            255,
            random.nextInt(256),
            random.nextInt(256),
            random.nextInt(256)
        )


        holder.itemBinding.ibColor.setBackgroundColor(color)    // assigns the color to the View background

        holder.itemView.setOnClickListener {
            val direction =
                HomeFragmentDirections.actionHomeFragmentToUpdateNoteFragment(currentNote)

            it.findNavController().navigate(direction)
        }
    }


}
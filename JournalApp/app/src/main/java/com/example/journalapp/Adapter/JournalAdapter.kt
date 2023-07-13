package com.example.journalapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.journalapp.R
import com.example.journalapp.databinding.ActivityJournalListBinding
import com.example.journalapp.model.Journal

class JournalAdapter(private val context: Context, var journalList: List<Journal>) :
    RecyclerView.Adapter<JournalAdapter.MyViewHolder>() {

    private lateinit var binding: ActivityJournalListBinding


    inner class MyViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_journal_list, parent, false)
        return MyViewHolder(itemView = view, context = context)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}


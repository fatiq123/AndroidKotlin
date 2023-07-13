package com.example.journalapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.journalapp.databinding.JournalCardViewBinding
import com.example.journalapp.model.Journal

class JournalAdapter(private val context: Context, var journalList: List<Journal>) :
    RecyclerView.Adapter<JournalAdapter.MyViewHolder>() {

    lateinit var binding: JournalCardViewBinding


    inner class MyViewHolder(var binding: JournalCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(journal: Journal) {
            binding.journal = journal
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.activity_journal_list, parent, false)

        // we use data binding instead of layout inflater
        binding = JournalCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return journalList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val journal: Journal = journalList[position]

        holder.bind(journal = journal)
    }


}


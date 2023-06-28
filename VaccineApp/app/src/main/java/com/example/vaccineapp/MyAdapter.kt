package com.example.vaccineapp

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val vaccinesList: ArrayList<VaccineModel>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var image: ImageView
        lateinit var title: TextView

        init {
            image = itemView.findViewById(R.id.ivVaccineImage)
            title = itemView.findViewById(R.id.tvVaccineTitle)

            itemView.setOnClickListener(){
                Toast.makeText(itemView.context,
                "You Choose: ${vaccinesList[adapterPosition].name}",
                Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return vaccinesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val data = vaccinesList[position]
//        holder.title.text = data.toString()

        holder.title.text = vaccinesList[position].name
        holder.image.setImageResource(vaccinesList[position].image)
    }
}
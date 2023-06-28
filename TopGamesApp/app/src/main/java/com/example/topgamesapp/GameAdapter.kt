package com.example.topgamesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(private val gamesList: ArrayList<GameModel>) :
    RecyclerView.Adapter<GameAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var gameImage: ImageView
        var gameTitle: TextView

        init {
            gameImage = itemView.findViewById(R.id.ivGameImage)
            gameTitle = itemView.findViewById(R.id.tvGameTitle)


            // to show toast when user touches that particular game
            itemView.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    "You Choose: ${gamesList[adapterPosition].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.gameImage.setImageResource(gamesList[position].image)
        holder.gameTitle.text = gamesList[position].title
    }
}

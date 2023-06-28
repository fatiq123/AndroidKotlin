package com.example.topgamesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // As we know that there are 3 steps for adapters i.e ListView,RecyclerView,CArdView


        // 1. AdapterView: RecyclerView (CardView) in this case
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )


        // 2. Data Source:  List of game objects
        val gamesList: ArrayList<GameModel> = ArrayList()

        val game1 = GameModel(
            R.drawable.card1,
            "Horizon Chase Turbo"
        )
        val game2 = GameModel(
            R.drawable.card2,
            "PUBG"
        )
        val game3 = GameModel(
            R.drawable.card3,
            "Head Ball"
        )
        val game4 = GameModel(
            R.drawable.card4,
            "Hooked On You"
        )
        val game5 = GameModel(
            R.drawable.card5,
            "Fifa 22"
        )
        val game6 = GameModel(
            R.drawable.card6,
            "Fortnite"
        )


        gamesList.add(game1)
        gamesList.add(game2)
        gamesList.add(game3)
        gamesList.add(game4)
        gamesList.add(game5)
        gamesList.add(game6)


        // 3. Adapter   to connect AdapterView and Data Source
        val adapter = GameAdapter(gamesList)
        recyclerView.adapter = adapter
    }
}